const API_BASE = '' // mesma origem

/* ------------------ Helpers ------------------ */
async function api(path, options) {
  const res = await fetch(path, options);
  let text = await res.text();
  try { return { ok: res.ok, status: res.status, body: JSON.parse(text) } } catch(e) { return { ok: res.ok, status: res.status, body: text } }
}

/* ------------------ Users ------------------ */
async function loadUsers() {
  const el = document.getElementById('users-list');
  if (!el) return;
  el.innerHTML = 'Carregando...';
  const r = await api('/user');
  if (!r.ok) { el.innerHTML = `<div class="muted">Erro ou lista vazia (${r.status})</div>`; return }
  const users = r.body;
  if (!Array.isArray(users) || users.length === 0) { el.innerHTML = '<div class="muted">Nenhum usuário encontrado.</div>'; return }
  el.innerHTML = '';
  users.forEach(u => {
    const row = document.createElement('div');
    row.className = 'list-item';
    row.innerHTML = `<div><strong>${u.nome}</strong><div class="muted">${u.email}</div></div>`;
    const actions = document.createElement('div');
    actions.className = 'actions';
    const btnDel = document.createElement('button'); btnDel.textContent='Excluir'; btnDel.onclick = async ()=>{
      if(!confirm('Excluir usuário '+u.email+'?')) return;
      const d = await api('/user/' + encodeURIComponent(u.email), { method: 'DELETE' });
      alert(d.body || ('Status: '+d.status)); loadUsers();
    };
    const btnEdit = document.createElement('button'); btnEdit.textContent='Editar'; btnEdit.style.background='#2563eb'; btnEdit.onclick = ()=>{
      document.getElementById('user-nome').value = u.nome; document.getElementById('user-email').value = u.email;
    };
    actions.appendChild(btnEdit); actions.appendChild(btnDel);
    row.appendChild(actions);
    el.appendChild(row);
  });
}

async function handleUserForm(e) {
  e.preventDefault();
  const nome = document.getElementById('user-nome').value.trim();
  const email = document.getElementById('user-email').value.trim();
  const password = document.getElementById('user-password').value;
  const payload = { nome, email, password };
  const r = await api('/user', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload) });
  alert(r.body || ('Status: '+r.status));
  if (r.ok) { document.getElementById('user-form').reset(); loadUsers(); }
}

async function handleLoginForm(e){
  e.preventDefault();
  const email = document.getElementById('login-email').value.trim();
  const password = document.getElementById('login-password').value;
  const r = await api('/user/login', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify({ email, password }) });
  const el = document.getElementById('login-result');
  if (r.ok) { el.textContent = 'Login OK'; el.style.color='green'; } else { el.textContent = r.body || ('Status: '+r.status); el.style.color='red'; }
}

/* ------------------ Tasks ------------------ */
async function loadTasks() {
  const el = document.getElementById('tasks-list');
  if (!el) return;
  el.innerHTML = 'Carregando...';
  const r = await api('/task');
  if (!r.ok) { el.innerHTML = `<div class="muted">Erro ou lista vazia (${r.status})</div>`; return }
  const tasks = r.body;
  if (!Array.isArray(tasks) || tasks.length === 0) { el.innerHTML = '<div class="muted">Nenhuma tarefa encontrada.</div>'; return }
  el.innerHTML = '';
  tasks.forEach(t => {
    const row = document.createElement('div');
    row.className = 'list-item';
    row.innerHTML = `<div><strong>${t.titulo}</strong>
      <div class="muted">${t.descricao} — ${t.dataAgendamento} — status:${t.status} — ${t.emailUsuario || (t.usuario && t.usuario.email) || ''}</div>
    </div>`;
    const actions = document.createElement('div');
    actions.className = 'actions';
    const btnDel = document.createElement('button'); btnDel.textContent='Excluir'; btnDel.onclick = async ()=>{
      if(!confirm('Excluir tarefa '+t.id+'?')) return;
      const d = await api('/task/' + t.id, { method: 'DELETE' });
      alert(d.body || ('Status: '+d.status)); loadTasks();
    };
    const btnEdit = document.createElement('button'); btnEdit.textContent='Editar'; btnEdit.style.background='#2563eb'; btnEdit.onclick = ()=>{
      document.getElementById('task-id').value = t.id || '';
      document.getElementById('task-titulo').value = t.titulo || '';
      document.getElementById('task-descricao').value = t.descricao || '';
      document.getElementById('task-data').value = t.dataAgendamento || '';
      document.getElementById('task-status').value = t.status || '1';
      document.getElementById('task-email').value = t.emailUsuario || (t.usuario && t.usuario.email) || '';
    };
    actions.appendChild(btnEdit); actions.appendChild(btnDel);
    row.appendChild(actions);
    el.appendChild(row);
  });
}

async function handleTaskForm(e) {
  e.preventDefault();
  const id = document.getElementById('task-id').value.trim();
  const titulo = document.getElementById('task-titulo').value.trim();
  const descricao = document.getElementById('task-descricao').value.trim();
  const dataAgendamento = document.getElementById('task-data').value;
  const status = parseInt(document.getElementById('task-status').value, 10);
  const emailUsuario = document.getElementById('task-email').value.trim();
  const payload = { titulo, descricao, dataAgendamento, status, emailUsuario };
  let r;
  if (id) {
    r = await api('/task/' + id, { method: 'PUT', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload) });
  } else {
    r = await api('/task', { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload) });
  }
  alert(r.body || ('Status: '+r.status));
  if (r.ok) { document.getElementById('task-form').reset(); loadTasks(); }
}

function clearTaskForm(){ document.getElementById('task-form').reset(); document.getElementById('task-id').value=''; }

/* ------------------ Init binding ------------------ */
document.addEventListener('DOMContentLoaded', ()=>{
  const uf = document.getElementById('user-form'); if (uf) uf.addEventListener('submit', handleUserForm);
  const lf = document.getElementById('login-form'); if (lf) lf.addEventListener('submit', handleLoginForm);
  const tf = document.getElementById('task-form'); if (tf) tf.addEventListener('submit', handleTaskForm);
  const tc = document.getElementById('task-clear'); if (tc) tc.addEventListener('click', clearTaskForm);
  loadUsers(); loadTasks();
});

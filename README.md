
# ⚔️ Guerra de Bugs – Java + Spring Boot + Thymeleaf

Bem-vindos à **Guerra de Bugs**, uma atividade prática e competitiva que coloca as equipes no papel de **testadores e desenvolvedores** de sistemas reais criados pelos próprios colegas!  
O objetivo é testar, documentar e corrigir falhas de forma colaborativa, aplicando os conceitos de **Testes de Software**, **qualidade de código** e **validação com evidências**.  

---

## 🎯 Objetivos
- Desenvolver o olhar crítico sobre código de terceiros.  
- Aplicar técnicas de teste exploratório e documentação de bugs.  
- Exercitar boas práticas de correção, versionamento e trabalho em equipe.  
- Estimular a autonomia, a análise técnica e a empatia profissional (testar e ser testado).  

---

## 🧩 Estrutura da Atividade

### 🔁 Etapa 1 – Troca de Projetos
Cada equipe entrega sua última versão funcional do projeto (**Java + Spring + Thymeleaf**).  
A professora redistribui os projetos entre as equipes — cada grupo agora é **testador** de outro projeto.

---

### 🧪 Etapa 2 – Caça aos Bugs
Os testadores devem:
1. Executar o projeto recebido.  
2. Tentar reproduzir erros funcionais, visuais ou lógicos.  
3. Registrar cada bug usando o modelo:  
   - `01-template_relato_bug.md`  

⚠️ **Não é permitido corrigir o código de outro grupo!**  
O papel é **testar, documentar e evidenciar**.

---

### 🔧 Etapa 3 – Correção pelos Donos
Após o registro dos bugs:
1. A equipe **dona do projeto** analisa e corrige cada erro.
2. Cada correção deve ser submetida como Pull Request, usando o modelo:
   - `02-template_pr_correcao.md`  
3. É fundamental apresentar **evidências de teste** (print, log ou teste automatizado).

---

### ✅ Etapa 4 – Validação e Placar Final
A equipe que encontrou o bug deve **validar a correção**.  
Um **Kanban** (físico ou digital) será usado para acompanhar o progresso.

#### 📋 Colunas do Kanban:
- 🟡 **Pendente** – bug encontrado, aguardando confirmação.  
- 🔵 **Em Teste** – bug sendo reproduzido.  
- 🟣 **Bug Replicado** – confirmado e registrado.  
- 🟢 **Corrigido** – PR enviado e aguardando validação.  
- 🟤 **Validado** – bug resolvido e testado com sucesso.

#### 💡 Sugestão de cores:
| Tipo de Bug | Cor do post-it |
|--------------|----------------|
| Funcionalidade quebrada | Amarelo |
| Template / Thymeleaf | Rosa |
| Validação / API | Azul |
| Banco de dados / SQL | Verde |
| Interface / UX | Laranja |

---

## 🧮 Sistema de Pontuação

### 🏆 Troféu “Projeto Mais Sólido”
O projeto com **menos bugs válidos encontrados** vence.  
| Tipo de Bug | Pontos |
|--------------|--------|
| Crítico (500, NPE, SQL, login, etc.) | 3 pts |
| Médio (validação, regra de negócio) | 2 pts |
| Leve (UX, mensagem, layout) | 1 pt |

➡️ **Menos pontos = melhor projeto.**

---

### 🏅 Troféu “Mão na Graxa”
Reconhece as equipes que **corrigem e validam mais bugs**.  
| Ação | Pontos |
|------|--------|
| Correção validada | +2 pts |
| Correção com teste automatizado | +1 pt extra |

---

## 💾 Materiais de Apoio
| Arquivo | Descrição |
|----------|------------|
| [`01-template_relato_bug.md`](01-template_relato_bug.md) | Modelo de relatório de bug |
| [`02-template_pr_correcao.md`](02-template_pr_correcao.md) | Modelo de Pull Request de correção |
| [`03-placar_guerra_de_bugs.csv`](03-placar_guerra_de_bugs.csv) | Planilha para contagem de pontos |
| [`04-kanban_para_quadro.md`](04-kanban_para_quadro.md) | Modelo impresso do Kanban físico |

---

## 🧠 Boas Práticas
- Reproduza o bug antes de tentar corrigir.  
- Faça commits pequenos e claros (`fix: validação de email`, `test: média com array vazio`).  
- Use mensagens significativas no Git e PRs descritivas.  
- Respeite o código dos colegas: foco na melhoria, não na crítica.  

---

## 🏁 Critérios de Desempate
1. Menor número de bugs críticos.  
2. Maior número de correções validadas.  
3. Menor tempo total de encerramento no Kanban.  

---

## 💬 Retro Final
Fecharemos com uma roda de conversa:
> “O que aprendi testando e sendo testado?”  
> “Quais práticas de qualidade eu levo para meus próximos projetos?”

---

**Professora:** Karize  
**Curso:** Técnico em Desenvolvimento de Sistemas – SENAI  
**Metodologia:** Aprendizagem Ativa e Colaborativa  
**Duração:** 4h  

> *“Quem testa bem, programa melhor.”* 💡

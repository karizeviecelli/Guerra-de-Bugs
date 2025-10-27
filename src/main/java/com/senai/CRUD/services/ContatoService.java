package com.senai.CRUD.services;

import com.senai.CRUD.dtos.RequisicaoContatoDto;
import com.senai.CRUD.dtos.RespostaContatoDto;
import com.senai.CRUD.exceptions.ContatoNotFound;
import com.senai.CRUD.exceptions.EmailExistException;
import com.senai.CRUD.models.CidadeModel;
import com.senai.CRUD.models.ContatoModel;
import com.senai.CRUD.repositories.CidadeRepository;
import com.senai.CRUD.repositories.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
   private final ContatoRepository contatoRepository;
   private final CidadeRepository cidadeRepository;

    public ContatoService(ContatoRepository contatoRepository, CidadeRepository cidadeRepository) {
        this.contatoRepository = contatoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public boolean CadastrarContato(RequisicaoContatoDto dados){
        if (!existEmail(dados.getEmail())) {
            CidadeModel cidade = cidadeRepository.findByNome(dados.getCidade()).get();
            ContatoModel contato = new ContatoModel();
            contato.setNome(dados.getNome());
            contato.setEmail(dados.getEmail());
            contato.setTelefone(dados.getTelefone());
            contato.setCidade(cidade);
            contatoRepository.save(contato);
            return true;
        }
        throw new EmailExistException("Já possui um contato com esse email");
    }
    public List<RespostaContatoDto> listaContatos(){
        List<ContatoModel> contatos = contatoRepository.findAll();
        List<RespostaContatoDto> resposta = new ArrayList<>();
        for (ContatoModel contato : contatos) {
            resposta.add(new RespostaContatoDto(contato));
        }
        return resposta;
    }
    public boolean existEmail(String email){
        Optional<ContatoModel> contato = contatoRepository.findByEmail(email);
        if(contato.isPresent()){
            return true;
        }
        return false;
    }
    public boolean deletarContato(long id){
        Optional<ContatoModel> contato = contatoRepository.findById(id);
        if(contato.isPresent()){
            contatoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public boolean atualizarContato(RequisicaoContatoDto dados,long id){
        CidadeModel cidade = cidadeRepository.findByNome(dados.getCidade()).get();

        Optional<ContatoModel> emailAtualizar = contatoRepository.findByEmail(dados.getEmail());

        Optional<ContatoModel> contatoAntigo = contatoRepository.findById(id);

        boolean atualizar = false;

        if(emailAtualizar.isPresent()){
            if(emailAtualizar.get().getId().equals(id)){
                atualizar = true;
            }else {
                throw new EmailExistException("Já possui um contato com esse email");
            }

        }else {
            atualizar = true;
        }
        if(atualizar){
            ContatoModel contato = new ContatoModel();
            contato.setId(id);
            contato.setNome(dados.getNome());
            contato.setEmail(dados.getEmail());
            contato.setTelefone(dados.getTelefone());
            contato.setCidade(cidade);
            contatoRepository.save(contato);
            return true;
        }

        return false;
    }

    public RespostaContatoDto listarContatoById(long id){
        Optional<ContatoModel>contato = contatoRepository.findById(id);
        if (contato.isPresent()) {
            return new RespostaContatoDto();
        }
        throw new ContatoNotFound();
    }
}

package com.senai.CRUD.services;

import com.senai.CRUD.dtos.RequisicaoCidadeDto;
import com.senai.CRUD.dtos.RespostaCidadeDto;
import com.senai.CRUD.exceptions.CidadeExistenteException;
import com.senai.CRUD.exceptions.CidadenotFound;
import com.senai.CRUD.exceptions.EstadoNotFoundException;
import com.senai.CRUD.models.CidadeModel;
import com.senai.CRUD.models.EstadoModel;
import com.senai.CRUD.repositories.CidadeRepository;
import com.senai.CRUD.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public CidadeService(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.estadoRepository = estadoRepository;
    }

    public boolean cadastrarCidade(RequisicaoCidadeDto dadosCidade) {
        Optional<EstadoModel> estadoModel = estadoRepository.findByNome(dadosCidade.getEstado());
        if(existCidadebyNome(dadosCidade.getNome())){
            throw new CidadeExistenteException();
        }else if (estadoModel.isPresent()) {
            CidadeModel cidadeModel = new CidadeModel();
            cidadeModel.setNome(dadosCidade.getNome());
            cidadeModel.setEstado(estadoModel.get());
            cidadeRepository.save(cidadeModel);
            return true;
        }
        throw new EstadoNotFoundException();
    }
    public List<RespostaCidadeDto> listarCidades() {
        List<CidadeModel> cidadeModels = cidadeRepository.findAll();
        List<RespostaCidadeDto> CidadeDtos = new ArrayList<>();
        if (cidadeModels.isEmpty()){
            throw new CidadenotFound();
        }
        for (CidadeModel cidadeModel : cidadeModels) {
            CidadeDtos.add(new RespostaCidadeDto(cidadeModel));
        }
        return CidadeDtos;
    }
    public boolean existCidadebyNome(String nome) {
        Optional<CidadeModel>cidadeModel = cidadeRepository.findByNome(nome);
        if (cidadeModel.isPresent()) {
            return true;
        }
        throw new CidadenotFound();
    }
    public RespostaCidadeDto existCidadebyNomeRetorna(String nome) {
        Optional<CidadeModel>cidadeModel = cidadeRepository.findByNome(nome);
        if (cidadeModel.isPresent()) {
            return new RespostaCidadeDto(cidadeModel.get());
        }
        throw new CidadenotFound();
    }

    public boolean deletarCidade(Long id) {
        if (cidadeRepository.existsById(id)) {
            cidadeRepository.deleteById(id);
            return true;
        }
        throw new CidadenotFound();
    }
    public boolean atualizarCidade(RequisicaoCidadeDto dados,Long id) {

        if (cidadeRepository.existsById(id)) {
            RespostaCidadeDto novoCidade = existCidadebyNomeRetorna(dados.getNome());
            if (existCidadebyNome(dados.getNome()) && !novoCidade.getId().equals(id)) {
                throw new CidadeExistenteException();
            }
            CidadeModel cidadeModel = new CidadeModel();
            cidadeModel.setId(id);
            cidadeModel.setNome(dados.getNome());
            cidadeModel.setEstado(estadoRepository.findByNome(dados.getEstado()).get());
            cidadeRepository.save(cidadeModel);
            return true;
        }
        throw new CidadenotFound();
    }

    public RespostaCidadeDto cidadebyId(Long id) {
        Optional<CidadeModel>cidadeModel = cidadeRepository.findById(id);
        if (cidadeModel.isPresent()) {
            return new RespostaCidadeDto(cidadeModel.get());
        }
        throw new CidadenotFound();
    }

}

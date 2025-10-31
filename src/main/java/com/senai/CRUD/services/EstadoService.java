package com.senai.CRUD.services;

import com.senai.CRUD.dtos.RequisicaoEstadoDto;
import com.senai.CRUD.dtos.RespostaEstadoDto;
import com.senai.CRUD.exceptions.EstadoExistException;
import com.senai.CRUD.exceptions.EstadoNotFoundException;
import com.senai.CRUD.models.EstadoModel;
import com.senai.CRUD.repositories.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
       private final EstadoRepository repository;

    public EstadoService(EstadoRepository repository) {
        this.repository = repository;
    }

    public boolean cadastrarEstado(RequisicaoEstadoDto dados){
        if (!estadoByName(dados.getNome())) {
            EstadoModel estado = new EstadoModel();
            estado.setNome(dados.getNome());
            estado.setSigla(dados.getSigla());

            repository.save(estado);
            return true;
        }
        throw new EstadoExistException();


    }

    public List<RespostaEstadoDto> listarEstados(){
        List<EstadoModel>estadoModelList = repository.findAll();
        List<RespostaEstadoDto>listaEstadoDto = new ArrayList<>();

        for (EstadoModel es : estadoModelList){
            listaEstadoDto.add(new RespostaEstadoDto(es));
        }
        return listaEstadoDto;

    }
    private boolean estadoByIdBoolean(long id){
        Optional<EstadoModel> estado = repository.findById(id);
        if (estado.isPresent()){
            return true;
        }
        return false;
    }

    public RespostaEstadoDto estadoById(long id) {
        Optional<EstadoModel> estado = repository.findById(id);
        return new RespostaEstadoDto(estado.get());
    }
    public boolean estadoByName(String name){
        Optional<EstadoModel> estado = repository.findByNome(name);
        if (estado.isPresent()){
            return true;
        }
        return false;
    }
    public boolean deletarEstado(long id){
        if(estadoByIdBoolean(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean atualizarEstado(RequisicaoEstadoDto dados,long id){
        if (estadoByIdBoolean(id)){
            if (!estadoByName(dados.getNome())){

                EstadoModel estado = new EstadoModel();
                estado.setId(id);
                estado.setNome(dados.getNome());
                estado.setSigla(dados.getSigla());
                repository.save(estado);
                return true;
            }
        }
       throw new EstadoExistException();
    }

}

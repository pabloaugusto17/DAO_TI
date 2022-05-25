package com.api_rest_drunk_drink.Service;

import com.api_rest_drunk_drink.Model.PessoaModel;
import com.api_rest_drunk_drink.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaModel> listar_todas_pessoas(){

        return pessoaRepository.findAll();

    }

    public void adicionar_pessoa(PessoaModel pessoa){
        pessoaRepository.save(pessoa);
    }

    public PessoaModel get_pessoa(Integer id){

        return pessoaRepository.findById(id).get();

    }

    public void deletar_pessoa(Integer id){

        pessoaRepository.deleteById(id);

    }

}

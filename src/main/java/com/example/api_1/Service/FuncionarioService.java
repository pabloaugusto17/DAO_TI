package com.example.api_1.Service;


import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Repository.FuncionariosRepository;
import com.example.api_1.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FuncionarioService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private FuncionariosRepository funcionario_repository;

    public List<FuncionariosModel> listar_todos_funcionarios(){

        return funcionario_repository.findAll();

    }

    public void adicionar_funcionario(FuncionariosModel funcionario){

        PessoaModel pessoa = pessoaRepository.findById(funcionario.getId_funcionario()).get();

        try{

            if(pessoa != null){
                funcionario_repository.save(funcionario);
            }else{
                System.err.println("Pessoa não existe");
            }


        }catch (Exception e){
            System.err.println(e);
        }


    }

    public FuncionariosModel get_funcionario(Integer id){

        return funcionario_repository.findById(id).get();

    }

    public void deletar_funcionario(Integer id){

        funcionario_repository.deleteById(id);

    }

}

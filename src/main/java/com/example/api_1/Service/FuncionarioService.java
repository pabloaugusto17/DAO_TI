package com.example.api_1.Service;


import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FuncionarioService {

    @Autowired
    private FuncionariosRepository funcionario_repository;

    public List<FuncionariosModel> listar_todos_funcionarios(){

        return funcionario_repository.findAll();

    }

    public void adicionar_funcionario(FuncionariosModel funcionario){
        funcionario_repository.save(funcionario);
    }

    public FuncionariosModel get_funcionario(Integer id){

        return funcionario_repository.findById(id).get();

    }

    public void deletar_funcionario(Integer id){

        funcionario_repository.deleteById(id);

    }

}

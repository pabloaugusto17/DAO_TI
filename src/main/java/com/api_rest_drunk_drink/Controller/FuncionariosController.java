package com.api_rest_drunk_drink.Controller;

import com.api_rest_drunk_drink.Model.FuncionariosModel;
import com.api_rest_drunk_drink.Service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {

    @Autowired
    FuncionarioService funcionario_service;

    @GetMapping("")
    public List<FuncionariosModel> listar(){

        return funcionario_service.listar_todos_funcionarios();

    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosModel> get(@PathVariable Integer id){

        try{

            FuncionariosModel funcionario = funcionario_service.get_funcionario(id);
            return new ResponseEntity<FuncionariosModel>(funcionario, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<FuncionariosModel>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/")
    public void adicionar(@RequestBody FuncionariosModel funcionario){
        funcionario_service.adicionar_funcionario(funcionario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){

        funcionario_service.deletar_funcionario(id);

    }

}

package com.api_rest_drunk_drink.Controller;

import com.api_rest_drunk_drink.Model.PessoaModel;
import com.api_rest_drunk_drink.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoa_servico;

    @GetMapping("")
    public List<PessoaModel> listar(){
        return pessoa_servico.listar_todas_pessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> get(@PathVariable Integer id){

        try{

            PessoaModel pessoa = pessoa_servico.get_pessoa(id);
            return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<PessoaModel>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/")
    public void adicionar(@RequestBody PessoaModel pessoa){
        pessoa_servico.adicionar_pessoa(pessoa);
    }

    @PutMapping("/{id}/{new_id}")
    public ResponseEntity<?> atualizar(@PathVariable Integer id, @PathVariable Integer new_id){

        try{

            PessoaModel pessoa_alterar = pessoa_servico.get_pessoa(id);
            pessoa_alterar.setCpf(new_id);
            return new ResponseEntity<>(HttpStatus.OK);


        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){

        pessoa_servico.deletar_pessoa(id);

    }

}


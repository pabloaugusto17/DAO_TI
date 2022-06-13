package com.example.api_1.Controller;

import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Service.BarService;
import com.example.api_1.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private BarService barService;

    @PostMapping("/")
    public void add_bar(@RequestBody BarModel bar){

        Integer id = bar.getId_pessoa();

        PessoaModel pessoa = pessoaService.get_pessoa(id);

        bar.setEmail(pessoa.getEmail());
        bar.setSenha(pessoa.getSenha());

        barService.add_bar(bar);

    }

    @DeleteMapping("/{id}")
    public void deleta_bar(@PathVariable Integer id){

        barService.deletar_bar(id);

    }

    @GetMapping("")
    public List<BarModel> listar_ce(){

        return barService.listar_bar();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BarModel> get(@PathVariable Integer id){

        try{

            BarModel bar = barService.get(id);
            return new ResponseEntity<BarModel>(bar, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<BarModel>(HttpStatus.NOT_FOUND);
        }

    }



}

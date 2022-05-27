package com.example.api_1.Controller;

import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.Service.ContratanteEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratanteE")
public class ContratanteEventoController {

    @Autowired
    ContratanteEventoService contratanteEventoService;

    @GetMapping("")
    public List<ContratanteEventoModel> listar_ce(){

        return contratanteEventoService.listar_todos_ce();

    }

    @PostMapping("/")
    public void add_ce(@RequestBody ContratanteEventoModel contratante){

        contratanteEventoService.add_ce(contratante);
    }

    @DeleteMapping("/{id}")
    public void deletar_ce(@PathVariable Integer id){

        contratanteEventoService.deletar_ce(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratanteEventoModel> get(@PathVariable Integer id){

        try{

            ContratanteEventoModel contratanteEventoModel = contratanteEventoService.get(id);
            return new ResponseEntity<ContratanteEventoModel>(contratanteEventoModel, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<ContratanteEventoModel>(HttpStatus.NOT_FOUND);
        }

    }

}

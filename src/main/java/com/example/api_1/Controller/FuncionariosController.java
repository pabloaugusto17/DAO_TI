package com.example.api_1.Controller;

import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Service.BarService;
import com.example.api_1.Service.EventoService;
import com.example.api_1.Service.FuncionarioService;
import com.example.api_1.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {


    @Autowired
    PessoaService pessoaService;
    @Autowired
    FuncionarioService funcionario_service;

    @Autowired
    EventoService eventoService;

    @Autowired
    BarService barService;

    @GetMapping("/getQuantidadeEventos{id}")
    public int get_quantidade_eventos(@PathVariable Integer id){

        FuncionariosModel funcionario_analisar = funcionario_service.get_funcionario(id);

        Integer id_bar = funcionario_analisar.getCnpj_barEvento();

        Integer id_analisar = -1;

        List<BarModel> bares = barService.listar_bar();

        for (int i = 0; i < bares.size(); i++){

            if(bares.get(i).getId_bar().equals(id_bar)){

                id_analisar = bares.get(i).getId_bar();

            }


        }


        List<EventoModel> eventos = eventoService.listar_eventos();


        int quant_eventos = 0 ;

        for(int i = 0; i < eventos.size(); i++){

            if(eventos.get(i).getId_bar_evento().equals(id_analisar)){
                quant_eventos++;
            }

        }


        return  quant_eventos;
    }

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

    @GetMapping("/getByDinamicId{id}")
    public FuncionariosModel getByDinamicId(@PathVariable Integer id){

        return funcionario_service.get_funcionario(id);

    }

    @GetMapping("/getFuncByName{name}")
    public Integer getFuncByName(@PathVariable String name){

        List<PessoaModel> pessoas = pessoaService.listar_todas_pessoas();

        for(int i = 0; i < pessoas.size(); i++){

            if(pessoas.get(i).getNome().equals(name)){

                return pessoas.get(i).getId_pessoa();

            }

        }

        return -1;


    }
}

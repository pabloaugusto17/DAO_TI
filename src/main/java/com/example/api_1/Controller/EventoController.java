package com.example.api_1.Controller;

import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Service.ContratanteEventoService;
import com.example.api_1.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {


    @Autowired
    EventoService eventoService;

    @GetMapping("")
    public List<EventoModel> listar_eventos(){

        return eventoService.listar_eventos();

    }

    @PostMapping("/")
    public void add_ce(@RequestBody EventoModel evento){

        eventoService.adicionar_evento(evento);
    }

    @DeleteMapping("/{id}")
    public void deletar_ce(@PathVariable Integer id){

        eventoService.delete_evento(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoModel> get(@PathVariable Integer id){

        try{

            EventoModel eventoModel = eventoService.get_evento(id);
            return new ResponseEntity<EventoModel>(eventoModel, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<EventoModel>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getbyname{id}")
    public EventoModel getEventoByName(@PathVariable String name){

        List<EventoModel> eventos = eventoService.listar_eventos();

        for(int i = 0; i < eventos.size(); i++){

            if(eventos.get(i).getNome().equals(name)){
                return eventos.get(i);
            }

        }

        return null;
    }

    @GetMapping("/getEventoById{id}")
    public EventoModel getEventoById(@PathVariable Integer id){

        return eventoService.get_evento(id);

    }

}

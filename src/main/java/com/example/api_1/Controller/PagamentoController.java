package com.example.api_1.Controller;

import com.example.api_1.Model.PagamentoModel;
import com.example.api_1.Service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/")
    public void add_pagamento(@RequestBody PagamentoModel pagamento){

        pagamentoService.add_pagamento(pagamento);

    }

    @DeleteMapping("/{id}")
    public void deletar_pagamento(@PathVariable Integer id){

        pagamentoService.deletar_pagamento(id);

    }

    @GetMapping("")
    public List<PagamentoModel> lista_pagamentos(){

        return pagamentoService.listar_pagamento();

    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoModel> get(@PathVariable Integer id){

        try{

            PagamentoModel pagamento = pagamentoService.get(id);
            return new ResponseEntity<PagamentoModel>(pagamento, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<PagamentoModel>(HttpStatus.NOT_FOUND);
        }

    }


}

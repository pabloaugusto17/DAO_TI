package com.example.api_1.Service;

import com.example.api_1.Model.PagamentoModel;
import com.example.api_1.Repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    public List<PagamentoModel> listar_pagamento(){

        return pagamentoRepository.findAll();

    }

    public PagamentoModel get(Integer id){

        return pagamentoRepository.findById(id).get();

    }

    public void add_pagamento(PagamentoModel pagamento){

        pagamentoRepository.save(pagamento);

    }

    public void deletar_pagamento(Integer id){

        pagamentoRepository.deleteById(id);

    }


}

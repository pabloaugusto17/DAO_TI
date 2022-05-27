package com.example.api_1.Service;

import com.example.api_1.Model.BarModel;
import com.example.api_1.Repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BarService {

    @Autowired
    private BarRepository barRepository;

    public List<BarModel> listar_bar(){

        return barRepository.findAll();

    }

    public BarModel get(Integer id){

        return barRepository.findById(id).get();

    }

    public void add_bar(BarModel bar){

        barRepository.save(bar);

    }

    public void deletar_bar(Integer id){

        barRepository.deleteById(id);

    }






}

package com.example.api_1.Service;

import com.example.api_1.Model.BartenderModel;
import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Repository.BartenderRepository;
import com.example.api_1.Repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BartenderService {

    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private BartenderRepository bartenderRepository;

    public List<BartenderModel> listar(){

        return bartenderRepository.findAll();

    }

    public BartenderModel listar_id(Integer id){

        return bartenderRepository.findById(id).get();

    }

    public void add_bartender(BartenderModel bartender){

        FuncionariosModel funcionariosModel = funcionariosRepository.findById(bartender.getId_bartender()).get();

        try{

            if(funcionariosModel != null){
                bartenderRepository.save(bartender);
            }


        }catch(Exception e){
            System.err.println(e);
        }

    }

    public void delete_bartender(Integer id){

        bartenderRepository.deleteById(id);

    }



}

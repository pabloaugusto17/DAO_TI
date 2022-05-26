package com.example.api_1.Service;

import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Repository.ContratanteEventoRepository;
import com.example.api_1.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContratanteEventoService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ContratanteEventoRepository contratanteEventoRepository;

    public List<ContratanteEventoModel> listar_todos_ce(){

        return contratanteEventoRepository.findAll();

    }

    public ContratanteEventoModel get(Integer id){

        return contratanteEventoRepository.findById(id).get();

    }

    public void add_ce(ContratanteEventoModel contratante){

        PessoaModel pessoa = pessoaRepository.findById(contratante.getContratante_evento_id()).get();

        try{

            if(pessoa != null){
                contratanteEventoRepository.save(contratante);
            }else{
                System.err.println("Pessoa não existe");
            }

        }catch(Exception e){
            System.err.println(e);
        }

    }

    public void deletar_ce(Integer id){

        contratanteEventoRepository.deleteById(id);

    }

}

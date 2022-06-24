package com.example.api_1.Service;

import com.example.api_1.Model.PropostaModel;
import com.example.api_1.Repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    public void enviar_proposta(PropostaModel proposta){

        propostaRepository.save(proposta);

    }

    public List<PropostaModel> recebe_proposta_by_id_bar(Integer id){

        List<PropostaModel> propostas = propostaRepository.recebe_proposta_bar(id);

        return propostas;

    }

    public List<PropostaModel> recebe_proposta_by_id_contratante(Integer id){

        List<PropostaModel> propostas = propostaRepository.recebe_proposta_ce(id);

        return propostas;

    }

    public void altera_status_proposta(boolean resultado, Integer id_ce, Integer id_bar){

        /*if(resultado == true){
            propostaRepository.atualiza_proposta(propostaRepository.retorna_id_proposta(id_ce, id_bar), 1);
        }else{
            propostaRepository.atualiza_proposta(propostaRepository.retorna_id_proposta(id_ce, id_bar), 0);
        }*/

    }

    public PropostaModel recebe_proposta(Integer id_bar, Integer id_ce){

        List<PropostaModel> propostas = propostaRepository.recebe_proposta_ce(id_ce);

        for(int i = 0; i < propostas.size(); i++){

            if(propostas.get(i).getId_bar().equals(id_bar)){
                return propostas.get(i);
            }

        }


        return null;

    }

    public List<PropostaModel> recebe_proposta_evento(Integer id_evento){

        return propostaRepository.recebe_proposta_evento(id_evento);

    }

    public void update_proposta(Integer id_proposta, int valor_update){

        PropostaModel propostaModel = propostaRepository.recebe_proposta(id_proposta);

        propostaModel.setStatus(valor_update);

        propostaRepository.saveAndFlush(propostaModel);


    }

    public List<PropostaModel> recebe_proposta_func(Integer id_func){

        return propostaRepository.recebe_proposta_func(id_func);

    }




}

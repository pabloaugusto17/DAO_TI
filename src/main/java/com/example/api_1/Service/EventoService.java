package com.example.api_1.Service;

import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.Model.EventoModel;
import com.example.api_1.Repository.BarRepository;
import com.example.api_1.Repository.ContratanteEventoRepository;
import com.example.api_1.Repository.EventoRepository;
import com.example.api_1.Repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private BarRepository barRepository;

    @Autowired
    private ContratanteEventoRepository contratanteEventoRepository;

    public List<EventoModel> listar_eventos(){

        return eventoRepository.findAll();

    }

    public void adicionar_evento(EventoModel evento){

        ContratanteEventoModel contratanteEvento = contratanteEventoRepository.findById(evento.getId_contratante_evento()).get();

        try{

            if(contratanteEvento != null){

                eventoRepository.save(evento);
            }


        }catch (Exception e) {

            System.err.println(e);

        }

    }

    public EventoModel get_evento(Integer id){

        return eventoRepository.findById(id).get();

    }

    public void delete_evento(Integer id){

        eventoRepository.deleteById(id);

    }



}

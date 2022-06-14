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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Vector;

@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private BarService barService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private EventoService eventoService;

    @PostMapping("/")
    public void add_bar(@RequestBody BarModel bar){

        Integer id = bar.getId_pessoa();

        PessoaModel pessoa = pessoaService.get_pessoa(id);

        bar.setEmail(pessoa.getEmail());
        bar.setSenha(pessoa.getSenha());

        barService.add_bar(bar);

    }

    @DeleteMapping("/{id}")
    public void deleta_bar(@PathVariable Integer id){

        barService.deletar_bar(id);

    }

    @GetMapping("")
    public List<BarModel> listar_ce(){

        return barService.listar_bar();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BarModel> get(@PathVariable Integer id){

        try{

            BarModel bar = barService.get(id);
            return new ResponseEntity<BarModel>(bar, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<BarModel>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getName{id}")
    public String getNameById(@PathVariable Integer id){

        List<BarModel> bares = barService.listar_bar();

        for(int i = 0; i < bares.size(); i++){

            if(bares.get(i).getId_bar().equals(id)){
                return bares.get(i).getNome();
            }
        }

        return null;
    }

    @GetMapping("/getIdDinamic{id}")
    public BarModel getBarByDinamicId(@PathVariable Integer id){

        List<BarModel> bares = barService.listar_bar();

        for(int i = 0; i < bares.size(); i++){

            if(bares.get(i).getId_pessoa() == id){

                return bares.get(i);

            }


        }

        return null;

    }

    @GetMapping("/quanteventos{id}")
    public int getQuantEventos(@PathVariable Integer id_analisar){

        List<EventoModel> eventos = eventoService.listar_eventos();

        int quant_eventos = 0 ;

        for(int i = 0; i < eventos.size(); i++){

            if(eventos.get(i).getId_bar_evento().equals(id_analisar)){
                quant_eventos++;
            }

        }

        return  quant_eventos;

    }

    @GetMapping("/getFuncionariosBar{id}")
    public Vector<FuncionariosModel> getFuncionarios(@PathVariable Integer id_bar){

        List<Integer> lista_id_funcionarios = barService.lista_funcionarios(id_bar);
        Vector<FuncionariosModel> funcionarios_enviar = new Vector<>();

        for (int i = 0; i < lista_id_funcionarios.size(); i++){

            funcionarios_enviar.add(funcionarioService.get_funcionario(lista_id_funcionarios.get(i)));

        }

        return  funcionarios_enviar;

    }


}

package com.example.api_1.Controller;

import com.example.api_1.Api1Application;
import com.example.api_1.Model.BarModel;
import com.example.api_1.Model.ContratanteEventoModel;
import com.example.api_1.Model.FuncionariosModel;
import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Service.BarService;
import com.example.api_1.Service.ContratanteEventoService;
import com.example.api_1.Service.FuncionarioService;
import com.example.api_1.Service.PessoaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private static Logger logger = LoggerFactory.getLogger(Api1Application.class);
    @Autowired
    private BarService barService;
    @Autowired
    private ContratanteEventoService contratanteEventoService;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private PessoaService pessoa_servico;






    @GetMapping("/getPessoaByIdDynamic{id}")
    public PessoaModel getPessoaByIdDynamic(@PathVariable Integer id){

        return pessoa_servico.get_pessoa(id);

    }
    @GetMapping("")
    public List<PessoaModel> listar(){
        return pessoa_servico.listar_todas_pessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> get(@PathVariable Integer id){

        try{

            PessoaModel pessoa = pessoa_servico.get_pessoa(id);
            return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<PessoaModel>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/")
    public void adicionar(@RequestBody PessoaModel pessoa){
        pessoa_servico.adicionar_pessoa(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){

        pessoa_servico.deletar_pessoa(id);

    }

    @RequestMapping("/verificalogin{email}{senha}")
    public String verifica_login(@PathVariable String email, @PathVariable String senha){

        boolean email_existe = false;
        boolean senha_correta = false;

        List<PessoaModel> pessoas = pessoa_servico.listar_todas_pessoas();

        for(int i = 0; i < pessoas.size(); i++){

            if(email.equals(pessoas.get(i).getEmail())){

                email_existe = true;

                if(senha.equals(pessoas.get(i).getSenha())){

                    senha_correta = true;
                    return "SC";

                }else{

                    return "SI";

                }


            }
        }

        return "NA";

    }

    @RequestMapping("/verificaemail{email}")
    public boolean verifica_email(@PathVariable String email){

        List<PessoaModel> pessoas = pessoa_servico.listar_todas_pessoas();

        for(int i = 0 ; i < pessoas.size(); i++){

            if(pessoas.get(i).getEmail().equals(email)){
                return true;
            }

        }

        return false;

    }

    @RequestMapping("/returnbyemail{email}")
    public int retorna_id_by_email(@PathVariable String email){

        List<PessoaModel> pessoas = pessoa_servico.listar_todas_pessoas();

        for(int i = 0; i < pessoas.size(); i++){

            if(pessoas.get(i).getEmail().equals(email)){

                return pessoas.get(i).getId_pessoa();

            }

        }

        return -1;

    }

    @RequestMapping("/derivapessoa{id}")
    public String derivacao_pessoa(@PathVariable Integer id){

        List<ContratanteEventoModel> ces = contratanteEventoService.listar_todos_ce();
        List<FuncionariosModel> funcionarios = funcionarioService.listar_todos_funcionarios();
        List<BarModel> bares = barService.listar_bar();

        for(int i = 0; i < ces.size(); i++){

            if(ces.get(i).getContratante_evento_id().equals(id)){

                return "CE";


            }

        }

        for(int i = 0; i < funcionarios.size(); i++){

            if(funcionarios.get(i).getId_funcionario().equals(id)){

                return "FUN";

            }

        }

        for(int i = 0; i < bares.size(); i++){

            if(bares.get(i).getId_pessoa() == id){

                return "BAR";

            }

        }


        return null;
    }

}


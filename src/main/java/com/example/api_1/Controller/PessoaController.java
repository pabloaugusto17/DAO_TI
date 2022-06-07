package com.example.api_1.Controller;

import com.example.api_1.Model.PessoaModel;
import com.example.api_1.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoa_servico;

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

}


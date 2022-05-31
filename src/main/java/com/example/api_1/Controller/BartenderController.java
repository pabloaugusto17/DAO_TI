package com.example.api_1.Controller;

import com.example.api_1.Model.BartenderModel;
import com.example.api_1.Service.BartenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bartender")
public class BartenderController {

    @Autowired
    private BartenderService bartenderService;

    @PostMapping("/")
    public void add_bartender(@RequestBody BartenderModel bartender){

        bartenderService.add_bartender(bartender);

    }

    @DeleteMapping("/{id}")
    public void delete_bartender(@PathVariable Integer id){

        bartenderService.delete_bartender(id);

    }

    @GetMapping("/")
    public List<BartenderModel> listar(){

        return bartenderService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BartenderModel> listar_by_id(@PathVariable Integer id){

        try{

            BartenderModel bartender = bartenderService.listar_id(id);
            return new ResponseEntity<BartenderModel>(HttpStatus.OK);

        }catch (Exception e){
            System.err.println(e);
            return new ResponseEntity<BartenderModel>(HttpStatus.NOT_FOUND);
        }


    }
}

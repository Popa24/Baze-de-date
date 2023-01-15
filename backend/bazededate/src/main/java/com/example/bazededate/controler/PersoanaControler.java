package com.example.bazededate.controler;

import com.example.bazededate.model.Carte;
import com.example.bazededate.model.Persoana;
import com.example.bazededate.serviciu.PersoanaServiciu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("persoana")
public class PersoanaControler {
    private final PersoanaServiciu  persoanaServiciu;
    @Autowired
    public PersoanaControler(PersoanaServiciu persoanaServiciu) {
        this.persoanaServiciu = persoanaServiciu;
    }
    @PostMapping
    public void addPersoana(@RequestBody Persoana p){
        persoanaServiciu.addPersoana(p);
    }
    @GetMapping
    public List<Persoana>getAllPersoane(){
        return persoanaServiciu.getAllPersoane();
    }
    @GetMapping("/date")
    public List<Persoana>getAllCopii(){
        return persoanaServiciu.getAllCopii();
    }
    @GetMapping("/nerestituite1")
    public List<Object[]>getAllNerestituite1(){
        return persoanaServiciu.getAllNerestituite1();
    }
    @GetMapping("/nerestituite2")
    public List<Object[]>getAllNrExemplare(){
        return persoanaServiciu.getAllNrExemplare();
    }
    @GetMapping("/nerestituite3")
    public List<Object[]>get_overdue(){return persoanaServiciu.get_overdue();}
}

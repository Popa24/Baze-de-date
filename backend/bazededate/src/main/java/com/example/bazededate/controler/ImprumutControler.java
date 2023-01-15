package com.example.bazededate.controler;

import com.example.bazededate.model.Imprumut;
import com.example.bazededate.model.Persoana;
import com.example.bazededate.serviciu.ImprumutServiciu;
import com.example.bazededate.serviciu.PersoanaServiciu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("imprumut")
public class ImprumutControler {
    private final ImprumutServiciu imprumutServiciu;
    @Autowired
    public ImprumutControler(ImprumutServiciu imprumutServiciu) {
        this.imprumutServiciu = imprumutServiciu;
    }

    @PostMapping
    public void addImprumut(@RequestBody Imprumut p){
        imprumutServiciu.addImprumut(p);
    }
    @GetMapping
    public List<Imprumut>getAllImprumuturi(){
        return imprumutServiciu.getAllImprumuturi();
    }
    @GetMapping("/nerestituite")
    public List<Imprumut>getAllNerestituite(){
        return imprumutServiciu.getAllNerestituite();
    }
}

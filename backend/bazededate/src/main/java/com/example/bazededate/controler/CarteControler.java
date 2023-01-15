package com.example.bazededate.controler;

import com.example.bazededate.model.Carte;
import com.example.bazededate.serviciu.CarteServiciu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("carte")
public class CarteControler {
    private final CarteServiciu carteServiciu ;
    @Autowired

    public CarteControler(CarteServiciu carteServiciu) {
        this.carteServiciu = carteServiciu;
    }

    @PostMapping
    public void addCarte(@RequestBody Carte p){
        carteServiciu.addCarte(p);
    }
    @GetMapping
    public List<Carte>getAllCarti(){
        return carteServiciu.getAllCarti();
    }
    @GetMapping("/exemplare")
    public List<Carte>getCarteExemplare(){
        return carteServiciu.getCarteExemplare();
    }

    @GetMapping("/shogun")
    public List<Carte>getCarteShogun(){return carteServiciu.getCarteShogun();}
    @GetMapping("/mediu")
    public List<Object[]>getCarteMediu(){return carteServiciu.getCarteMediu();}
}

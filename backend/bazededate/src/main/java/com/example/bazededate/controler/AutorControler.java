package com.example.bazededate.controler;

import com.example.bazededate.model.Autor;
import com.example.bazededate.model.Carte;
import com.example.bazededate.serviciu.AutorServiciu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("autor")
public class AutorControler {
    private final AutorServiciu autorServiciu;
    @Autowired
    public AutorControler(AutorServiciu autorServiciu) {
        this.autorServiciu = autorServiciu;
    }

    @PostMapping
    public void addAutor(@RequestBody Autor p){
        autorServiciu.addAutor(p);
    }
    @GetMapping
    public List<Autor> getAllAutori(){
        return autorServiciu.getAllAutori();
    }
    @GetMapping("/perechi")
    public List<Object[]>getAllPerechi(){return autorServiciu.getAllPerechi();}
}

package com.example.bazededate.serviciu;

import com.example.bazededate.dataaccesobject.AutorRepository;
import com.example.bazededate.model.Autor;
import com.example.bazededate.model.Carte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiciu {
    private final AutorRepository autorRepository;
    @Autowired
    public AutorServiciu(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }


    public List<Autor> getAllAutori(){
        return autorRepository.getAllAutori();
    }
    public void addAutor(Autor p){
        autorRepository.save(p);
    }
    public List<Object[]>getAllPerechi(){return autorRepository.getAllPerechi();}
}

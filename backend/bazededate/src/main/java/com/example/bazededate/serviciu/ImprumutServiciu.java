package com.example.bazededate.serviciu;

import com.example.bazededate.dataaccesobject.ImprumutRepository;
import com.example.bazededate.model.Imprumut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImprumutServiciu {
    private final ImprumutRepository imprumutRepository;
    @Autowired
    public ImprumutServiciu(ImprumutRepository imprumutRepository) {
        this.imprumutRepository = imprumutRepository;
    }

    public List<Imprumut> getAllImprumuturi(){
        return imprumutRepository.getAllImprumuturi();
    }
    public void addImprumut(Imprumut p){
        imprumutRepository.save(p);
    }
    public List<Imprumut>getAllNerestituite(){return imprumutRepository.getAllNerestituite();}
}

package com.example.bazededate.serviciu;

import com.example.bazededate.dataaccesobject.PersoanaRepository;
import com.example.bazededate.model.Carte;
import com.example.bazededate.model.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersoanaServiciu {
    private final PersoanaRepository persoanaRepository;
    @Autowired
    public PersoanaServiciu(PersoanaRepository persoanaRepository) {
        this.persoanaRepository = persoanaRepository;
    }
    public List<Persoana> getAllPersoane(){
        return persoanaRepository.getAllPersoane();
    }
    public void addPersoana(Persoana p){
        persoanaRepository.save(p);
    }
    public List<Persoana>getAllCopii(){return persoanaRepository.getAllCopii();}
    public List<Object[]>getAllNerestituite1(){return persoanaRepository.getAllNerestituite1();}

    public List<Object[]>getAllNrExemplare(){return persoanaRepository.getAllNrExemplare();}
    public List<Object[]>get_overdue(){return persoanaRepository.get_overdue();}
}

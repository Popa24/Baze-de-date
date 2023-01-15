package com.example.bazededate.serviciu;

import com.example.bazededate.dataaccesobject.CarteRepository;
import com.example.bazededate.model.Carte;
import com.example.bazededate.model.Persoana;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarteServiciu {
    private final CarteRepository carteRepository;
    @Autowired
    public CarteServiciu(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }



    public List<Carte> getAllCarti(){
        return carteRepository.getAllCarti();
    }
    public void addCarte(Carte p){
        carteRepository.save(p);
    }

    public List<Carte>getCarteExemplare(){return carteRepository.getCarteExemplare();}

    public List<Carte>getCarteShogun(){return carteRepository.getCarteShogun();}
    public List<Object[]>getCarteMediu(){return carteRepository.getCarteMediu();}
}

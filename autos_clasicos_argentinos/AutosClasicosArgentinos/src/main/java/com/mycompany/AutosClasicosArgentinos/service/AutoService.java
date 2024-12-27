
package com.mycompany.AutosClasicosArgentinos.service;

import com.mycompany.AutosClasicosArgentinos.model.Auto;
import com.mycompany.AutosClasicosArgentinos.repository.IAutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoService implements IAutoService{

    @Autowired
    private IAutoRepository autoRepo; 
    
    @Override
    public List<Auto> traerAutos() {
        return autoRepo.findAll();
    }

    @Override
    public void crearAuto(Auto clasico) {
        autoRepo.save(clasico);
    }

    @Override
    public Auto traerAuto(Long id_auto) {
        return autoRepo.findById(id_auto).orElse(null);
    }

    @Override
    public void borrarAuto(Long id_auto) {
        autoRepo.deleteById(id_auto);
    }

    @Override
    public void editarAuto(Auto clasico) {
        this.crearAuto(clasico);
    }
    
}

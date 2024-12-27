
package com.mycompany.AutosClasicosArgentinos.service;

import com.mycompany.AutosClasicosArgentinos.model.Auto;
import java.util.List;

public interface IAutoService {
    
    public List<Auto> traerAutos();
    
    public void crearAuto(Auto clasico);
    
    public Auto traerAuto(Long id_auto);
    
    public void borrarAuto(Long id_auto);
    
    public void editarAuto(Auto clasico);
    
}


package com.mycompany.AutosClasicosArgentinos.controller;

import com.mycompany.AutosClasicosArgentinos.model.Auto;
import com.mycompany.AutosClasicosArgentinos.service.IAutoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autos")
public class AutoController {
    
    @Autowired
    private IAutoService autoServ;
    
    @GetMapping("/traer")
    public List<Auto> traerAutos(){
        List <Auto> listaAutos= new ArrayList();
        listaAutos= autoServ.traerAutos();
        return listaAutos;
    }
    
    @PostMapping("/crear")
    public String crearAuto(@RequestBody Auto clasico){
        autoServ.crearAuto(clasico);
        return "Auto creado correctamente";
    }
    
    @GetMapping("/traer/{id_auto}")
    public Auto traerAuto(@PathVariable Long id_auto){
        return autoServ.traerAuto(id_auto);
    }
    
    @DeleteMapping("/borrar/{id_auto}")
    public String borrarAuto(@PathVariable Long id_auto){
        autoServ.borrarAuto(id_auto);
        return "Auto borrado correctamente";
    }
    
    @PutMapping("/editar")
    public Auto editarAuto(@RequestBody Auto clasico){
        autoServ.editarAuto(clasico);
        return autoServ.traerAuto(clasico.getId_auto());
    }
}


package com.mycompany.propietariosClasicos.controller;

import com.mycompany.propietariosClasicos.dto.PropietarioDTO;
import com.mycompany.propietariosClasicos.model.Propietario;
import com.mycompany.propietariosClasicos.service.IPropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/propietarios")
public class PropietarioController {
   
    @Autowired
    private IPropietarioService proServ;
    
    @GetMapping("/traer")
    public Page<PropietarioDTO> traerPropietarios(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return proServ.traerPropietarios(pageable);
    }
    
    @PostMapping("/crear")
    public String crearPropietario(@RequestBody Propietario prop){
        proServ.crearPropietario(prop);
        return "Propietario creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id_propietario}")
    public String borrarPropietario(@PathVariable Long id_propietario){
        proServ.borrarPropietario(id_propietario);
        return "Propietario borrado correctamente";
    }

    @DeleteMapping("/borrarlogico/{id_propietario}")
    public String borradoLogicoPropietario(@PathVariable Long id_propietario){
        proServ.borradoLogicoPropietario(id_propietario);
        return "Propietario marcado como eliminado correctamente";
    }

    @GetMapping("/traer/{id_propietario}")
    public PropietarioDTO traerPropietario(@PathVariable Long id_propietario){
        return proServ.traerPropietario(id_propietario);
    }
    
    @PutMapping("/editar")
    public PropietarioDTO editarPropietario(@RequestBody Propietario prop){
        proServ.editarPropietario(prop);
        return proServ.traerPropietario(prop.getId());
    }

}

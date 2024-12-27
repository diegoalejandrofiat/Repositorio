
package com.mycompany.propietariosClasicos.service;

import com.mycompany.propietariosClasicos.dto.PropietarioDTO;
import com.mycompany.propietariosClasicos.model.Propietario;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IPropietarioService {
    
    public Page <PropietarioDTO> traerPropietarios(Pageable pageable);
    
    public void crearPropietario (Propietario prop);
    
    public PropietarioDTO traerPropietario (Long id_propietario);

    public void borrarPropietario (Long id_propietario);

    public void borradoLogicoPropietario(Long id_propietario);

    public void editarPropietario (Propietario prop);
}

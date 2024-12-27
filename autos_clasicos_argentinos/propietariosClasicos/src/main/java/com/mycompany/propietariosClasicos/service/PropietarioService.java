
package com.mycompany.propietariosClasicos.service;

import com.mycompany.propietariosClasicos.dto.PropietarioDTO;
import com.mycompany.propietariosClasicos.model.Auto;
import com.mycompany.propietariosClasicos.model.Propietario;
import com.mycompany.propietariosClasicos.repository.IAutoApiClient;
import com.mycompany.propietariosClasicos.repository.IPropietarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PropietarioService implements IPropietarioService{

    @Autowired
    private IPropietarioRepository proRepo;
    
    @Autowired
    private IAutoApiClient apiauto;
    
    @Override
    public Page<PropietarioDTO> traerPropietarios(Pageable pageable) {

    Page<Propietario> pagePropietarios = proRepo.findByEliminadoFalse(pageable);

    List<PropietarioDTO> listaPropietariosDTO = pagePropietarios.stream().map(propi -> {
        PropietarioDTO propiDTO = new PropietarioDTO();
        List<Auto> listaAutos = new ArrayList<>();

        propiDTO.setNombre(propi.getNombre());
        propiDTO.setApellido(propi.getApellido());
        propiDTO.setId_propietario(propi.getId());
        propiDTO.setDni(propi.getDni());
        propiDTO.setDireccion(propi.getDireccion());

        List<Long> listaIdClasicos = propi.getListaIdAutosClasicos();
        for (Long ids : listaIdClasicos) {
            listaAutos.add(apiauto.traerAuto(ids));
        }
        propiDTO.setListaClasicos(listaAutos);

        return propiDTO;
    }).toList();

    
    return new PageImpl<>(listaPropietariosDTO, pageable, pagePropietarios.getTotalElements());
}


    @Override
    public void crearPropietario(Propietario prop) {
        proRepo.save(prop);
    }


    @Override
    public PropietarioDTO traerPropietario(Long id_propietario) { 
        
        Propietario propi = new Propietario();
        PropietarioDTO propiDTO = new PropietarioDTO();
        List <Long> listaIds = new ArrayList();
        List <Auto> listaAutos = new ArrayList();
        
        propi= proRepo.findByIdAndEliminadoFalse(id_propietario).orElseThrow(() -> new NotFoundException("Propietario no encontrado"));
        propiDTO.setId_propietario(propi.getId());
        propiDTO.setNombre(propi.getNombre());
        propiDTO.setApellido(propi.getApellido());
        propiDTO.setDireccion(propi.getDireccion());
        propiDTO.setDni(propi.getDni());
        listaIds=propi.getListaIdAutosClasicos();
        for(Long ids:listaIds){
           listaAutos.add(apiauto.traerAuto(ids));
        }
        propiDTO.setListaClasicos(listaAutos);
        return propiDTO;
    }

    @Override
    public void borrarPropietario(Long id_propietario) {
        proRepo.deleteById(id_propietario);
    }

    @Override
    public void borradoLogicoPropietario(Long id_propietario) {
        Optional<Propietario> propietarioOptional = proRepo.findById(id_propietario);
        if (propietarioOptional.isPresent()) {
            Propietario propietario = propietarioOptional.get();

            propietario.setEliminado(true);

            proRepo.save(propietario);
        } else {
            throw new RuntimeException("Propietario no encontrado");
        }
    }

    @Override
    public void editarPropietario(Propietario prop) {
        this.crearPropietario(prop);    
    }
    
}

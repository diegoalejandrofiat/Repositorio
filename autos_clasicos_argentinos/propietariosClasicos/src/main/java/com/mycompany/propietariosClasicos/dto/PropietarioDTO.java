
package com.mycompany.propietariosClasicos.dto;

import com.mycompany.propietariosClasicos.model.Auto;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropietarioDTO {
    
    private Long id_propietario;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    List <Auto> listaClasicos;
}

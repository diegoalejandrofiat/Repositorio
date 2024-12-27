
package com.mycompany.propietariosClasicos.model;

import jakarta.persistence.*;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Propietario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    @ElementCollection(fetch = FetchType.EAGER)
    private List <Long> listaIdAutosClasicos;
    @Column(nullable = false)
    private boolean eliminado = false;
}

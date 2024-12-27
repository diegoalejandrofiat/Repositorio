
package com.mycompany.propietariosClasicos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Auto {
    
    private Long id_auto;
    private String marca;
    private String modelo;
    private int anio;
    private String motor;
    private int cilindrada;
    private int cv;
    private String cant_puertas;
    private String frenos_delanteros;
    private String frenos_traseros;
    private String suspension_delantera;
    private String suspension_trasera;
    private String sistema_electrico;
    private String caja_cambios;
    private String rodado;
    private String descripcion_breve;
    
}

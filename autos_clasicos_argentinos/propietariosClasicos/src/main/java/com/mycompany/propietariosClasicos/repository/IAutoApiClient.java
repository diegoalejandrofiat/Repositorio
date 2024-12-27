
package com.mycompany.propietariosClasicos.repository;

import com.mycompany.propietariosClasicos.model.Auto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="apiauto", url="http://localhost:9001/autos")
public interface IAutoApiClient {
    
    @GetMapping("/traer/{id_auto}")
    public Auto traerAuto(@PathVariable ("id_auto") Long id_auto);
}

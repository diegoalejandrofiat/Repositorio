
package com.mycompany.AutosClasicosArgentinos.repository;

import com.mycompany.AutosClasicosArgentinos.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoRepository extends JpaRepository <Auto, Long>{
    
}

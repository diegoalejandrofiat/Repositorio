
package com.mycompany.propietariosClasicos.repository;

import com.mycompany.propietariosClasicos.model.Propietario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPropietarioRepository extends JpaRepository <Propietario, Long>{
    Page<Propietario> findAll(Pageable pageable);
    Page<Propietario> findByEliminadoFalse(Pageable pageable);
    Optional<Propietario> findByIdAndEliminadoFalse(Long id_propietario);
}

package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoutesRepository extends JpaRepository<Ruta, Long> {
    Collection<Object> findAllBy();
}

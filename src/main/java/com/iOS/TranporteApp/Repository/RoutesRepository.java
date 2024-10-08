package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, Long> {
}

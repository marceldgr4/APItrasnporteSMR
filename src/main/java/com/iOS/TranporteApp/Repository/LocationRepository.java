package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Locations, Long> {
    List<Locations> findByName(String name);
}

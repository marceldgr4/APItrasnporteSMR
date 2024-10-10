package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.PQR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQR_Repository extends JpaRepository<PQR,Long> {
   List<PQR>  findByName(String username);
}

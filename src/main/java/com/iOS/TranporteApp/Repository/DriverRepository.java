package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface DriverRepository extends JpaRepository<Conductor, Long> {


}

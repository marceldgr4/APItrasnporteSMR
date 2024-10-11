package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface DriverRepository extends JpaRepository<Drivers, Long> {


}

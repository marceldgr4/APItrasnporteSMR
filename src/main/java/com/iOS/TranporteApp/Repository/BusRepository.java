package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Dto.BusDto;
import com.iOS.TranporteApp.Entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByPlate(String plate);

}

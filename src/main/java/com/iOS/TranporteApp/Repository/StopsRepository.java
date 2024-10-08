package com.iOS.TranporteApp.Repository;


import com.iOS.TranporteApp.Entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepository extends JpaRepository<Stops,Long> {
}

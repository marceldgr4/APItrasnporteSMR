package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentsCardRepository extends JpaRepository<Payments,Long> {
    List<Payments> findByDate(LocalDateTime date);
}

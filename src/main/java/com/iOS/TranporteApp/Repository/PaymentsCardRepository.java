package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.Payments_Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsCardRepository extends JpaRepository<Payments_Card,Long> {
}

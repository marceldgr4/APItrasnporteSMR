package com.iOS.TranporteApp.Repository;

import com.iOS.TranporteApp.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {


}

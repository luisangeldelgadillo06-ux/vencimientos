package com.minimarket.vencimientos.repository;

import com.minimarket.vencimientos.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoteRepository extends JpaRepository<Lote , Long> {
    List<Lote> findAllByOrderByFechaVencimientoAsc();
}

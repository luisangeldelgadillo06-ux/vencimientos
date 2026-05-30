package com.minimarket.vencimientos.repository;

import com.minimarket.vencimientos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto , Long> {
    Optional<Producto> findByCodigoBarras(String codigoBarras);

}

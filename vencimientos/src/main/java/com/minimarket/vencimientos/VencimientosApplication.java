package com.minimarket.vencimientos;

import com.minimarket.vencimientos.model.Lote;
import com.minimarket.vencimientos.model.Producto;
import com.minimarket.vencimientos.repository.LoteRepository;
import com.minimarket.vencimientos.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class VencimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(VencimientosApplication.class, args);
	}



	}



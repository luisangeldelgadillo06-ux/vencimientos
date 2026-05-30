package com.minimarket.vencimientos.Service.impl;

import com.minimarket.vencimientos.Service.LoteService;
import com.minimarket.vencimientos.model.EstadoAlerta;
import com.minimarket.vencimientos.model.Lote;
import com.minimarket.vencimientos.repository.LoteRepository;
import com.minimarket.vencimientos.strategy.ContextoAlerta;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class LoteServiceImpl implements LoteService {
    private final LoteRepository loteRepository;
    private final ContextoAlerta contextoAlerta;

    @Override
    @Transactional
    public Lote guardarLote(Lote lote) {
        return loteRepository.save(lote);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lote> obtenerTodosLosLotesConAlerta() {
        List<Lote> lotes = loteRepository.findAllByOrderByFechaVencimientoAsc();


        return lotes.stream()
                .map(this::procesarAlertaLote)
                .collect(Collectors.toList());
    }

    @Override
    public Lote procesarAlertaLote(Lote lote) {
        if (lote.getFechaVencimiento() == null) {
            lote.setEstadoAlerta(EstadoAlerta.NORMAL);
            return lote;
        }

        long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), lote.getFechaVencimiento());

        // Delegación de la lógica al patrón Strategy
        EstadoAlerta estado = contextoAlerta.calcularEstado(diasRestantes);
        lote.setEstadoAlerta(estado);

        return lote;
    }
    }


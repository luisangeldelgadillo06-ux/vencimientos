package com.minimarket.vencimientos.strategy.impl;

import com.minimarket.vencimientos.model.EstadoAlerta;
import com.minimarket.vencimientos.strategy.AlertaStrategy;
import org.springframework.stereotype.Component;

@Component
public class CriticoRojaStrategy implements AlertaStrategy {
    @Override
    public boolean aplicaPara(long diasRestantes) {
        return diasRestantes > 0 && diasRestantes <= 7;
    }

    @Override
    public EstadoAlerta obtenerEstado() {
        return EstadoAlerta.CRITICO;
    }
}

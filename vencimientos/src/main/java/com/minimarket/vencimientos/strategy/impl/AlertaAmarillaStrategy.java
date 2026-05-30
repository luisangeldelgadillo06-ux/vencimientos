package com.minimarket.vencimientos.strategy.impl;

import com.minimarket.vencimientos.model.EstadoAlerta;
import com.minimarket.vencimientos.strategy.AlertaStrategy;
import org.springframework.stereotype.Component;

@Component
public class AlertaAmarillaStrategy implements AlertaStrategy {
    @Override
    public boolean aplicaPara(long diasRestantes) {
        return diasRestantes > 7 && diasRestantes <= 30;
    }

    @Override
    public EstadoAlerta obtenerEstado() {
        return EstadoAlerta.ALERTA;
    }
}

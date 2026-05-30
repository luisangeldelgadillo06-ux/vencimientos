package com.minimarket.vencimientos.strategy.impl;

import com.minimarket.vencimientos.model.EstadoAlerta;
import com.minimarket.vencimientos.strategy.AlertaStrategy;
import org.springframework.stereotype.Component;

@Component
public class AlertaVerdeStrategy implements AlertaStrategy {
    @Override
    public boolean aplicaPara(long diasRestantes) {
        return diasRestantes > 30;
    }

    @Override
    public EstadoAlerta obtenerEstado() {
        return EstadoAlerta.NORMAL;
    }
}

package com.minimarket.vencimientos.strategy;

import com.minimarket.vencimientos.model.EstadoAlerta;

public interface AlertaStrategy {
    boolean aplicaPara(long diasRestantes);
    EstadoAlerta obtenerEstado();
}

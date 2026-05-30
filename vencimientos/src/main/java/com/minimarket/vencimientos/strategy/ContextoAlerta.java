package com.minimarket.vencimientos.strategy;

import com.minimarket.vencimientos.model.EstadoAlerta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContextoAlerta {
    private final List<AlertaStrategy> estrategias;


    public ContextoAlerta(List<AlertaStrategy> estrategias) {
        this.estrategias = estrategias;
    }



    public EstadoAlerta calcularEstado(long diasRestantes) {
        return estrategias.stream()
                .filter(e -> e.aplicaPara(diasRestantes))
                .findFirst()
                .map(AlertaStrategy::obtenerEstado)
                .orElse(EstadoAlerta.NORMAL); // Fallback seguro
    }
}

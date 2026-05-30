package com.minimarket.vencimientos.Service;

import com.minimarket.vencimientos.model.Lote;

import java.util.List;

public interface LoteService {
    Lote guardarLote(Lote lote);
    List<Lote> obtenerTodosLosLotesConAlerta();
    Lote procesarAlertaLote(Lote lote);
}

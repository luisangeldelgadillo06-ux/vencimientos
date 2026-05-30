package com.minimarket.vencimientos.controller;


import com.minimarket.vencimientos.Service.LoteService;
import com.minimarket.vencimientos.model.Lote;
import com.minimarket.vencimientos.model.Producto;
import com.minimarket.vencimientos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lotes")
@RequiredArgsConstructor

public class LoteController {
    private final LoteService loteService;
    private final ProductoRepository productoRepository;
    @GetMapping
    public String listarLotes(Model model) {
        List<Lote> lotes = loteService.obtenerTodosLosLotesConAlerta();
        model.addAttribute("lotes", lotes);
        return "lotes-lista"; // Nombre del archivo HTML en templates
    }
    @PostMapping("/nuevo")
    public String registrarLote(
            @RequestParam String codigoBarras,
            @RequestParam String nombreProducto,
            @RequestParam String categoria,
            @RequestParam String numeroLote,
            @RequestParam String fechaVencimiento,
            @RequestParam Integer stockActual,
            @RequestParam BigDecimal precioCompra) {


        Optional<Producto> productoExistente = productoRepository.findByCodigoBarras(codigoBarras);
        Producto producto;

        if (productoExistente.isPresent()) {
            producto = productoExistente.get();
        } else {
            producto = new Producto(null, codigoBarras, nombreProducto, categoria);
            producto = productoRepository.save(producto);
        }


        Lote nuevoLote = new Lote(
                null,
                numeroLote,
                LocalDate.parse(fechaVencimiento),
                stockActual,
                precioCompra,
                producto,
                null
        );


        loteService.guardarLote(nuevoLote);


        return "redirect:/lotes";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarLote(@PathVariable Long id) {
        // Buscamos el lote y lo eliminamos
        loteService.guardarLote(null);
        return "redirect:/lotes";
    }
}

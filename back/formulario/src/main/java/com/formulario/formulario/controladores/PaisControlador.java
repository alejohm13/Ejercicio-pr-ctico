package com.formulario.formulario.controladores;

import com.formulario.formulario.modelos.Pais;
import com.formulario.formulario.servicios.PaisServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveedorapi/v1/pais")
public class PaisControlador {

    @Autowired
    private PaisServicio paisServicio;

    @PostMapping
    public ResponseEntity<Pais> guardarPais(@RequestBody Pais datosPais) {
        try {
            return ResponseEntity.ok(paisServicio.guardarPais(datosPais));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Pais> consultarPaisPorPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(paisServicio.consultarPaisId(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pais>> consultarPais() {
        try {
            return ResponseEntity.ok(paisServicio.buscarTodosPaises());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

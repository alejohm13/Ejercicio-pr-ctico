package com.formulario.formulario.controladores;

import com.formulario.formulario.modelos.Departamento;
import com.formulario.formulario.servicios.DepartamentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("proveedorapi/v1/departamento")
public class DepartamentoControlador {
    @Autowired
    DepartamentoServicio departamentoServicio;

    @PostMapping
    public ResponseEntity<Departamento> guardarDepartamento(@RequestBody Departamento datosDepartamento) throws Exception {
        return ResponseEntity.ok(departamentoServicio.guardarDepartamento(datosDepartamento));
    }

    @GetMapping("{id}")
    public ResponseEntity<Departamento> consultarDepartamentoPorId(@PathVariable Integer id) throws Exception {
        return departamentoServicio.consultarDepartamentoId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<Departamento>> consultarDepartamentos() {
        return ResponseEntity.ok(departamentoServicio.buscarTodosDepartamentos());
    }
}

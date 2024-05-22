package com.formulario.formulario.controladores;

import com.formulario.formulario.modelos.Ciudad;
import com.formulario.formulario.servicios.CiudadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/ciudad")
public class CiudadControlador {
    @Autowired
    CiudadServicio ciudadServicio;

    @PostMapping
    public ResponseEntity<?> guardarCiudad(@RequestBody Ciudad datosCiudad) {
        try {
            Ciudad ciudadGuardada = ciudadServicio.guardarCiudad(datosCiudad);
            return ResponseEntity.ok(ciudadGuardada);
        } catch (Exception error) {
            return manejarError(error);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consultarCiudadPorId(@PathVariable Integer id) {
        try {
            Ciudad ciudad = ciudadServicio.consultarCiudadId(id);
            return ResponseEntity.ok(ciudad);
        } catch (Exception error) {
            return manejarError(error);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarCiudad() {
        try {
            List<Ciudad> ciudades = ciudadServicio.buscarTodosCiudad();
            return ResponseEntity.ok(ciudades);
        } catch (Exception error) {
            return manejarError(error);
        }
    }

    private ResponseEntity<?> manejarError(Exception error) {
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", error.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}

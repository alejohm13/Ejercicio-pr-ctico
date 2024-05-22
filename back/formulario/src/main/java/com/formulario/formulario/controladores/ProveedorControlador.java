package com.formulario.formulario.controladores;

import com.formulario.formulario.modelos.Proveedor;
import com.formulario.formulario.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("proveedorapi/v1/proveedor")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    private ResponseEntity<?> manejarError(Exception error, HttpStatus status) {
        Map<String, Object> errorDetails = new LinkedHashMap<>();
        errorDetails.put("timestamp", LocalDateTime.now());
        errorDetails.put("message", error.getMessage());
        return ResponseEntity.status(status).body(errorDetails);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> guardarProveedor(@RequestBody Proveedor datosProveedor) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(proveedorServicio.guardarProveedor(datosProveedor));
        } catch (Exception error) {
            return manejarError(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> consultarProveedorPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(proveedorServicio.consultarProveedorId(id));
        } catch (Exception error) {
            return manejarError(error, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> consultarProveedores() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(proveedorServicio.buscarTodosProveedores());
        } catch (Exception error) {
            return manejarError(error, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarProveedorPorId(@PathVariable Integer id) {
        try {
            if (proveedorServicio.eliminarProveedor(id)) {
                Map<String, Object> response = new LinkedHashMap<>();
                response.put("timestamp", LocalDateTime.now());
                response.put("message", "Proveedor eliminado con éxito");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proveedor no encontrado");
            }
        } catch (Exception error) {
            return manejarError(error, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrarProveedor(@RequestPart("proveedor") Proveedor proveedor, @RequestPart("rut") MultipartFile file) {
        try {
            Proveedor proveedorGuardado = proveedorServicio.guardarProveedorConRUT(proveedor, file);
            return ResponseEntity.status(HttpStatus.CREATED).body(proveedorGuardado);
        } catch (IOException e) {
            return manejarError(e, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            return manejarError(e, HttpStatus.BAD_REQUEST);
        }
    }
}

package com.formulario.formulario.servicios;

import com.formulario.formulario.helpers.ValidacionProveedor;
import com.formulario.formulario.modelos.Proveedor;
import com.formulario.formulario.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProveedorServicio {
    @Autowired
    private ValidacionProveedor validacionProveedor;
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    private static final String UPLOAD_DIR = "uploads/";

    public Proveedor guardarProveedor(Proveedor datosProveedor) throws Exception {
        if (validacionProveedor.validarProveedor(datosProveedor)) {
            return proveedorRepositorio.save(datosProveedor);
        }
        throw new Exception("Validación fallida para el proveedor");
    }

    public Proveedor consultarProveedorId(Integer idProveedor) throws Exception {
        return proveedorRepositorio.findById(idProveedor)
                .orElseThrow(() -> new Exception("Proveedor no encontrado"));
    }

    public List<Proveedor> buscarTodosProveedores() {
        return proveedorRepositorio.findAll();
    }

    public boolean eliminarProveedor(Integer idProveedor) throws Exception {
        if (proveedorRepositorio.existsById(idProveedor)) {
            proveedorRepositorio.deleteById(idProveedor);
            return true;
        }
        throw new Exception("Proveedor no encontrado");
    }

    public Proveedor guardarProveedorConRUT(Proveedor proveedor, MultipartFile file) throws IOException {
        File directory = new File(UPLOAD_DIR);
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("No se pudo crear la carpeta 'uploads'");
        }

        Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        Files.write(filePath, file.getBytes());

        proveedor.setRutaRut(filePath.toString());
        return proveedorRepositorio.save(proveedor);
    }
}

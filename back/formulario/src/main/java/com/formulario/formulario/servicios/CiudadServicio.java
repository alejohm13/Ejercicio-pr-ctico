package com.formulario.formulario.servicios;

import com.formulario.formulario.helpers.ValidacionCiudad;
import com.formulario.formulario.repositorios.CiudadRepositorio;
import com.formulario.formulario.modelos.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CiudadServicio {

    @Autowired
    private ValidacionCiudad validacionCiudad;

    @Autowired
    private CiudadRepositorio ciudadRepositorio;

    public Ciudad guardarCiudad(Ciudad datosCiudad) throws Exception {
        if (ValidacionCiudad.validarCiudadSave(datosCiudad)) {
            return ciudadRepositorio.save(datosCiudad);
        }
        return null;
    }

    public Ciudad consultarCiudadId(Integer idCiudad) throws Exception {
        return ciudadRepositorio.findById(idCiudad)
                .orElseThrow(() -> new Exception("Ciudad no encontrado"));
    }

    public List<Ciudad> buscarTodosCiudad() throws Exception {
        return ciudadRepositorio.findAll();
    }
}

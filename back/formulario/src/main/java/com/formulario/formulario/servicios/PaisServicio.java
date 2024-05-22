package com.formulario.formulario.servicios;

import com.formulario.formulario.helpers.ValidacionPais;
import com.formulario.formulario.modelos.Pais;
import com.formulario.formulario.repositorios.PaisRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServicio {
    @Autowired
    private ValidacionPais validacionPais;

    @Autowired
    private PaisRepositorio paisRepositorio;

    public Pais guardarPais(Pais datosPais) throws Exception {
        if (validacionPais.validarPaisSave(datosPais)) {
            return paisRepositorio.save(datosPais);
        } else {
            throw new Exception("Validación fallida para el país");
        }
    }

    public Pais consultarPaisId(Integer idPais) throws Exception {
        return paisRepositorio.findById(idPais)
                .orElseThrow(() -> new Exception("País no encontrado"));
    }

    public List<Pais> buscarTodosPaises() {
        return paisRepositorio.findAll();
    }
}

package com.formulario.formulario.servicios;

import com.formulario.formulario.helpers.ValidacionDepartamento;
import com.formulario.formulario.modelos.Departamento;
import com.formulario.formulario.repositorios.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServicio {
    @Autowired
    private ValidacionDepartamento validacionDepartamento;

    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    public Departamento guardarDepartamento(Departamento datosDepartamento) throws Exception {
        if (validacionDepartamento.validarDepartamentoSave(datosDepartamento)) {
            return departamentoRepositorio.save(datosDepartamento);
        } else {
            throw new Exception("Validación fallida para el departamento");
        }
    }

    public Departamento consultarDepartamentoId(Integer idDepartamento) throws Exception {
        return departamentoRepositorio.findById(idDepartamento)
                .orElseThrow(() -> new Exception("Departamento no encontrado"));
    }

    public List<Departamento> buscarTodosDepartamentos() {
        return departamentoRepositorio.findAll();
    }
}

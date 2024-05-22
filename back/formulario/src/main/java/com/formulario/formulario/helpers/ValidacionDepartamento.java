package com.formulario.formulario.helpers;

import com.formulario.formulario.modelos.Departamento;
import org.springframework.stereotype.Component;

@Component
public class ValidacionDepartamento {
    public static boolean validarDepartamento(String departamento) throws Exception {
        if (departamento.isEmpty()) {
            throw new Exception("El departamento no puede estar vacío");
        }
        if (departamento.length() > 50) {
            throw new Exception("El departamento no puede tener más de 50 caracteres");
        }
        return true;
    }

    public static boolean validarDepartamentoSave(Departamento departamento) throws Exception {
        return validarDepartamento(departamento.getNombreDepartamento());
    }
}

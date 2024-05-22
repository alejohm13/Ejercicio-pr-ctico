package com.formulario.formulario.helpers;

import com.formulario.formulario.modelos.Ciudad;
import org.springframework.stereotype.Component;

@Component
public class ValidacionCiudad {
    public static boolean validarCiudad(String ciudad) throws Exception {
        if (ciudad.isEmpty()) {
            throw new Exception("La ciudad no puede estar vacía");
        }
        if (ciudad.length() > 50) {
            throw new Exception("La ciudad no puede tener más de 50 caracteres");
        }
        return true;
    }

    public static boolean validarCiudadSave(Ciudad ciudad) throws Exception {
        return validarCiudad(String.valueOf(ciudad.getClass()));
    }
}

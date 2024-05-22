package com.formulario.formulario.helpers;

import com.formulario.formulario.modelos.Pais;
import org.springframework.stereotype.Component;

@Component
public class ValidacionPais {
    public static boolean validarPais(String pais) throws Exception {
        if (pais.isEmpty()) {
            throw new Exception("El país no puede estar vacío");
        }
        if (pais.length() > 50) {
            throw new Exception("El país no puede tener más de 50 caracteres");
        }
        return true;
    }

    public static boolean validarPaisSave(Pais pais) throws Exception {
        return validarPais(pais.getNombrePais());
    }
}


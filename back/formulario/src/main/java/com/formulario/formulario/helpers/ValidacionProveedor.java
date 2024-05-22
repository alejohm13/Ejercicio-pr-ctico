package com.formulario.formulario.helpers;

import com.formulario.formulario.modelos.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ValidacionProveedor {

    private static void validarCampo(String campo, String mensajeError, int longitudMaxima, String regex) throws Exception {
        if (campo.isEmpty()) {
            throw new Exception(mensajeError + " no puede estar vacío");
        }
        if (campo.length() > longitudMaxima) {
            throw new Exception(mensajeError + " no puede tener más de " + longitudMaxima + " caracteres");
        }
        if (regex != null && !campo.matches(regex)) {
            throw new IllegalArgumentException("Revisa el " + mensajeError + " ingresado");
        }
    }

    private static void validarCampo(String campo, String mensajeError, int longitudMaxima) throws Exception {
        validarCampo(campo, mensajeError, longitudMaxima, null);
    }

    public static boolean validarProveedor(Proveedor proveedor) throws Exception {
        validarCampo(proveedor.getTipoPersona(), "Tipo de persona", 10);
        validarCampo(proveedor.getNit(), "NIT", 11);
        validarCampo(proveedor.getRazonSocial(), "Razón social", 100);
        validarCampo(proveedor.getNombreRepresentanteLegal(), "Nombre del representante legal", 100, "[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+");
        validarCampo(proveedor.getTelefono(), "Teléfono", 10, "^[0-9]+$");
        validarCampo(proveedor.getEmail(), "Correo electrónico", 50, "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        validarCampo(proveedor.getDireccion(), "Dirección", 100);
        return true;
    }

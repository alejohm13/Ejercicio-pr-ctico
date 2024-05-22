package com.formulario.formulario.repositorios;

import com.formulario.formulario.modelos.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepositorio extends JpaRepository<Ciudad, Integer> {
}

package com.formulario.formulario.repositorios;

import com.formulario.formulario.modelos.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {
}

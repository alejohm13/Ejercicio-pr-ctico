package com.formulario.formulario.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudad;

    @Column(nullable = false)
    private String nombreCiudad;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    @JsonBackReference("ciudad-departamento")
    private Departamento departamento;

}

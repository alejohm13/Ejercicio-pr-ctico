package com.formulario.formulario.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * Modelo para los proveedores se usa Lombok para un codigo mas limpio
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // clave primaria para proveedores se genera automatica

    /*
     * Se definen los atributos y se hace que todos sean obligatorios
     */
    @Column(name = "tipoPersona",nullable = false,length = 10)
    private String tipoPersona;

    @Column(name = "nit",nullable = false, length = 11)
    private String nit;

    @Column(name = "razonSocial",nullable = false,length = 100)
    private String razonSocial;

    @Column(name = "nombreRepresentanteLegal",nullable = false,length = 100)
    private String nombreRepresentanteLegal;

    @Column(name = "telefono",nullable = false,length = 10)
    private String telefono;

    @Column(name = "email",nullable = false,length = 50)
    private String email;
    /*
     * se llama a los otros modelos y se hacen las relaciones entre ellos
     */
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "departamento_id", nullable = false)
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    private Ciudad ciudad;

    @Column(name = "direccion",nullable = false,length = 100)
    private String direccion;
    @Column(name = "rutaRut",nullable = false,length = 255)
    private String rutaRut;


    public void setRutaRut(String string) {
    }
}

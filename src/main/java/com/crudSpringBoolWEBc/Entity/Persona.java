package com.crudSpringBoolWEBc.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Debe ingresar su nombre")
    private String nombre;

    @NotBlank(message = "Debe ingresar su apellido")
    private String apellido;

    @NotEmpty(message = "Debe ingresar su email")
    @Email
    private String correo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    @NotNull(message = "Debe ingresar su fecha de nacimiento")
    private LocalDate fecha_nacimiento;

    private LocalDateTime fecha_registro;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellido, String correo, LocalDate fecha_nacimiento, LocalDateTime fecha_registro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fecha_registro = fecha_registro;
    }

    public Persona(String nombre, String apellido, String correo, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public LocalDateTime getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDateTime fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    @PrePersist
    public void prePersist() {
        fecha_registro = LocalDateTime.now();
    }
}

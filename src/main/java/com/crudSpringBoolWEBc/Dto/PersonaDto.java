package com.crudSpringBoolWEBc.Dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PersonaDto {
   @NotBlank
    private String nombre;
   @NotBlank
    private String apellido;
    @NotBlank
    private String correo;
    @NotBlank
    private LocalDate fecha_nacimiento;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String correo, LocalDate fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotBlank String correo) {
        this.correo = correo;
    }

    public @NotBlank LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(@NotBlank LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}

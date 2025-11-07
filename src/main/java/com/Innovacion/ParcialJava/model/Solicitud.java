package com.Innovacion.ParcialJava.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Solicitud {
    private Long id;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, message = "La descripción debe tener al menos 5 caracteres")
    private String descripcion;

    @NotNull(message = "El cliente es obligatorio")
    private Cliente cliente;

    @NotNull(message = "Debe asignarse un técnico")
    private Tecnico tecnico;

    @NotBlank(message = "El estado no puede estar vacío")
    private String estado;

    public Solicitud() {}

    public Solicitud(Long id, String descripcion, Cliente cliente, Tecnico tecnico, String estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Tecnico getTecnico() {
        return tecnico;
    }
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}

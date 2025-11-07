package com.Innovacion.ParcialJava.service;

import com.Innovacion.ParcialJava.model.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> listar();
    Solicitud obtenerPorId(Long id);
    Solicitud crear(Solicitud solicitud);
    Solicitud actualizar(Long id, Solicitud solicitud);
    void eliminar(Long id);
}

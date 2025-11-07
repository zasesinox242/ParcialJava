package com.Innovacion.ParcialJava.service;
import com.Innovacion.ParcialJava.model.Solicitud;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class SolicitudServiceImpl implements SolicitudService {
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Solicitud> listar() { return solicitudes; }
    @Override
    public Solicitud obtenerPorId(Long id) {
        return solicitudes.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public Solicitud crear(Solicitud solicitud) {
        solicitud.setId(nextId++);
        solicitudes.add(solicitud);
        return solicitud;
    }
    @Override
    public Solicitud actualizar(Long id, Solicitud nueva) {
        Solicitud existente = obtenerPorId(id);
        if (existente != null) {
            existente.setDescripcion(nueva.getDescripcion());
            existente.setEstado(nueva.getEstado());
            existente.setTecnico(nueva.getTecnico());
            return existente;
        }
        return null;
    }
    @Override
    public void eliminar(Long id) {
        solicitudes.removeIf(s -> s.getId().equals(id));
    }
}

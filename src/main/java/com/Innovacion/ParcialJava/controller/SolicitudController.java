package com.Innovacion.ParcialJava.controller;
import com.Innovacion.ParcialJava.model.Solicitud;
import com.Innovacion.ParcialJava.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {
    @Autowired
    private SolicitudService solicitudService;
    @GetMapping
    public List<Solicitud> listar() {
        return solicitudService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerPorId(@PathVariable Long id) {
        Solicitud s = solicitudService.obtenerPorId(id);
        return s != null ? ResponseEntity.ok(s) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Solicitud> crear(@Valid @RequestBody Solicitud solicitud) {
        Solicitud creada = solicitudService.crear(solicitud);
        return ResponseEntity.status(201).body(creada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        Solicitud actualizada = solicitudService.actualizar(id, solicitud);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        solicitudService.eliminar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}

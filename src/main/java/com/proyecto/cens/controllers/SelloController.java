package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.SelloDao;
import com.proyecto.cens.models.Sello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SelloController {
    @Autowired
    private SelloDao selloDao;

    @RequestMapping(value = "api/sello", method = RequestMethod.POST)
    public void crearSello(@RequestBody Sello sello) {
        selloDao.crear(sello);

        //String mensaje = "El Ambito se ha creado correctamente";
        //return ResponseEntity.ok(mensaje);
    }

    @RequestMapping(value = "api/modificar-sello/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> actualizarSello(@PathVariable Long id, @RequestBody Sello sello) {
        Sello selloExistente = selloDao.obtenerPorId(id);

        if (selloExistente != null) {
            selloExistente.setNombre(sello.getNombre());
            selloExistente.setDescripcion(sello.getDescripcion());
            selloDao.actualizar(selloExistente);

            String mensajeEncontrado = "El sello se ha actualizado correctamente";
            return ResponseEntity.ok(mensajeEncontrado);
        } else {
            String mensajeError = "El ID seleccionado no existe";
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/eliminar-sello/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarSello(@PathVariable Long id) {
        Sello selloExistente  = selloDao.obtenerPorId(id);

        if (selloExistente  != null) {
            selloDao.eliminar(selloExistente);

            String mensaje = "El sello se ha eliminado correctamente";
            return ResponseEntity.ok(mensaje);
        } else {
            String mensajeError = "El sello no existe";
            return ResponseEntity.ok(mensajeError);
        }
    }

    @GetMapping(value = "api/tabla-sello")
    public List<Sello> obtenerSellos() {
        return selloDao.obtenerTodosLosSellos();

    }
}

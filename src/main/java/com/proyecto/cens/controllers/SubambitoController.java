package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.SubambitoDao;
import com.proyecto.cens.dao.AmbitoDao;
import com.proyecto.cens.models.Ambito;
import com.proyecto.cens.models.Subambito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubambitoController {
    @Autowired
    private SubambitoDao subambitoDao;
    @Autowired
    private AmbitoDao ambitoDao;

/*
    @RequestMapping(value = "api/subambito", method = RequestMethod.POST)
    public void crearSubambito(@RequestBody Subambito subambito, @RequestParam Long ambitoId) {
        Ambito ambito = ambitoDao.obtenerPorId(ambitoId);
        if (ambito != null) {
            subambito.setAmbito(ambito);
            subambitoDao.crear(subambito);
            // Resto del código
        } else {
            // Manejo del caso cuando el Ambito no existe
        }
    }*/

    @RequestMapping(value = "api/subambito", method = RequestMethod.POST)
    public void crearSubambito(@RequestBody Subambito subambito) {
        subambitoDao.crear(subambito);

        //String mensaje = "El Ambito se ha creado correctamente";
        //return ResponseEntity.ok(mensaje);
    }

    @RequestMapping(value = "api/modificar-subambito/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> actualizarSubambito(@PathVariable Long id, @RequestBody Subambito subambito) {
        Subambito subambitoExistente = subambitoDao.obtenerPorId(id);

        if (subambitoExistente != null) {
            subambitoExistente.setNombre(subambito.getNombre());
            subambitoDao.actualizar(subambitoExistente);

            String mensajeEncontrado = "El subámbito se ha actualizado correctamente";
            return ResponseEntity.ok(mensajeEncontrado);
        } else {
            String mensajeError = "El ID seleccionado no existe";
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/eliminar-subambito/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarSubambito(@PathVariable Long id) {
        Subambito subambitoExistente = subambitoDao.obtenerPorId(id);

        if (subambitoExistente != null) {
            subambitoDao.eliminar(subambitoExistente);

            String mensaje = "El subámbito se ha eliminado correctamente";
            return ResponseEntity.ok(mensaje);
        } else {
            String mensajeError = "El subámbito no existe";
            return ResponseEntity.ok(mensajeError);
        }
    }

    @GetMapping(value = "api/tabla-subambito")
    public List<Subambito> obtenerSubambitos() {
        return subambitoDao.obtenerTodosLosSubambitos();

    }
}

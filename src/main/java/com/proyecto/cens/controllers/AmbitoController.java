package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.AmbitoDao;
import com.proyecto.cens.models.Ambito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class AmbitoController {
    @Autowired
    private AmbitoDao ambitoDao;

    @RequestMapping(value = "api/ambito", method = RequestMethod.POST)
    public void crearAmbito(@RequestBody Ambito ambito) {
        ambitoDao.crear(ambito);

        //String mensaje = "El Ambito se ha creado correctamente";
        //return ResponseEntity.ok(mensaje);
    }

    @RequestMapping(value = "api/modificar-ambito/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> actualizarAmbito(@PathVariable Long id, @RequestBody Ambito ambito) {
        Ambito ambitoExistente = ambitoDao.obtenerPorId(id);

        if (ambitoExistente != null) {
            ambitoExistente.setNombre(ambito.getNombre());
            ambitoDao.actualizar(ambitoExistente);

            String mensajeEncontrado = "El ámbito se ha actualizado correctamente";
            return ResponseEntity.ok(mensajeEncontrado);
        } else {
            String mensajeError = "El ID seleccionado no existe";
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "api/eliminar-ambito/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarAmbito(@PathVariable Long id) {
        Ambito ambitoExistente = ambitoDao.obtenerPorId(id);

        if (ambitoExistente != null) {
            ambitoDao.eliminar(ambitoExistente);

            String mensaje = "El ámbito se ha eliminado correctamente";
            return ResponseEntity.ok(mensaje);
        } else {
            String mensajeError = "El ámbito no existe";
            return ResponseEntity.ok(mensajeError);
        }
    }


    @GetMapping(value = "api/tabla-ambito")
    public List<Ambito> obtenerAmbitos() {
        return ambitoDao.obtenerTodosLosAmbitos();

    }


}

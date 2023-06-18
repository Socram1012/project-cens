package com.proyecto.cens.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.proyecto.cens.dao.AmbitoDao;
import com.proyecto.cens.models.Ambito;
import com.proyecto.cens.models.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @GetMapping(value = "api/promedio")
    @ResponseBody
    public List<ResultadoDTO> promedioPorAmbito() {
        List<Object[]> lista = ambitoDao.promedioPorAmbito();
        List<ResultadoDTO> resultados = new ArrayList<>();

        for (Object[] row : lista) {
            String category = (String) row[0];
            Double value = (Double) row[1];
            ResultadoDTO resultadoDTO = new ResultadoDTO(category, value);
            resultados.add(resultadoDTO);
        }

        return resultados;
    }



}

package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.NotaDao;
import com.proyecto.cens.models.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotaController {

    @Autowired
    private NotaDao notaDao;

    @RequestMapping(value = "api/nota", method = RequestMethod.POST)
    public void crearNota(@RequestBody Nota nota) {
        notaDao.crear(nota);
    }
}

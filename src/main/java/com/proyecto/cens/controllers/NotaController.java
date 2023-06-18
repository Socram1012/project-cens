package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.NotaDao;
import com.proyecto.cens.models.Nota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotaController {

    @Autowired
    private NotaDao notaDao;


    @RequestMapping(value = "api/nota", method = RequestMethod.POST)
    public void crearNota(@RequestBody Nota nota) {
        notaDao.crear(nota);
    }



}



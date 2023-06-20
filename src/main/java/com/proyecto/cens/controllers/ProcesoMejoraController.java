package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.ProcesoMejoraDao;
import com.proyecto.cens.models.ProcesoMejora;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcesoMejoraController {

    private ProcesoMejoraDao procesoMejoraDao;

    @RequestMapping(value = "api/proceso_mejora", method = RequestMethod.POST)
    public void crearProcesoMejora(@RequestBody ProcesoMejora procesoMejora) { procesoMejoraDao.crear(procesoMejora); }
}

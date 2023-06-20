package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.ProcesoSelloDao;
import com.proyecto.cens.models.ProcesoSello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcesoSelloController {

    private ProcesoSelloDao procesoSelloDao;

    @RequestMapping(value = "api/proceso_sello", method = RequestMethod.POST)
    public void crearProcesoSello(@RequestBody ProcesoSello procesoSello) { procesoSelloDao.crear(procesoSello); }

}

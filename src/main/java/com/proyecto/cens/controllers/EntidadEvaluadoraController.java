package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.EntidadEvaluadoraDao;
import com.proyecto.cens.models.EntidadEvaluadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EntidadEvaluadoraController {

    @Autowired
    private EntidadEvaluadoraDao entidadEvaluadoraDao;

    @GetMapping(value = "api/entidad-evaluadora")
    public List<EntidadEvaluadora> getEntidadEvaluadoras(){
        return entidadEvaluadoraDao.getEntidadEvaluadoras();
    }

}

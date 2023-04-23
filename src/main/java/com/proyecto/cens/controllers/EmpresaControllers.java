package com.proyecto.cens.controllers;

import com.proyecto.cens.dao.EmpresaDao;
import com.proyecto.cens.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaControllers {
    @Autowired
    private EmpresaDao empresaDao;

    @RequestMapping(value="api/empresas")
    public List<Empresa> getEmpresa(){return empresaDao.getEmpresa();}
}

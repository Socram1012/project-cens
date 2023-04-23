package com.proyecto.cens.dao;

import com.proyecto.cens.models.Empresa;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmpresaDao {
    @Transactional
    List<Empresa> getEmpresa();
}

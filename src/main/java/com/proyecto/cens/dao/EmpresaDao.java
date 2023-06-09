package com.proyecto.cens.dao;

import com.proyecto.cens.models.Empresa;
import jakarta.transaction.Transactional;

import java.util.List;

public interface EmpresaDao {
    List<Empresa> obtenerTodasLasEmpresas();

    void crear(Empresa empresa);

    void actualizar(Empresa empresa);

    void eliminar(Empresa empresa);

    Empresa obtenerPorId(Long id);
}

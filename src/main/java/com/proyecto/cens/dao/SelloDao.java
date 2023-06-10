package com.proyecto.cens.dao;

import com.proyecto.cens.models.Sello;

import java.util.List;

public interface SelloDao {
    List<Sello> obtenerTodosLosSellos();

    void crear(Sello sello);

    void actualizar(Sello sello);

    void eliminar(Sello sello);

    Sello obtenerPorId(Long id);
}

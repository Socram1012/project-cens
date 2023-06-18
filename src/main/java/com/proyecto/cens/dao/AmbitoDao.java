package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;

import java.util.List;

public interface AmbitoDao{

    List<Ambito> obtenerTodosLosAmbitos();

    void crear(Ambito ambito);

    void actualizar(Ambito ambito);

    void eliminar(Ambito ambito);

    Ambito obtenerPorId(Long id);


    List<Object[]>  promedioPorAmbito();
}

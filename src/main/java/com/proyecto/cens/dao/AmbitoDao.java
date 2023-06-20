package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;
import com.proyecto.cens.models.EntidadEvaluadora;

import java.util.List;

public interface AmbitoDao{

    List<Ambito> obtenerTodosLosAmbitos();

    void crear(Ambito ambito);

    void actualizar(Ambito ambito);

    void eliminar(Ambito ambito);

    Ambito obtenerPorId(Long id);


    List<Object[]>  promedioPorAmbito(EntidadEvaluadora entidadEvaluadora);

    List<Ambito> ambitoPorEntidad(EntidadEvaluadora entidadEvaluadora);

    List<Object[]>  porcentajePorAmbito(EntidadEvaluadora entidadEvaluadora);
}

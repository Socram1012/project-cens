package com.proyecto.cens.dao;

import com.proyecto.cens.models.EntidadEvaluadora;

import java.util.List;

public interface EntidadEvaluadoraDao {


    List<EntidadEvaluadora> getEntidadEvaluadoras();

    EntidadEvaluadora obtenerPorId(Long id);
}

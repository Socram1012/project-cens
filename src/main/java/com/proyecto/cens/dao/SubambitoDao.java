package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;
import com.proyecto.cens.models.Subambito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubambitoDao {

    List<Subambito> obtenerTodosLosSubambitos();

    void crear(Subambito subambito);

    void actualizar(Subambito subambito);

    void eliminar(Subambito subambito);

    Subambito obtenerPorId(Long id);

    List<Subambito> obtenerPorAmbito(Ambito ambito);
}

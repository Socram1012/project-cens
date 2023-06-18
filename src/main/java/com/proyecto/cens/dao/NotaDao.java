package com.proyecto.cens.dao;

import com.proyecto.cens.models.Nota;
import jakarta.transaction.Transactional;

import java.util.List;

public interface NotaDao {

    //List<Nota> obtenerTodasLasNotas();

    void crear(Nota nota);


    //List<Nota> getNotas();

    //void actualizar(Nota nota);

    //void eliminar(Nota nota);

    //Nota obtenerPorId(Long id);

}

package com.proyecto.cens.dao;

import com.proyecto.cens.models.Nota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class NotaDaoImp implements NotaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void crear(Nota nota) { entityManager.persist(nota); }

}

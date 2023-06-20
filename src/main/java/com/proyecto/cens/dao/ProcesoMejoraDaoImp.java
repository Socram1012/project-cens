package com.proyecto.cens.dao;

import com.proyecto.cens.models.ProcesoMejora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProcesoMejoraDaoImp implements ProcesoMejoraDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void crear(ProcesoMejora procesoMejora) { entityManager.persist(procesoMejora); }

}

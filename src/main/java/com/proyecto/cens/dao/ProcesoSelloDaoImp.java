package com.proyecto.cens.dao;

import com.proyecto.cens.models.ProcesoSello;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProcesoSelloDaoImp implements ProcesoSelloDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void crear(ProcesoSello procesoSello) { entityManager.persist(procesoSello); }


}

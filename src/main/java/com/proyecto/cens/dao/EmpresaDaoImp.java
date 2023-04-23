package com.proyecto.cens.dao;


import com.proyecto.cens.models.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class EmpresaDaoImp implements EmpresaDao{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<Empresa> getEmpresa() {
        String query = "FROM Empresa ";
        return entityManager.createQuery(query).getResultList();
    }



}

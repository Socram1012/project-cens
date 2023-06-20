package com.proyecto.cens.dao;

import com.proyecto.cens.models.EntidadEvaluadora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class EntidadEvaluadoraDaoImp implements EntidadEvaluadoraDao{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<EntidadEvaluadora> getEntidadEvaluadoras() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntidadEvaluadora> criteriaQuery = builder.createQuery(EntidadEvaluadora.class);
        Root<EntidadEvaluadora> root = criteriaQuery.from(EntidadEvaluadora.class);
        criteriaQuery.select(root);

        TypedQuery<EntidadEvaluadora> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();
    }
    @Override
    public EntidadEvaluadora obtenerPorId(Long id) { return entityManager.find(EntidadEvaluadora.class, id); }
}

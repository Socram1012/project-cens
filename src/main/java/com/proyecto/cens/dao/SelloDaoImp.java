package com.proyecto.cens.dao;

import com.proyecto.cens.models.Sello;
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
public class SelloDaoImp implements SelloDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Sello> obtenerTodosLosSellos() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Sello> criteriaQuery = builder.createQuery(Sello.class);
        Root<Sello> root = criteriaQuery.from(Sello.class);
        criteriaQuery.select(root);

        TypedQuery<Sello> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void crear(Sello sello) { entityManager.persist(sello); }

    @Override
    public void actualizar(Sello sello) { entityManager.merge(sello); }

    @Override
    public void eliminar(Sello sello) { entityManager.remove(sello); }

    @Override
    public Sello obtenerPorId(Long id) { return entityManager.find(Sello.class, id); }
}

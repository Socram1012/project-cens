package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;
import com.proyecto.cens.models.Subambito;
import com.proyecto.cens.dao.SubambitoDao;
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
public class SubambitoDaoImp implements SubambitoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Subambito> obtenerTodosLosSubambitos() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subambito> criteriaQuery = builder.createQuery(Subambito.class);
        Root<Subambito> root = criteriaQuery.from(Subambito.class);
        criteriaQuery.select(root);

        TypedQuery<Subambito> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void crear(Subambito subambito) { entityManager.persist(subambito); }

    @Override
    public void actualizar(Subambito subambito) { entityManager.merge(subambito); }

    @Override
    public void eliminar(Subambito subambito) { entityManager.remove(subambito); }

    @Override
    public Subambito obtenerPorId(Long id) { return entityManager.find(Subambito.class, id); }

}

package com.proyecto.cens.dao;

import com.proyecto.cens.models.Empresa;
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
public class EmpresaDaoImp implements EmpresaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Empresa> obtenerTodasLasEmpresas() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Empresa> criteriaQuery = builder.createQuery(Empresa.class);
        Root<Empresa> root = criteriaQuery.from(Empresa.class);
        criteriaQuery.select(root);

        TypedQuery<Empresa> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void crear(Empresa empresa) { entityManager.persist(empresa); }

    @Override
    public void actualizar(Empresa empresa) { entityManager.merge(empresa); }

    @Override
    public void eliminar(Empresa empresa) { entityManager.remove(empresa); }

    @Override
    public Empresa obtenerPorId(Long id) { return entityManager.find(Empresa.class, id); }

}

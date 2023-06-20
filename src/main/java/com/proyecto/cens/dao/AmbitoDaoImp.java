package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;
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
public class AmbitoDaoImp implements AmbitoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Ambito> obtenerTodosLosAmbitos() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ambito> criteriaQuery = builder.createQuery(Ambito.class);
        Root<Ambito> root = criteriaQuery.from(Ambito.class);
        criteriaQuery.select(root);

        TypedQuery<Ambito> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void crear(Ambito ambito) { entityManager.persist(ambito); }

    @Override
    public void actualizar(Ambito ambito) { entityManager.merge(ambito); }

    @Override
    public void eliminar(Ambito ambito) { entityManager.remove(ambito); }

    @Override
    public Ambito obtenerPorId(Long id) { return entityManager.find(Ambito.class, id); }

    @Override
    public List<Object[]>  promedioPorAmbito(EntidadEvaluadora entidadEvaluadora){
        String sql = "SELECT a.nombre AS category, AVG(n.calificacion) AS value "
                + "FROM Ambito AS a "
                + "JOIN Subambito AS sa ON a.id = sa.ambito.id "
                + "JOIN Nota AS n ON sa.id = n.subambito.id "
                + "WHERE n.subambito.ambito.entidadEvaluadora = :entidadEvaluadora "
                + "GROUP BY a.nombre";

        return entityManager.createQuery(sql)
                .setParameter("entidadEvaluadora", entidadEvaluadora)
                .getResultList();
    }


    public List<Ambito> ambitoPorEntidad(EntidadEvaluadora entidadEvaluadora) {
        String hql = "FROM Ambito a WHERE a.entidadEvaluadora.id = :entidadId";
        return entityManager.createQuery(hql, Ambito.class)
                .setParameter("entidadId", entidadEvaluadora.getId())
                .getResultList();
    }
    @Override
    public List<Object[]> porcentajePorAmbito(EntidadEvaluadora entidadEvaluadora) {
        String sql = "SELECT a.nombre AS category, COUNT(n.calificacion) *1.0/ COUNT(n.procesoSello.id) AS value "
                + "FROM Ambito AS a "
                + "JOIN Subambito AS sa ON a.id = sa.ambito.id "
                + "JOIN Nota AS n ON sa.id = n.subambito.id "
                + "WHERE n.subambito.ambito.entidadEvaluadora = :entidadEvaluadora "
                + "AND n.calificacion >= 2 "
                + "AND n.procesoSello.fEntregaInforme IS NOT NULL "
                + "GROUP BY a.nombre";

        return entityManager.createQuery(sql)
                .setParameter("entidadEvaluadora", entidadEvaluadora)
                .getResultList();
    }
}


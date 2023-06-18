package com.proyecto.cens.dao;

import com.proyecto.cens.models.Ambito;
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
    public List<Object[]>  promedioPorAmbito(){
        String sql = "SELECT a.nombre AS category, AVG(n.calificacion) AS value FROM Ambito AS a JOIN Subambito AS sa ON a.id = sa.ambito.id JOIN Nota AS n ON sa.id = n.subambito.id GROUP BY a.nombre";
        return entityManager.createQuery(sql).getResultList();
    }

}


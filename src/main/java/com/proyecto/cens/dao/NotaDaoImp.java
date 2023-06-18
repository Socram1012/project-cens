package com.proyecto.cens.dao;

import com.proyecto.cens.models.Nota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class NotaDaoImp implements NotaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void crear(Nota nota) { entityManager.persist(nota); }

    /*@Override
    @Transactional
    public List<Nota> getNotas() {
        String query = "SELECT a.nombre AS nombreAmbito, AVG(n.calificacion) AS promedioCalificaciones " +
                "FROM Ambito a " +
                "JOIN a.subambitos sa " +
                "JOIN sa.notas n " +
                "GROUP BY a.nombre";
        return entityManager.createQuery(query).getResultList();
    }*/
}

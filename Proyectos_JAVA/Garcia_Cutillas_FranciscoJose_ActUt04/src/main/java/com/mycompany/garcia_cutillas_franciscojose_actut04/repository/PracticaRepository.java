package com.mycompany.garcia_cutillas_franciscojose_actut04.repository;

import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Practica;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;

/**
 *
 * @author Fran
 */
public class PracticaRepository implements Repository<Practica> {

    @Override
    public void save(Practica p) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().save(p);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public List<Practica> findAll() {
        Query<Practica> query = HibernateUtil.getCurrentSession()
                .createQuery("select p from Practica p", Practica.class);

        return (List<Practica>) query.getResultList();
    }

    @Override
    public Practica findOneById(int id) throws NoResultException {
        Query<Practica> query = HibernateUtil.getCurrentSession()
                .createQuery("select p from Practica p where id = :idPra", Practica.class);
        query.setParameter("idPra", id);

        try {
            Practica p = query.getSingleResult();
            return p;
        } catch (NoResultException ex) {

            System.out.println("No existe una práctica con id: " + id + ", " + ex.getMessage());
            return null;

        }

    }

    public void update(Practica p) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().update(p);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

}

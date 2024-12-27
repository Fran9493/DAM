package com.mycompany.garcia_cutillas_franciscojose_actut04.repository;

import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Empresa;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;

/**
 *
 * @author Fran
 */
public class EmpresaRepository implements Repository<Empresa> {

    @Override
    public void save(Empresa t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().save(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public List<Empresa> findAll() {
        Query<Empresa> query = HibernateUtil.getCurrentSession()
                .createQuery("select e from Empresa e", Empresa.class);

        return (List<Empresa>) query.getResultList();
    }

    @Override
    public Empresa findOneById(int id) {
        Query<Empresa> query = HibernateUtil.getCurrentSession()
                .createQuery("select e from Empresa e where id = :idEmp", Empresa.class);
        query.setParameter("idEmp", id);

        try {
            Empresa e = query.getSingleResult();
            return e;
        } catch (NoResultException ex) {

            System.out.println("No existe una empresa con id: " + id + ", " + ex.getMessage());
            return null;

        }
    }

}

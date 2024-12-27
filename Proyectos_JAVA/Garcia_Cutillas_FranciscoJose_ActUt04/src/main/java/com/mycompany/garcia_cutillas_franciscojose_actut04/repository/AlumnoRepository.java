package com.mycompany.garcia_cutillas_franciscojose_actut04.repository;

import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Alumno;
import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Practica;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.HibernateUtil;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.query.Query;

/**
 *
 * @author Fran
 */
public class AlumnoRepository implements Repository<Alumno> {

    @Override
    public void save(Alumno t) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().clear();
        HibernateUtil.getCurrentSession().save(t);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }

    @Override
    public List<Alumno> findAll() {
        Query<Alumno> query = HibernateUtil.getCurrentSession()
                .createQuery("select a from Alumno a", Alumno.class);

        return (List<Alumno>) query.getResultList();
    }

    @Override
    public Alumno findOneById(int id) {
        Query<Alumno> query = HibernateUtil.getCurrentSession()
                .createQuery("select a from Alumno a where id = :idAlu", Alumno.class);
        query.setParameter("idAlu", id);

        try {
            Alumno a = query.getSingleResult();
            return a;
        } catch (NoResultException ex) {

            System.out.println("No existe un alumno con id: " + id + ", " + ex.getMessage());
            return null;

        }
    }

    public void saveCandidato(int id_alumno, int id_practica) {

        PracticaRepository practicaRepository = new PracticaRepository();

        HibernateUtil.getCurrentSession().beginTransaction();

        Alumno alumno = findOneById(id_alumno);
        Practica practica = practicaRepository.findOneById(id_practica);
        alumno.getListaPracticas().add(practica);

        HibernateUtil.getCurrentSession().merge(alumno);
        HibernateUtil.getCurrentSession().getTransaction().commit();

    }

}

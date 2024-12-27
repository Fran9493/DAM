package com.mycompany.garcia_cutillas_franciscojose_actut04.util;

import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Alumno;
import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Empresa;
import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Practica;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Fran
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;

    //Crea la factoría de sesiones
    public static void buildSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Alumno.class);
        configuration.addAnnotatedClass(Empresa.class);
        configuration.addAnnotatedClass(Practica.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

    }

    //Abre una nueva versión
    public static void openSession() {

        session = sessionFactory.openSession();

    }

    //Devuelve la sesión actual
    public static Session getCurrentSession() {

        if ((session == null) || (!session.isOpen())) {

            openSession();

        }

        return session;

    }

    //Cierra Hibernate
    public static void closeSessionFactory() {

        if (session != null) {

            session.close();

        }

        if (sessionFactory != null) {

            sessionFactory.close();

        }

    }

}

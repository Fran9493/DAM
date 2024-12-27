package com.mycompany.garcia_cutillas_franciscojose_actut04;

import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Alumno;
import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Empresa;
import com.mycompany.garcia_cutillas_franciscojose_actut04.entities.Practica;
import com.mycompany.garcia_cutillas_franciscojose_actut04.excepciones.EdadException;
import com.mycompany.garcia_cutillas_franciscojose_actut04.repository.AlumnoRepository;
import com.mycompany.garcia_cutillas_franciscojose_actut04.repository.EmpresaRepository;
import com.mycompany.garcia_cutillas_franciscojose_actut04.repository.PracticaRepository;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.FechaUtil;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.HibernateUtil;
import com.mycompany.garcia_cutillas_franciscojose_actut04.util.SiNoUtil;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.PersistenceException;

/**
 *
 * @author Fran
 */
public class Garcia_Cutillas_FranciscoJose_ActUt04 {

    private static Scanner sc = new Scanner(System.in, "ISO-8859-1");
    private static final PracticaRepository practicaRepository = new PracticaRepository();
    private static final EmpresaRepository empresaRepository = new EmpresaRepository();
    private static final AlumnoRepository alumnoRepository = new AlumnoRepository();

    public static void main(String[] args) {

        boolean salir = false;
        do {

            salir = menu();

        } while (salir == false);

    }

    private static boolean menu() {

        HibernateUtil.buildSessionFactory();

        int menu = 0;

        System.out.println("**** Aplicación para gestionar la FCT de los alumnos ****");
        System.out.println("\tOpciones:");
        System.out.println("\t - Pulsa 1 para consultar todos los alumnos.");
        System.out.println("\t - Pulsa 2 para consultar todas las empresas.");
        System.out.println("\t - Pulsa 3 para consultar todas las prácticas.");
        System.out.println("\t - Pulsa 4 para consultar los alumnos candidatos de una práctica.");
        System.out.println("\t - Pulsa 5 para dar de alta un alumno.");
        System.out.println("\t - Pulsa 6 para dar de alta una empresa.");
        System.out.println("\t - Pulsa 7 para dar de alta una práctica.");
        System.out.println("\t - Pulsa 8 para asignar un alumno a una práctica como candidato.");
        System.out.println("\t - Pulsa 9 para asignar un alumno a una práctica(alumno que realiza la práctica).");
        System.out.println("\t - Pulsa cualquier tecla para salir.");

        try {

            menu = sc.nextInt();

        } catch (InputMismatchException ex) {

            menu = 0;

        }
        sc.nextLine();

        boolean salir = false;

        switch (menu) {
            case 1:
                mostrarAlumnos();
                break;
            case 2:
                mostrarEmpresas();
                break;
            case 3:
                mostrarPracticas();
                break;
            case 4:
                mostrarAlumnosCandidatos();
                break;
            case 5:
                altaAlumno();
                break;
            case 6:
                altaEmpresa();
                break;
            case 7:
                altaPractica();
                break;
            case 8:
                asignarAlumnoCandidato();
                break;
            case 9:
                asignarAlumnoPractica();
                break;

            default:
                System.out.println("¡Gracias por utilizar nuestra herramienta!");
                salir = true;
        }

        HibernateUtil.closeSessionFactory();

        return salir;

    }

    //1. Consultar todos los alumnos
    private static void mostrarAlumnos() {

        ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) alumnoRepository.findAll();

        System.out.println("Alumnos presentes en la base de datos:");

        for (Alumno a : listaAlumnos) {
            System.out.println(" " + a);
        }

    }

    //2. Consultar todas las empresas
    private static void mostrarEmpresas() {

        ArrayList<Empresa> listaEmpresas = (ArrayList<Empresa>) empresaRepository.findAll();

        System.out.println("Empresas presentes en la base de datos:");

        for (Empresa e : listaEmpresas) {
            System.out.println(" " + e);
        }

    }

    //3. Consultar todas las prácticas
    private static void mostrarPracticas() {

        ArrayList<Practica> listaPracticas = (ArrayList<Practica>) practicaRepository.findAll();

        System.out.println("Prácticas presentes en la base de datos:");

        for (Practica p : listaPracticas) {
            System.out.println(" " + p);
        }

    }

    //4. Consultar alumnos candidatos de una práctica
    private static void mostrarAlumnosCandidatos() {

        Practica practica = new Practica();

        System.out.println("Introduce el ID de la práctica");

        int idPractica = sc.nextInt();
        sc.nextLine();

        practica = practicaRepository.findOneById(idPractica);
        List<Alumno> listaAlumnos = null;

        if (practica != null) {

            listaAlumnos = practica.getListaAlumnos();

            if (listaAlumnos.size() > 0) {

                System.out.println("Alumnos candidatos a la práctica con ID: " + idPractica);

                for (Alumno a : listaAlumnos) {
                    System.out.println(" " + a);
                }

            } else {

                System.out.println("La práctica no tiene alumnos candidatos");

            }

        }

    }

    //5. Alta alumno 
    private static void altaAlumno() {

        System.out.println("Introduce el nombre del alumno:");
        String nombre = sc.nextLine();

        System.out.println("Introduce la edad del alumno:");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.println("Introduce el título del alumno:");
        String titulo = sc.nextLine();

        try {

            Alumno alumno = new Alumno(nombre, edad, titulo);
            HibernateUtil.getCurrentSession().beginTransaction();
            HibernateUtil.getCurrentSession().save(alumno);
            HibernateUtil.getCurrentSession().getTransaction().commit();

        } catch (EdadException ex) {

            System.out.println("No ha sido posible dar de alta el alumno. " + ex.getMessage());

        }

    }

    //6. Alta empresa
    private static void altaEmpresa() {

        System.out.println("Introduce el nombre de la empresa:");
        String nombre = sc.nextLine();

        System.out.println("Introduce el sector de la empresa:");
        String sector = sc.nextLine();

        Empresa empresa = new Empresa(nombre, sector);

        ArrayList<Empresa> empresas = (ArrayList<Empresa>) empresaRepository.findAll();

        boolean empresaBase = false;
        for (Empresa e : empresas) {

            if (e.getNombre().toUpperCase().contains(empresa.getNombre().toUpperCase())) {

                empresaBase = true;

            }

        }

        /*Comprobación de que la empresa no se encuentra ya en la base de datos. Como no vamos a controlar
            desde aquí los id de las empresas, vamos a controlar que no haya dos empresas con el mismo nombre*/
        if (!empresaBase) {

            HibernateUtil.getCurrentSession().beginTransaction();
            HibernateUtil.getCurrentSession().save(empresa);
            HibernateUtil.getCurrentSession().getTransaction().commit();

        } else {

            System.out.println("La empresa " + empresa.getNombre() + " ya se encuentra en la base de datos, "
                    + "por lo que no es posible añadirla de nuevo");

        }

    }

    //7. Alta práctica
    private static void altaPractica() {

        System.out.println("Introduce la fecha de inicio de la práctica en formato (dd/MM/yyyy):");
        String fechaInicio = sc.nextLine();

        System.out.println("Introduce la fecha de fin de la práctica en formato (dd/MM/yyyy):");
        String fechaFin = sc.nextLine();

        System.out.println("Introduce la descripción de la práctica:");
        String descripcion = sc.nextLine();

        System.out.println("Introduce el ID de la empresa donde se realizará la práctica:");
        int idEmpresa = sc.nextInt();
        sc.nextLine();

        //Extraer la empresa, para pasarla como parámetro a la práctica.
        Empresa empresa = empresaRepository.findOneById(idEmpresa);

        //Comprobamos que la empresa está en la base de datos
        if (empresa != null) {

            boolean correcto = false;
            String seleccion;
            System.out.println("¿Tiene la práctica algún alumno asignado?(S/N)");
            seleccion = sc.nextLine();

            do {

                //Comprobarmos que se introduce bien el valor S/N
                if (SiNoUtil.comprobarSiNo(seleccion)) {

                    correcto = true;

                    //Si no se elige correctamente S/N
                } else {

                    System.out.println("Tienes que elegir entre (S/N)");

                }

            } while (!correcto);

            Practica practica;
            Alumno alumno;

            //Si tenemos alumno para asignar a la práctica, la creamos con alumno
            if (seleccion.equalsIgnoreCase("S")) {

                System.out.println("Introduce el ID del alumno:");
                int idAlumno = sc.nextInt();
                sc.nextLine();

                //Comprobar el id del alumno y meter alumno
                alumno = alumnoRepository.findOneById(idAlumno);

                //Si el alumno no tiene práctica asignada, creamos práctica
                if (!comprobarAlumnoPractica(alumno)) {

                    practica = new Practica(FechaUtil.convierteFecha(fechaInicio),
                            FechaUtil.convierteFecha(fechaFin), descripcion, empresa, alumno);

                    HibernateUtil.getCurrentSession().beginTransaction();
                    HibernateUtil.getCurrentSession().save(practica);
                    HibernateUtil.getCurrentSession().getTransaction().commit();

                } else {

                    System.out.println("El alumno con id " + alumno.getId() + " ya tiene práctica asignada");

                }

                //Si no tenemos alumno, la creamos sin él  
            } else {

                practica = new Practica(FechaUtil.convierteFecha(fechaInicio),
                        FechaUtil.convierteFecha(fechaFin), descripcion, empresa);

                HibernateUtil.getCurrentSession().beginTransaction();
                HibernateUtil.getCurrentSession().save(practica);
                HibernateUtil.getCurrentSession().getTransaction().commit();

            }

        }

    }

    //8. Asignar un alumno a una práctica como candidato
    private static void asignarAlumnoCandidato() {

        //Compruebo que la práctica existe.
        System.out.println("Introduce el ID de la práctica:");
        int idPractica = sc.nextInt();
        sc.nextLine();
        Practica practica = practicaRepository.findOneById(idPractica);

        if (practica != null) {

            System.out.println("Introduce el ID del alumno a asignar:");
            int idAlumno = sc.nextInt();
            sc.nextLine();
            Alumno alumno = alumnoRepository.findOneById(idAlumno);

            //Compruebo que existe el alumno
            if (alumno != null) {

                //Le asigno como candidato a la práctica
                try {

                    alumnoRepository.saveCandidato(idAlumno, idPractica);

                } catch (PersistenceException ex) {

                    System.out.println("El alumno con ID " + alumno.getId() + " ya está como candidato de la práctica con ID "
                            + practica.getId());

                }

            }

        } else {

            System.out.println("La práctica a la que le quieres asignar un alumno, no existe");

        }

    }

    //9. Asignar un alumno a una práctica (alumno que realiza la práctica)
    private static void asignarAlumnoPractica() {

        System.out.println("Introduce el ID de la práctica a asignar:");
        int idPractica = sc.nextInt();
        sc.nextLine();

        //Recupero la práctica a la que asignar el alumno, comprobando que existe y que no tiene alumno asignado
        Practica practica = practicaRepository.findOneById(idPractica);

        if (practica != null) {

            if (practica.getAlumno() == null) {

                System.out.println("Introduce el ID del alumno que quieres asignar a la práctica:");
                int idAlumno = sc.nextInt();
                sc.nextLine();

                Alumno alumno = alumnoRepository.findOneById(idAlumno);

                if (alumno != null) {

                    //Asigno alumno
                    practica.setAlumno(alumno);

                    try {
                        practicaRepository.update(practica);
                    } catch (PersistenceException ex) {
                        System.out.println("El alumno ya tiene practica asignada");
                    }
                }

            } else {

                System.out.println("La práctica con ID " + idPractica + " ya tiene alumno asignado");

            }

        }

    }

    //Comprueba si el alumno tiene una práctica asignada
    private static boolean comprobarAlumnoPractica(Alumno a) {

        ArrayList<Practica> practicas = (ArrayList<Practica>) practicaRepository.findAll();

        for (Practica p : practicas) {

            if (p.getAlumno() != null) {

                if (p.getAlumno().getId() == a.getId()) {
                    return true;
                }

            }

        }

        return false;

    }

}

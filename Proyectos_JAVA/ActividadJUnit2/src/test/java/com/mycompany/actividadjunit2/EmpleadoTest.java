/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.actividadjunit2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Fran
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of registraEntradaEmpleado method, of class Empleado.
     */
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado0() {
        
        Integer empleado = 250;
        Integer departamento = 25;
        String oficio = "Analista";
        Empleado instance = new Empleado();
        int expResult = 2500;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado1() {
        
        Integer empleado = 453;
        Integer departamento = null;
        String oficio = "Diseñador";
        Empleado instance = new Empleado();
        int expResult = 1500;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado2() {
        
        Integer empleado = 115;
        Integer departamento = 17;
        String oficio = "Programador";
        Empleado instance = new Empleado();
        int expResult = 2000;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado3() {
        
        Integer empleado = 71;
        Integer departamento = 86;
        String oficio = "Diseñador";
        Empleado instance = new Empleado();
        int expResult = -1;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado4() {
        
        Integer empleado = 1020;
        Integer departamento = null;
        String oficio = "Programador";
        Empleado instance = new Empleado();
        int expResult = -1;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado5() {
        
        Integer empleado = 327;
        Integer departamento = 2;
        String oficio = "Analista";
        Empleado instance = new Empleado();
        int expResult = -2;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado6() {
       
        Integer empleado = 721;
        Integer departamento = 127;
        String oficio = "Diseñador";
        Empleado instance = new Empleado();
        int expResult = -2;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }  
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado7() {
        
        Integer empleado = 555;
        Integer departamento = null;
        String oficio = "Otro";
        Empleado instance = new Empleado();
        int expResult = -3;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado8() {
        
        Integer empleado = 100;
        Integer departamento = 10;
        String oficio = "Analista";
        Empleado instance = new Empleado();
        int expResult = 2500;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado9() {
        
        Integer empleado = 999;
        Integer departamento = 10;
        String oficio = "Analista";
        Empleado instance = new Empleado();
        int expResult = 2500;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    @Disabled
    @Test
    public void testRegistraEntradaEmpleado10() {
        
        Integer empleado = 99;
        Integer departamento = 9;
        String oficio = "Programador";
        Empleado instance = new Empleado();
        int expResult = -1;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    
    @Test
    @Disabled
    public void testRegistraEntradaEmpleado11() {
        
        Integer empleado = 1000;
        Integer departamento = 100;
        String oficio = "Analista";
        Empleado instance = new Empleado();
        int expResult = -1;
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(expResult, result);
       
    }
    //@Disabled
    @ParameterizedTest
    @CsvSource ({
        "250, 25, Analista, 2500",
        "453, , Diseñador, 1500",
        "115, 17, Programador, 2000",
        "71, 86, Diseñador, -1",
        "1020, , Programador, -1",
        "327, 2, Analista, -2",
        "721, 127, Diseñador, -2",
        "555, , Otro, -3",
        "100, 10, Analista, 2500",
        "999, 99, Diseñador, 1500",
        "99, 9, Programador, -1",
        "1000, 100, Analista, -1"
        
    })
    
    public void testRegistraEntradaEmpleadoParametrizado(Integer _empleado, 
            Integer _departamento, String _oficio, int esperado) {
        
        Integer empleado = _empleado;
        Integer departamento = _departamento;
        String oficio = _oficio;
        Empleado instance = new Empleado();
        
        int result = instance.registraEntradaEmpleado(empleado, departamento, oficio);
        assertEquals(esperado, result);
       
    }
    
}

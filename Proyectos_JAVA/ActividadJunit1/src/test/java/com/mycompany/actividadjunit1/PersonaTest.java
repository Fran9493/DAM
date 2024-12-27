/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.actividadjunit1;

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
public class PersonaTest {
    
    public PersonaTest() {
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
     * Test of isMayorDeEdad method, of class Persona.
     */
    @Disabled
    @Test
    public void testIsMayorDeEdad() {
        System.out.println("isMayorDeEdad");
        Persona instance = new Persona(26);
        boolean expResult = true;
        boolean result = instance.isMayorDeEdad();
        assertEquals(expResult, result);
       
    }
    
    @ParameterizedTest
    @CsvSource({
        
            "26, true",
            "15, false",
            "125, false",
            "18, true",
            "120, true",
            "17, false",
            "121, false"
            
        })
    
    public void testIsMayorDeEdadParametrizado(int _edad, boolean esperado) {
        
        Persona instance = new Persona(_edad);        
        boolean resultado = instance.isMayorDeEdad();
        assertEquals(esperado, resultado);
       
    }
    
}

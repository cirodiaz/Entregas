package com.estadisticas.test;

/**
 * @author Ciro D�az
 * Programa calculador de rangos de valores para PSP2 
 * Versi�n: 1.0
 * Creado: 20/03/2017
 * �ltima modificaci�n: N/A
 */


import java.util.LinkedList;


import org.junit.Before;
import org.junit.Test;
import com.estadisticas.entities.*;

//Libreria de pruebas de Java; incluir en el POM.xml para hacer build en maven
import junit.framework.TestCase;

/**
 * Clase de pruebas para el calculador de regresi�n lineal y correlaci�n.
 * El cubrimiento es de 30% (15 metodos, 5 metodos probados)
 */
public class UnitTest extends TestCase {

	//Se inicializan los valores para las pruebas
	private double expectedValue = 0.36757;
	private SimpsonsRuleIntegrator testSimpsons = new SimpsonsRuleIntegrator(0.00001);

	//margen de error de igualdad para valores flotantes (double)
	private final double delta = 0.0001;
	
		/**
	 * Valores de prueba, basados en el ejemplo del enunciado: 130;186
	 * @throws java.lang.Exception
	 */
	
	/**
	 * Prueba de caso 2:
	 * Calculo integral
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase1() throws Exception {
		
		
		//Prueba sobre el calculo de la integral basado en el caso 2 de las pruebas
		assertEquals("El valor de la integracion debe ser 0.36757", 0.36757, testSimpsons.computeFullSimpsons(1.1812, 10, 10),delta);
        
		       
	}
	
	/**
	 * Prueba de computar funcion
	 * Calculo gamma para un numero arbitrario
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase2() throws Exception {
		
	
        //Prueba sobre el calculo de gamma, caso de un entero
		assertEquals("El valor de gamma debe ser 24", 24, testSimpsons.computeFunction(5),delta);
		
		       
		}
	
	/**
	 * Prueba lectura de archivo
	 * @throws java.lang.Exception
	 **/
	
}

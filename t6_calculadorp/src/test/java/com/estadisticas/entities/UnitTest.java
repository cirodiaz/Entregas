package com.estadisticas.test;

/**
 * @author Ciro Diaz
 * Programa calculador de valores de x para la funcion t, que puedan dar un resultado p 
 * Versi�n: 1.0
 * Creado: 20/03/2017
 * �ltima modificaci�n: N/A
 */


//import java.util.LinkedList;


//import org.junit.Before;
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
	private XValuesCalculator testXValCalc = new XValuesCalculator();

	//margen de error de igualdad para valores flotantes (double)
	private final double delta = 0.00001;
	
		/**
	 * Valores de prueba, basados en el ejemplo del enunciado: 130;186
	 * @throws java.lang.Exception
	 */
	
	/**
	 * Prueba de caso 3:
	 * Calculo de x para un p determinado
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase3() throws Exception {
		
		
		//Prueba sobre el calculo de la integral basado en el caso 2 de las pruebas
		assertEquals("El valor esperado debe ser 4.60409", 4.60409, testXValCalc.computeXValueForP(0.495, 4),delta);
        
		       
	}
	
	/**
	 * Prueba de caso 1
	 * Calculo gamma para un numero arbitrario
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase2() throws Exception {
		
	
        //Prueba sobre el calculo de gamma, caso de un entero
		assertEquals("El valor esperado debe ser 0.5538", 0.55338, testXValCalc.computeXValueForP(0.2, 6),delta);
		
		       
		}
	
	
}

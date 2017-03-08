package com.estadisticas.test;

/**
 * @author Ciro Díaz
 * Programa calculador de regresion lineal, correlacion y estimacion mejoradapara PSP2 
 * Versión: 1.0
 * Creado: 06/03/2017
 * Última modificación: N/A
 */


import java.util.LinkedList;


import org.junit.Before;
import org.junit.Test;
import com.estadisticas.entities.*;

//Libreria de pruebas de Java; incluir en el POM.xml para hacer build en maven
import junit.framework.TestCase;

/**
 * Clase de pruebas para el calculador de regresión lineal y correlación.
 * El cubrimiento es de 30% (15 metodos, 5 metodos probados)
 */
public class RegressionTest extends TestCase {

	//Se inicializan los valores para las pruebas
	private LinkedList<Value> testList = new LinkedList<Value>();
	private ValuesArray valArrayTest = new ValuesArray();
	private double testEstimate = 386;
	private LinearRegression testRegression = null;
	//margen de error de igualdad para valores flotantes (double)
	private final double delta = 0.0001;
	/**
	 * Valores de prueba, basados en el ejemplo del enunciado: 130;186
	 * 650;699
	 * 99;132
	 * 150;272
	 * 128;291
	 * 302;331
	 * 95;199
	 * 945;1890
	 * 368;788
	 * 961;1601
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpRegression() throws Exception {
		
		//Para la prueba, se insertan los valores a la lista
		
		Value testValue = new Value(130,186); 
		testList.add(testValue);
		testValue = new Value(650,699); 
		testList.add(testValue);
		testValue = new Value(99,132); 
		testList.add(testValue);
		testValue = new Value(150,272); 
		testList.add(testValue);
		testValue = new Value(128,291); 
		testList.add(testValue);
		testValue = new Value(302,331); 
		testList.add(testValue);
		testValue = new Value(95,199); 
		testList.add(testValue);
		testValue = new Value(945,1890); 
		testList.add(testValue);
		testValue = new Value(368,788); 
		testList.add(testValue);
		testValue = new Value(961,1601); 
		testList.add(testValue);
		

		
	}
	
	@Before
	public void setUpImprovedEstimation() throws Exception {
		
		//Para la prueba, se insertan los valores a la lista		
		Value testValue = new Value(130,186); 
		testList.add(testValue);
		testValue = new Value(650,699); 
		testList.add(testValue);
		testValue = new Value(99,132); 
		testList.add(testValue);
		testValue = new Value(150,272); 
		testList.add(testValue);
		testValue = new Value(128,291); 
		testList.add(testValue);
		testValue = new Value(302,331); 
		testList.add(testValue);
		testValue = new Value(95,199); 
		testList.add(testValue);
		testValue = new Value(945,1890); 
		testList.add(testValue);
		testValue = new Value(368,788); 
		testList.add(testValue);
		testValue = new Value(961,1601); 
		testList.add(testValue);
		testRegression = valArrayTest.computeLinearRegression(testList);
		

		
	}
	
	/**
	 * Prueba de regresion, se prueban:
	 * La clase Value (instanciacion de objetos)
	 * Calculo de regresion 
	 * Calculo de correlacion
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testRegression() throws Exception {
		
		setUpRegression();
		
		//Prueba sobre la asignacion de valores
		assertNotNull("Debe haber valores en la lista", testList.get(2).getxValue());
		assertEquals("El cuarto valor x de la lista debe ser 150", (double)150.0, testList.get(3).getxValue(),delta);
		assertEquals("El cuarto valor y de la lista debe ser 272", 272.0, testList.get(3).getyValue(),delta);
        //Prueba sobre la regresion lineal
		assertEquals("El valor de beta0 debe ser -22.5525", -22.5525, valArrayTest.computeLinearRegression(testList).getBeta0(),delta);
		assertEquals("El valor de beta1 debe ser 1.727932", 1.727932, valArrayTest.computeLinearRegression(testList).getBeta1(),delta);
		       
	}
	
	/**
	 * Prueba de regresion, se prueban:
	 * La clase Value (instanciacion de objetos)
	 * Calculo de regresion 
	 * Calculo de correlacion
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCorrelation() throws Exception {
		
		setUpRegression();
		
		//Prueba sobre la correlacion
		assertEquals("El valor de r debe ser 0.9545", 0.9545, valArrayTest.computeCorrelation(testList)[0],delta);
		assertEquals("El valor de r debe ser 0.9111", 0.9111, valArrayTest.computeCorrelation(testList)[1],delta);
	       
	}
	
	/**
	 * Prueba de regresion, se prueba:
	 * Calculo de estimacion mejorada
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testEstimation() throws Exception {
		
		setUpImprovedEstimation();
		
		//Prueba sobre la asignacion de valores
        assertEquals("La estimacion mejorada para 386 debe ser 644.4294", 644.4294, valArrayTest.computeImprovedEstimation(testRegression, testEstimate),delta);
		
	}
	
}

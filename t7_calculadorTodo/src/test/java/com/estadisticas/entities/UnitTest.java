package com.estadisticas.test;

import java.io.File;
import java.util.LinkedList;

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
	private final double delta = 0.0001;
	
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
	
	/**
	 * Prueba de caso 7.1
	 * Calculo pruebas sobre archivo de prueba 1 (datos proporcionados por guia psp)
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase4() throws Exception {
		
	
        //Prueba sobre el caso 1 de la guia de psp, con pruebas a todos los metodos publicos.
		ValuesArray valArray = new ValuesArray();
		String filePath = new File("").getAbsolutePath();
		LinkedList<Value> valuesToCalcT1;
		valuesToCalcT1 = valArray.readFromFile(filePath+"\\src\\main\\resources\\testFiles\\test1.txt");
		LinearRegression linReg = valArray.computeLinearRegression(valuesToCalcT1);
		double [] predInt = valArray.computePredictionInterval(valuesToCalcT1, 386);
		double [] correlation = valArray.computeCorrelation(valuesToCalcT1); 
					assertEquals("El valor esperado de Correlacion debe ser = ",0.954496574, correlation[0],delta);
					assertEquals("El valor esperado de rCuadrado debe ser = " ,0.91106371, correlation[1],delta);
					assertEquals("El valor esperado de Significancia debe ser = ",1.77517E-05,valArray.computeSignificance(valuesToCalcT1),delta); 
					assertEquals("El valor esperado de Regresion Lineal debe ser: beta0 = ",-22.55253275,linReg.getBeta0(),delta);
					assertEquals("El valor esperado de Regresion Lineal debe ser: beta1 = ",1.727932426, linReg.getBeta1(),delta);
					assertEquals("El valor esperado de Estimacion mejorada debe ser = ",644.4293838,valArray.computeImprovedEstimation(linReg, 386),delta);
					assertEquals("El valor esperado de Intervalo de Prediccion debe ser : Rango = ",230.0017197,predInt[0],delta);
					assertEquals("El valor esperado de Intervalo de Prediccion debe ser : UPI =",874.4311035, predInt[1],delta);
					assertEquals("El valor esperado de Intervalo de Prediccion debe ser : LPI =",414.427664, predInt[2],delta);

		
		       
		}
}

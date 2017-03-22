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
	private LinkedList<Value> expectedValues = new LinkedList<Value>();
	private LinkedList<Value> testList = new LinkedList<Value>();
	private LinkedList<Value> testRanges = new LinkedList<Value>();
	private ValuesArray valArrayTest = new ValuesArray();

	//margen de error de igualdad para valores flotantes (double)
	private final double delta = 0.0001;
	
	//archivo por defecto que se llamar� para probar la lectura de archivo.
	final String DEFAULT_FILENAME = "C:\\tarea4\\archivoin.txt";
	/**
	 * Valores de prueba, basados en el ejemplo del enunciado: 130;186
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUpCase1() throws Exception {
		
		//Para la prueba, se insertan los valores a la lista
		
		Value testValue = new Value("each_char",6); 
		testList.add(testValue);
		testValue = new Value("string_read",6); 
		testList.add(testValue);
		testValue = new Value("single_character",(float)8.3333); 
		testList.add(testValue);
		testValue = new Value("each_line",(float)10.3333); 
		testList.add(testValue);
		testValue = new Value("single_char",(float)12.3333); 
		testList.add(testValue);
		testValue = new Value("string_builder",(float)16.4000); 
		testList.add(testValue);
		testValue = new Value("string_manager",(float)20.5000); 
		testList.add(testValue);
		testValue = new Value("list_clump",(float)21.7500); 
		testList.add(testValue);
		testValue = new Value("list_clip",(float)22.2500); 
		testList.add(testValue);
		testValue = new Value("string_decrementer",(float)23.0000); 
		testList.add(testValue);
		testValue = new Value("Char",(float)28.3333); 
		testList.add(testValue);
		testValue = new Value("Character",(float)29.0000); 
		testList.add(testValue);
		testValue = new Value("Converter",(float)55.8000); 
		testList.add(testValue);
		
		testValue = new Value(Range.VERY_SMALL.toString(),(float)4.3953); 
		expectedValues.add(testValue);
		testValue = new Value(Range.SMALL.toString(),(float)8.5081); 
		expectedValues.add(testValue);
		testValue = new Value(Range.MEDIUM.toString(),(float)16.4696); 
		expectedValues.add(testValue);
		testValue = new Value(Range.LARGE.toString(),(float)31.8811); 
		expectedValues.add(testValue);
		testValue = new Value(Range.VERY_LARGE.toString(),(float)61.7137); 
		expectedValues.add(testValue);
		
		testRanges = valArrayTest.setRanges(testList);
		
	}
	
	@Before
	public void setUpCase2() throws Exception {
		
		//Para la prueba, se insertan los valores a la lista		
		Value testValue = new Value("Preface",7); 
		testList.add(testValue);
		testValue = new Value("Chapter 1",12); 
		testList.add(testValue);
		testValue = new Value("Chapter 2",10); 
		testList.add(testValue);
		testValue = new Value("Chapter 3",12);
		testList.add(testValue);
		testValue = new Value("Chapter 4",10);
		testList.add(testValue);
		testValue = new Value("Chapter 5",12);
		testList.add(testValue);
		testValue = new Value("Chapter 6",12);
		testList.add(testValue);
		testValue = new Value("Chapter 7",12);
		testList.add(testValue);
		testValue = new Value("Chapter 8",12);
		testList.add(testValue);
		testValue = new Value("Chapter 9",8);
		testList.add(testValue);
		testValue = new Value("Appendix A",8);
		testList.add(testValue);
		testValue = new Value("Appendix B",8);
		testList.add(testValue);
		testValue = new Value("Appendix C",20);
		testList.add(testValue);
		testValue = new Value("Appendix D",14);
		testList.add(testValue);
		testValue = new Value("Appendix E",18);
		testList.add(testValue);
		testValue = new Value("Appendix F",12);
		testList.add(testValue);
		
		testValue = new Value(Range.VERY_SMALL.toString(),(float)6.3375); 
		expectedValues.add(testValue);
		testValue = new Value(Range.SMALL.toString(),(float)8.4393); 
		expectedValues.add(testValue);
		testValue = new Value(Range.MEDIUM.toString(),(float)11.2381); 
		expectedValues.add(testValue);
		testValue = new Value(Range.LARGE.toString(),(float)14.9650); 
		expectedValues.add(testValue);
		testValue = new Value(Range.VERY_LARGE.toString(),(float)19.9280); 
		expectedValues.add(testValue);
		
		testRanges = valArrayTest.setRanges(testList);
		
	}
	
	/**
	 * Prueba de caso 1:
	 * Calculo de rangos
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase1() throws Exception {
		
		setUpCase1();
		
		//Prueba sobre la asignacion de valores
		assertNotNull("Debe haber valores en la lista", testList.get(2).getValue());
		assertEquals("El cuarto valor de etiqueta de la lista debe ser each_line", "each_line", testList.get(3).getLabel());
		assertEquals("El cuarto valor de n�mero de la lista debe ser 10.3333", (float)10.3333, testList.get(3).getValue(),delta);
        //Prueba sobre el c�lculo de rangos, caso 1
		assertEquals("El valor de VS debe ser 4.3953", expectedValues.get(0).getValue(),testRanges.get(0).getValue(),delta);
		assertEquals("El valor de VS debe ser 8.5081", expectedValues.get(1).getValue(),testRanges.get(1).getValue(),delta);
		assertEquals("El valor de VS debe ser 16.4696", expectedValues.get(2).getValue(),testRanges.get(2).getValue(),delta);
		assertEquals("El valor de VS debe ser 31.8811", expectedValues.get(3).getValue(),testRanges.get(3).getValue(),delta);
		assertEquals("El valor de VS debe ser 61.7137", expectedValues.get(4).getValue(),testRanges.get(4).getValue(),delta);
		       
	}
	
	/**
	 * Prueba de caso 2:
	 * Calculo de rangos
	 * @throws java.lang.Exception
	 **/
	
	@Test
	public void testCase2() throws Exception {
		
	setUpCase2();
		
		//Prueba sobre la asignacion de valores
		assertNotNull("Debe haber valores en la lista", testList.get(2).getValue());
		assertEquals("El cuarto valor de etiqueta de la lista debe ser Chapter 3", "Chapter 3", testList.get(3).getLabel());
		assertEquals("El cuarto valor de n�mero de la lista debe ser 12", 12, testList.get(3).getValue(),delta);
        //Prueba sobre el c�lculo de rangos, caso 1
		assertEquals("El valor de VS debe ser 6.3375", expectedValues.get(0).getValue(),testRanges.get(0).getValue(),delta);
		assertEquals("El valor de VS debe ser 8.4393", expectedValues.get(1).getValue(),testRanges.get(1).getValue(),delta);
		assertEquals("El valor de VS debe ser 11.2381", expectedValues.get(2).getValue(),testRanges.get(2).getValue(),delta);
		assertEquals("El valor de VS debe ser 14.9650", expectedValues.get(3).getValue(),testRanges.get(3).getValue(),delta);
		assertEquals("El valor de VS debe ser 19.9280", expectedValues.get(4).getValue(),testRanges.get(4).getValue(),delta);
		       
		}
	
	/**
	 * Prueba lectura de archivo
	 * @throws java.lang.Exception
	 **/
	
}

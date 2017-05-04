package com.estadisticas.entities;




/**
 * @author Ciro Diaz
 * Programa calculador de integrales por metodo de simpson, con extension para hallar el valor de x para una p esperada
 * Versiin: 1.0 (web)
 * Creado: 19/04/2017
 * Ultima modificaciin: N/A
 */

import java.util.LinkedList;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
public class Calculator {
	
	@SuppressWarnings("finally")
	public static void main(String args[]){
		
		//Para este programa, solo se hara la impresion para los valores de prueba determinados en el ejercicio
		
		//XValuesCalculator calc = new XValuesCalculator(); //Solo para pruebas en consola
	    	port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

	
	    //Metodo para generar datos de las pruebas
	    get("/test1", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			XValuesCalculator calc = new XValuesCalculator();

			LinkedList<String> valuesToPrint = new LinkedList<String>();
			//se insertan los valores para mostrarlos en la pagina de pruebas
				valuesToPrint.add("Prueba 1: grados de libertad = 6, p = 0.20 esperado = 0.55338, Resultado: x= "+ calc.computeXValueForP(0.20, 6));
				valuesToPrint.add("Prueba 2: grados de libertad = 15, p = 0.45 esperado = 1.75305, Resultado: x= "+ calc.computeXValueForP(0.45, 15));
				valuesToPrint.add("Prueba 3: grados de libertad = 4, p = 0.495 esperado = 4.60409, Resultado: x= "+ calc.computeXValueForP(0.495, 4));
			attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
	    
			//System.out.println("Prueba 1: grados de libertad = 6, p = 0.20 esperado = 0.55338, Resultado: x= "+ calc.computeXValueForP(0.20, 6));
			//System.out.println("Prueba 2: grados de libertad = 15, p = 0.45 esperado = 1.75305, Resultado: x= "+ calc.computeXValueForP(0.45, 15));
			//System.out.println("Prueba 3: grados de libertad = 4, p = 0.495 esperado = 4.60409, Resultado: x= "+ calc.computeXValueForP(0.495, 4));
			
	  //Metodo para generar datos de las pruebas
	    get("/testProgram7", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			//preparacion de datos para prueba
			ValuesArray valArray = new ValuesArray();
			String filePath = new File("").getAbsolutePath();
			System.out.println (filePath);
			//prueba1
			LinkedList<Value> valuesToCalcT1,valuesToCalcT2,valuesToCalcT3,valuesToCalcT4;
			try {
				valuesToCalcT1 = valArray.readFromFile(filePath+"\\src\\main\\resources\\testFiles\\test1.txt");
				valuesToCalcT2 = valArray.readFromFile(filePath+"\\src\\main\\resources\\testFiles\\test2.txt");
				valuesToCalcT3 = valArray.readFromFile(filePath+"\\src\\main\\resources\\testFiles\\test3.txt");
				valuesToCalcT4 = valArray.readFromFile(filePath+"\\src\\main\\resources\\testFiles\\test4.txt");
			
			LinkedList<String> valuesToPrint = new LinkedList<String>();
			//se insertan los valores para mostrarlos en la pagina de pruebas
			LinearRegression linReg = valArray.computeLinearRegression(valuesToCalcT1);
			double [] predInt = valArray.computePredictionInterval(valuesToCalcT1, 386);
			double [] correlation = valArray.computeCorrelation(valuesToCalcT1); 
				valuesToPrint.add("Prueba 1: \nCorrelacion: r = " + correlation[0]
								+ " rCuadrado = " + correlation[1]
								+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT1) 
								+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
								+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 386)
								+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
								+ "\n UPI =" + predInt[1]
								+ "\n LPI =" + predInt[2]);
				//finprueba1
				
				//se calculan los valores para mostrarlos en la lista de pruebas 2
				linReg = valArray.computeLinearRegression(valuesToCalcT2);
				predInt = valArray.computePredictionInterval(valuesToCalcT2, 386);
				correlation = valArray.computeCorrelation(valuesToCalcT2); 
					valuesToPrint.add("Prueba 2: \nCorrelacion: r = " + correlation[0]
									+ " rCuadrado = " + correlation[1]
									+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT2) 
									+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
									+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 386)
									+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
									+ "\n UPI =" + predInt[1]
									+ "\n LPI =" + predInt[2]);
					//finprueba2
					
					//se calculan los valores para mostrarlos en la lista de pruebas 3
					linReg = valArray.computeLinearRegression(valuesToCalcT3);
					predInt = valArray.computePredictionInterval(valuesToCalcT3, 386);
					correlation = valArray.computeCorrelation(valuesToCalcT3); 
						valuesToPrint.add("Prueba 3: \nCorrelacion: r = " + correlation[0]
										+ " rCuadrado = " + correlation[1]
										+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT3) 
										+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
										+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 126)
										+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
										+ "\n UPI =" + predInt[1]
										+ "\n LPI =" + predInt[2]);
						//finprueba3
						
						//se calculan los valores para mostrarlos en la lista de pruebas 4
						linReg = valArray.computeLinearRegression(valuesToCalcT4);
						predInt = valArray.computePredictionInterval(valuesToCalcT4, 386);
						correlation = valArray.computeCorrelation(valuesToCalcT4); 
							valuesToPrint.add("Prueba 4: \nCorrelacion: r = " + correlation[0]
											+ " rCuadrado = " + correlation[1]
											+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT3) 
											+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
											+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 126)
											+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
											+ "\n UPI =" + predInt[1]
											+ "\n LPI =" + predInt[2]);
							//finprueba4
				
				attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally
			{
				return new ModelAndView(attributes, "calculation.ftl");
				
			}
		}, new FreeMarkerEngine());
	    /*
			//System.out.println("Prueba 1: grados de libertad = 6, p = 0.20 esperado = 0.55338, Resultado: x= "+ calc.computeXValueForP(0.20, 6));
			//System.out.println("Prueba 2: grados de libertad = 15, p = 0.45 esperado = 1.75305, Resultado: x= "+ calc.computeXValueForP(0.45, 15));
			//System.out.println("Prueba 3: grados de libertad = 4, p = 0.495 esperado = 4.60409, Resultado: x= "+ calc.computeXValueForP(0.495, 4));
		
	    //preparacion de datos para prueba
		ValuesArray valArray = new ValuesArray();
		String filePath = new File("").getAbsolutePath();
		//System.out.println (filePath);
		//prueba1
		LinkedList<Value> valuesToCalcT1,valuesToCalcT2,valuesToCalcT3,valuesToCalcT4;
		try {
				valuesToCalcT1 = valArray.readFromFile(filePath+"\\testFiles\\test1.txt");
				valuesToCalcT2 = valArray.readFromFile(filePath+"\\testFiles\\test2.txt");
				valuesToCalcT3 = valArray.readFromFile(filePath+"\\testFiles\\test3.txt");
				valuesToCalcT4 = valArray.readFromFile(filePath+"\\testFiles\\test4.txt");
		
		
			
		

		//se insertan los valores para mostrarlos en la pagina de pruebas
		LinearRegression linReg = valArray.computeLinearRegression(valuesToCalcT1);
		double [] predInt = valArray.computePredictionInterval(valuesToCalcT1, 386);
		double [] correlation = valArray.computeCorrelation(valuesToCalcT1); 
			System.out.println("Prueba 1: \nCorrelacion: r = " + correlation[0]
					+ " rCuadrado = " + correlation[1]
					+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT1) 
					+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
					+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 386)
					+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
					+ "\n UPI =" + predInt[1]
					+ "\n LPI =" + predInt[2]);
			//finprueba1
			linReg = valArray.computeLinearRegression(valuesToCalcT2);
			predInt = valArray.computePredictionInterval(valuesToCalcT2, 386);
			correlation = valArray.computeCorrelation(valuesToCalcT2);
			System.out.println("Prueba 2: \nCorrelacion: r = " + correlation[0]
					+ " rCuadrado = " + correlation[1]
					+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT2) 
					+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
					+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 126)
					+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
					+ "\n UPI =" + predInt[1]
					+ "\n LPI =" + predInt[2]);
			
			//finprueba2
			linReg = valArray.computeLinearRegression(valuesToCalcT3);
			predInt = valArray.computePredictionInterval(valuesToCalcT3, 386);
			correlation = valArray.computeCorrelation(valuesToCalcT3); 
			System.out.println("Prueba 3: \nCorrelacion: r = " + correlation[0]
					+ " rCuadrado = " + correlation[1]
					+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT3) 
					+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
					+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 126)
					+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
					+ "\n UPI =" + predInt[1]
					+ "\n LPI =" + predInt[2]);
			
			//finprueba3
			linReg = valArray.computeLinearRegression(valuesToCalcT4);
			predInt = valArray.computePredictionInterval(valuesToCalcT4, 386);
			correlation = valArray.computeCorrelation(valuesToCalcT4); 
			System.out.println("Prueba 4: \nCorrelacion: r = " + correlation[0]
					+ " rCuadrado = " + correlation[1]
					+ "\nSignificancia = " + valArray.computeSignificance(valuesToCalcT3) 
					+ "\nRegresion Lineal: beta0 = "+ linReg.getBeta0() + ", beta1 = " + linReg.getBeta1()
					+ "\nEstimacion mejorada = " + valArray.computeImprovedEstimation(linReg, 386)
					+ "\nIntervalos de Prediccion: Rango = "+predInt[0]
					+ "\n UPI =" + predInt[1]
					+ "\n LPI =" + predInt[2]);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}



}

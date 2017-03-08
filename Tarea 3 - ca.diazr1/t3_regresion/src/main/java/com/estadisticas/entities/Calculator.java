package com.estadisticas.entities;

/**
 * @author Ciro Díaz
 * Programa calculador de regresion lineal, correlacion y estimacion mejorada para PSP2 
 * Versión: 1.0
 * Creado: 06/03/2017
 * Última modificación: N/A
 */

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class Calculator {
	
	public static void main(String args[]){
		
		//Se solicita el archivo desde donde se leera los valores, y se instancia la clase de utilidad, donde se calculan los requerimientos
		String fileName = "C:\\tarea3\\archivoin.txt";
		Scanner reader = new Scanner(System.in);
		ValuesArray valArray = new ValuesArray();
		// Los valores se guardarán en una lista, una vez se hayan leido
		try{
		LinkedList<Value> valuesToCalc = valArray.readFromFile(fileName);
		System.out.println("Por favor digite un valor de estimacion: ");
		double estimate=reader.nextDouble();
		//Se calculan las estadisticas de regresion lineal, usando los metodos de la clase ValuesArray
		LinearRegression linearReg = valArray.computeLinearRegression(valuesToCalc);
		double[] correlation = valArray.computeCorrelation(valuesToCalc);
		double improvedEstimate = valArray.computeImprovedEstimation(linearReg,estimate);
		
		System.out.println("Los valores base para los cálculos son: \n");
		for(int i=0;i<valuesToCalc.size();i++){
			System.out.println("x"+i+" "+valuesToCalc.get(i).getxValue()+"; " + "y"+i+" "+valuesToCalc.get(i).getyValue()+"\n");
			
		}
		
		System.out.println("Para los valores dados la fórmula de regresión lineal es: y = "+linearReg.getBeta0() + " + "
				+ "" +linearReg.getBeta1()+"x \ny la correlación es r: " + correlation[0] + " y rcuadrado:" + correlation[1] );

		System.out.println("Para la estimacion dada: "+ estimate + ", la estimacion mejorada es: "+ improvedEstimate );
		
		} catch (FileNotFoundException fe){
			System.out.println("no se ha encontrado el archivo, por favor verificar");
			
		} finally{
			try{
			reader.close();
			} catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
	}



}

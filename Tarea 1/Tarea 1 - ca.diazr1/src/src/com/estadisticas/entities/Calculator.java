package com.estadisticas.entities;

import java.io.FileNotFoundException;
import java.util.LinkedList;


public class Calculator {
	
	public static void main(String args[]){
		
		/*Se solicita el archivo desde donde se leer�n los valores, y se instancia la clase de utilidad, donde se calculan los requerimientos*/
		String fileName = "C:\\tarea1\\archivoin.txt";
		ValuesArray valArray = new ValuesArray();
		/* Los valores se guardar�n en una lista, una vez se hayan le�do*/
		try{
		LinkedList<Float> valuesToCalc = valArray.readFromFile(fileName);
		/*Se calculan el promedio y la desviaci�n est�ndar, usando los m�todos de la clase ValuesArray*/
		Float avg = valArray.calculateAvg(valuesToCalc);
		Float stdDev = valArray.calculateStdDeviation(valuesToCalc);
		
		System.out.println("Los valores a calcular son: \n");
		for(int i=0;i<valuesToCalc.size();i++){
			System.out.println(valuesToCalc.get(i)+"\n");
			
		}
		System.out.println("Para estos valores, el promedio es: "+avg+" y la desviaci�n est�ndar es: " + stdDev);
		
		} catch (FileNotFoundException fe){
			System.out.println("no se ha encontrado el archivo, por favor verificar");
			
		}
		
	}



}

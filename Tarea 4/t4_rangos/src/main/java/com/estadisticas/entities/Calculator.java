package com.estadisticas.entities;

/**
 * @author Ciro Diaz
 * Programa calculador de regresion lineal, correlacion y estimacion mejorada para PSP2 
 * Version: 1.0
 * Creado: 06/03/2017
 * ultima modificacion: N/A
 */

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class Calculator {
	
	public static void main(String args[]){
		
		//Se solicita el archivo desde donde se leera los valores, y se instancia la clase de utilidad, donde se calculan los requerimientos
		final String DEFAULT_FILENAME = "C:\\tarea4\\archivoin.txt";
		String fileName;
		Scanner reader = new Scanner(System.in);
		ValuesArray valArray = new ValuesArray();
		LinkedList<Value> valuesToCalc = null;
		LinkedList<Value> rangeValues = null;
		// Los valores se guardaran en una lista, dependiendo de la opcion que escoja el usuario
		try{
			System.out.println("Por favor digite (1) si desea cargar un archivo desde una ruta, o "
					+ "(2) si desea utilizar la ruta por defecto - La ruta por defecto es (C:\\tarea4\\archivoin.txt): ");
			int option=reader.nextInt();
			switch(option){
			case 1:
				
				System.out.println("Por favor digite la ruta absoluta del archivo que desea que se lea, incluyendo unidad y extension (ej:"
						+ "C:\\tarea4\\archivoin.txt): ");
				reader.useDelimiter(System.getProperty("line.separator"));
				fileName = reader.next();
				valuesToCalc = valArray.readFromFile(fileName);
				break;
			case 2:
				valuesToCalc = valArray.readFromFile(DEFAULT_FILENAME);
			}
		
		
		//Se calculan los rangos con base en la lista de valores leidos.
		rangeValues = valArray.setRanges(valuesToCalc);
		
		System.out.println("Los valores base para los calculos de rangos son: \n");
		for(int i=0;i<valuesToCalc.size();i++){
			System.out.println("Etiqueta: "+valuesToCalc.get(i).getLabel()+"; " + "valor: "+valuesToCalc.get(i).getValue()+"\n");
			
		}
		
		System.out.println("Los valores base para los calculos de rangos son: \n");
		for(int i=0;i<rangeValues.size();i++){
			System.out.println("Tamano: " + rangeValues.get(i).getLabel()+"; " + "valor: "+  rangeValues.get(i).getValue()+"\n");
			
		}		
		
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

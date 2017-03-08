package com.estadisticas.entities;

/**
 * @author Ciro Díaz
 * Programa calculador de regresion lineal, correlacion y estimacion mejorada para PSP2 
 * Versión: 1.0
 * Creado: 06/03/2017
 * Última modificación: N/A
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


//Libreria de matematicas usada para los calculos de regresion linea y correlacion: insertar en el POM.xml para hacer build en maven 
import org.apache.commons.math3.stat.regression.SimpleRegression;


public class ValuesArray {
		
	/**
	 * Toma un arreglo de n pares de valores, y calcula la regresion lineal para ellos
	 * @param valuePairs
	 * @return
	 */
	public LinearRegression computeLinearRegression(LinkedList<Value> valuePairs){
		
		LinearRegression regressionResult = new LinearRegression(0, 0);
		SimpleRegression regression  = new SimpleRegression();
		//Usando la librería Apache Commons, se calcula la regresión lineal de los valores que se ingresen a este método.
		for(int i=0;i<valuePairs.size();i++){
			
			Value currVal = valuePairs.get(i);
			regression.addData(currVal.getxValue(), currVal.getyValue());
		}
		
		regressionResult.setBeta0(regression.getIntercept());
		regressionResult.setBeta1(regression.getSlope());
		
		return regressionResult;
		
	}
	
	public double[] computeCorrelation(LinkedList<Value> valuePairs){
		SimpleRegression regression = new SimpleRegression();
		for(int i=0;i<valuePairs.size();i++){
			
			Value currVal = valuePairs.get(i);
			regression.addData(currVal.getxValue(), currVal.getyValue());
		}
		double[] correlation = {regression.getR(),regression.getRSquare()};
		
		return correlation;
	}
	
	/**
	 * Calcula una estimacion mejorada, con base en la regresion lineal calculada para los valores de entrada
	 * @param regression
	 * @param estimation
	 * @return
	 */
	public double computeImprovedEstimation(LinearRegression regression,double estimation){
		
		//Si la estimacion no se puede hacer correctamente, el valor sera de cero. Se entiende que una estimacion no puede ser de cero.
		double improvedEstimation = 0; 
		
		improvedEstimation = regression.getBeta0()+regression.getBeta1()*estimation;
		
		return improvedEstimation;
	}

	/**
	 * Metodo de legado del programa 1; se toman los valores desde un archivo, y se insertan a una variable Value
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException
	 */
	public LinkedList<Value> readFromFile (String fileName) throws FileNotFoundException{
		
		//Se lee el archivo que se encuentra por defecto en c:\tarea3
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		//Si no se encuentran valores en el archivo, la lista retorna vacia (null)
		LinkedList<Value> list = new LinkedList<Value>();
		String values;
		
		try {
			values = reader.readLine();
		
			while(values !=null){
				if(!values.isEmpty()){
					StringTokenizer parts= new StringTokenizer(values,";");
					Value currVal = new Value(0,0);
					
					//Cada línea del archivo será un par de valores x, y para cargar a la lista
					if(parts.hasMoreTokens()){
						currVal.setxValue(Float.parseFloat(parts.nextToken()));
						currVal.setyValue(Float.parseFloat(parts.nextToken()));
					
					}
					
					if(!(currVal.getxValue()==0))
					list.add(currVal);
					
					values=reader.readLine();

		}
		}
		} catch (Exception e) {
			// Agarra cualquier excepción
			e.printStackTrace();
		} finally {
			
			try {
				reader.close();
			} catch (IOException e) {
				// Necesario para poder cerrar el reader.
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	
}

package com.estadisticas.entities;

/**
 * @author Ciro Diaz
 * Programa calculador todos los datos para psp 2.1
 * Version: 1.0
 * Creado: 02/05/2017
 * ultima modificacion: 03/05/2017
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class ValuesArray {
	
	
	//margen de error para los calculos de integrales
	private double errorMargin = 0.000000001; 
	/**
	 * Toma un arreglo de n pares de valores, y establece los rangos entre VS, S, M, L, VL
	 * @param valueList
	 * @return average
	 */

	public LinkedList<ValueLabel> setRanges(LinkedList<ValueLabel> valueList){
		
		LinkedList<ValueLabel> logarithmList = new LinkedList<ValueLabel>();
		LinkedList<ValueLabel> resultList = new LinkedList<ValueLabel>();
		for (int i=0;i<valueList.size();i++) {
			ValueLabel currVal = new ValueLabel("",0);
			//Se hace una lista con los valores de logaritmo natural de cada par de valores
			currVal.setLabel(valueList.get(i).getLabel());
			currVal.setValue(computeNaturalLogarithm(valueList.get(i).getValue()));
			logarithmList.add(currVal);
		}
		Float avg = (float) computeAverage(logarithmList);
		Float stdDev = (float) computeStdDeviation(logarithmList);
		
		for(int i=-2;i<=2;i++){
			ValueLabel currVal = new ValueLabel("",0);
			float logRange = avg + i*stdDev;
			
			switch (i) {
			case -2:
				currVal.setLabel(Range.VERY_SMALL.toString());
				break;
			case -1:
				currVal.setLabel(Range.SMALL.toString());
				break;
			case 0:
				currVal.setLabel(Range.MEDIUM.toString());
				break;
			case 1:
				currVal.setLabel(Range.LARGE.toString());
				break;
			case 2:
				currVal.setLabel(Range.VERY_LARGE.toString());
				break;
				
			default:
				break;
			}
			currVal.setValue((float)Math.pow(Math.E, logRange));
			resultList.add(currVal);
		}
		
		return resultList;
	}
	
	/**
	 * Toma un arreglo de n pares de valores, y calcula el promedio para ellos
	 * @param valuePairs
	 * @return average
	 */

	public Float computeNaturalLogarithm(float value){
		Float naturalLog = (float) Math.log(value);
		
		return naturalLog;
	}
	
	/**
	 * Toma un arreglo de n pares de valores, y calcula el promedio para ellos
	 * @param valuePairs
	 * @return average
	 */

	public Float computeAverage(LinkedList<ValueLabel> valueList){
		Float avg = (float) 0;
		Float totalSum = (float) 0;
		for (int i=0;i<valueList.size();i++) {
			totalSum +=valueList.get(i).getValue();
		}
		
		avg = totalSum/valueList.size();
		return avg;
	}
	
	/**
	 * Toma un arreglo de n pares de valores, y calcula la desviaci�n est�ndar para ellos
	 * @param valuePairs
	 * @return stdDev
	 */

	public Float computeStdDeviation(LinkedList<ValueLabel> list){
		Float stdDev = (float) 0;
		Float avg = computeAverage(list);
		Float variance = (float) 0;
		
		for(int i=0;i<list.size();i++){
			variance=(float) (variance + Math.pow((list.get(i).getValue()-avg), 2));
		}
		stdDev = (float) Math.sqrt(variance/(list.size()-1));
		return stdDev;
	}
	
	/**
	 * Metodo de legado del programa 1; se toman los valores desde un archivo, y se insertan a una variable Value
	 * @param fileName
	 * @return list values
	 * @throws FileNotFoundException
	 */
	public LinkedList<Value> readFromFile (String fileName) throws FileNotFoundException{
		
		//Se lee el archivo que se encuentra en la ruta ingresada, o se cargan los valores por defecto.
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
					
					//Cada linea del archivo sera un par de valores label, value para cargar a la lista
					if(parts.hasMoreTokens()){
						currVal.setxValue(Float.parseFloat(parts.nextToken()));
						currVal.setyValue(Float.parseFloat(parts.nextToken()));
					
					}
					
					
					list.add(currVal);
					
					values=reader.readLine();

		}
		}
		} catch (Exception e) {
			// Agarra cualquier excepci�n
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
	
	//Adiciones al codigo de la clase:
	
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
	 * Calcula la significancia de un conjunto de valores para encontrar si son validos para hacer estimacion
	 * @param valuePairs
	 * @return significance
	 */
	public double computeSignificance(LinkedList<Value> valuePairs){
		
		//Se hacen integracion de la probabilidad desde 0 hasta x (hallado previamente) y con el restante se encuentra 1-2*p, que es la significancia
		SimpsonsRuleIntegrator integrator = new SimpsonsRuleIntegrator(errorMargin);
		
		int dataPoints = valuePairs.size();
		double[] correlation = this.computeCorrelation(valuePairs);
		double r = correlation[0];
		double rSquare = correlation[1];
		double x = (Math.abs(r)*Math.sqrt(dataPoints-2))/Math.sqrt((1-rSquare));
		double probability = integrator.computeFullSimpsons(x, dataPoints-2, 10);
		//la significancia es el area bajo la curva que resta desde x hasta el final de la campana de datos.
		return 1-2*probability;
	}
	
	/**
	 * Calcula lo minimo y lo maximo que se espera se demore un desarrollo, basado en valores historicos
	 * @param valuePairs
	 * @return predictionInterval (double[])
	 */
	public double[] computePredictionInterval(LinkedList<Value> valuePairs, double expectedX){
		
		//Se hace calculo del rango superior e inferior de prediccion, basado en valores historicos.
		LinearRegression regression = this.computeLinearRegression(valuePairs);
		
		int dataPoints = valuePairs.size() - 2;
		
		//primero, se calcula la desviacion estandar, como parte de los valores para hallar el intervalo de prediccion
		double linearSum = 0;
		
		for(int i = 1; i <=valuePairs.size();i++ ){
			double currVal = valuePairs.get(i-1).getyValue() - regression.getBeta0() - regression.getBeta1()*valuePairs.get(i-1).getxValue();
			linearSum += Math.pow(currVal, 2);
		}
		
		double variance = (linearSum/dataPoints);
		double stdDev = Math.sqrt(variance);
		
		//luego, se calcula la prediccion mejorada
		double impPred = computeImprovedEstimation(regression, expectedX);
		
		//se calcula el numerador de la division de la formula de rango:
		double avgX = 0;
		for(int i=0;i<valuePairs.size();i++){
			avgX+=valuePairs.get(i).getxValue();
		}
		avgX=avgX/valuePairs.size();
		double numeratorFlat = expectedX - avgX;
		double numerator = Math.pow(numeratorFlat,2);
		
		// ahora el denominador
		
		double denominator = 0;
		for(int i = 1;i<=valuePairs.size();i++){
			double denSumFlat = valuePairs.get(i-1).getxValue() - avgX; 
			denominator+= Math.pow(denSumFlat,2);
		}
		
		// se halla todo lo que esta dentro de la raiz:
		
		double rootedResult = (double)1 + ((double)1/valuePairs.size())+(numerator/denominator);
		
		//se calcula el valor de x para p = 0.35 y los grados de libertad de dataPoints
		
		XValuesCalculator xValCalc = new XValuesCalculator();
		double tResult = xValCalc.computeXValueForP(0.35, dataPoints);
		
		//Se calculan el rango y los valores superior e inferior, y se retornan como un arreglo de tres valores, respectivamente
		
		double [] predictionInterval = {0,0,0};
		
		//el rango
		predictionInterval[0] = tResult*stdDev*Math.sqrt(rootedResult);
		
		//el intervalo de prediccion superior
		predictionInterval[1] = impPred + predictionInterval[0];
		
		//el intervalo de prediccion inferior
		predictionInterval[2] = impPred - predictionInterval[0];
		
		
		return predictionInterval;
	}
	
}

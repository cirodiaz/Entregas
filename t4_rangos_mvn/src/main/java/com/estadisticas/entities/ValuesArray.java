package com.estadisticas.entities;

/**
 * @author Ciro Diaz
 * Programa calculador de rangos de valores para PSP2 
 * Version: 1.0
 * Creado: 20/03/2017
 * ultima modificacion: N/A
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ValuesArray {
		
	/**
	 * Toma un arreglo de n pares de valores, y establece los rangos entre VS, S, M, L, VL
	 * @param valueList
	 * @return average
	 */
	//Para la interfaz web, se requiere un arreglo ya predeterminado, por lo que se cargan datos en el constructor, para que muestre la info
	//sin requerir entradas de parte del usuario.
	LinkedList<Value> valArray = new LinkedList<Value>();
	

	public ValuesArray(){
		Value value = new Value("each_char",6); 
		valArray.add(value);
		value = new Value("string_read",6); 
		valArray.add(value);
		value = new Value("single_character",(float)8.3333); 
		valArray.add(value);
		value = new Value("each_line",(float)10.3333); 
		valArray.add(value);
		value = new Value("single_char",(float)12.3333); 
		valArray.add(value);
		value = new Value("string_builder",(float)16.4000); 
		valArray.add(value);
		value = new Value("string_manager",(float)20.5000); 
		valArray.add(value);
		value = new Value("list_clump",(float)21.7500); 
		valArray.add(value);
		value = new Value("list_clip",(float)22.2500); 
		valArray.add(value);
		value = new Value("string_decrementer",(float)23.0000); 
		valArray.add(value);
		value = new Value("Char",(float)28.3333); 
		valArray.add(value);
		value = new Value("Character",(float)29.000); 
		valArray.add(value);
		value = new Value("Converter",(float)55.8000); 
		valArray.add(value);
		
		}
	
	public ValuesArray(int option){
		if (option==1){
		Value value = new Value("each_char",6); 
		valArray.add(value);
		value = new Value("string_read",6); 
		valArray.add(value);
		value = new Value("single_character",(float)8.3333); 
		valArray.add(value);
		value = new Value("each_line",(float)10.3333); 
		valArray.add(value);
		value = new Value("single_char",(float)12.3333); 
		valArray.add(value);
		value = new Value("string_builder",(float)16.4000); 
		valArray.add(value);
		value = new Value("string_manager",(float)20.5000); 
		valArray.add(value);
		value = new Value("list_clump",(float)21.7500); 
		valArray.add(value);
		value = new Value("list_clip",(float)22.2500); 
		valArray.add(value);
		value = new Value("string_decrementer",(float)23.0000); 
		valArray.add(value);
		value = new Value("Char",(float)28.3333); 
		valArray.add(value);
		value = new Value("Character",(float)29.000); 
		valArray.add(value);
		value = new Value("Converter",(float)55.8000); 
		valArray.add(value);
		} else {
			Value value = new Value("Preface",7); 
			valArray.add(value);
			value = new Value("Chapter 1",12); 
			valArray.add(value);
			value = new Value("Chapter 2",10); 
			valArray.add(value);
			value = new Value("Chapter 3",12);
			valArray.add(value);
			value = new Value("Chapter 4",10);
			valArray.add(value);
			value = new Value("Chapter 5",12);
			valArray.add(value);
			value = new Value("Chapter 6",12);
			valArray.add(value);
			value = new Value("Chapter 7",12);
			valArray.add(value);
			value = new Value("Chapter 8",12);
			valArray.add(value);
			value = new Value("Chapter 9",8);
			valArray.add(value);
			value = new Value("Appendix A",8);
			valArray.add(value);
			value = new Value("Appendix B",8);
			valArray.add(value);
			value = new Value("Appendix C",20);
			valArray.add(value);
			value = new Value("Appendix D",14);
			valArray.add(value);
			value = new Value("Appendix E",18);
			valArray.add(value);
			value = new Value("Appendix F",12);
			valArray.add(value);
		}
		
	}
	public LinkedList<Value> setRanges(LinkedList<Value> valueList){
		
		LinkedList<Value> logarithmList = new LinkedList<Value>();
		LinkedList<Value> resultList = new LinkedList<Value>();
		for (int i=0;i<valueList.size();i++) {
			Value currVal = new Value("",0);
			//Se hace una lista con los valores de logaritmo natural de cada par de valores
			currVal.setLabel(valueList.get(i).getLabel());
			currVal.setValue(computeNaturalLogarithm(valueList.get(i).getValue()));
			logarithmList.add(currVal);
		}
		Float avg = (float) computeAverage(logarithmList);
		Float stdDev = (float) computeStdDeviation(logarithmList);
		
		for(int i=-2;i<=2;i++){
			Value currVal = new Value("",0);
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

	public Float computeAverage(LinkedList<Value> valueList){
		Float avg = (float) 0;
		Float totalSum = (float) 0;
		for (int i=0;i<valueList.size();i++) {
			totalSum +=valueList.get(i).getValue();
		}
		
		avg = totalSum/valueList.size();
		return avg;
	}
	
	/**
	 * Toma un arreglo de n pares de valores, y calcula la desviacion estandar para ellos
	 * @param valuePairs
	 * @return stdDev
	 */

	public Float computeStdDeviation(LinkedList<Value> list){
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
					Value currVal = new Value("",0);
					
					//Cada l�nea del archivo sera un par de valores label, value para cargar a la lista
					if(parts.hasMoreTokens()){
						currVal.setLabel(parts.nextToken());
						currVal.setValue(Float.parseFloat(parts.nextToken()));
					
					}
					
					if(!(currVal.getLabel().equalsIgnoreCase("")))
					list.add(currVal);
					
					values=reader.readLine();

		}
		}
		} catch (Exception e) {
			// Agarra cualquier excepcion
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

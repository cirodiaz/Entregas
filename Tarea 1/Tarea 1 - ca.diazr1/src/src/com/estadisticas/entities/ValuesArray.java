package com.estadisticas.entities;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class ValuesArray {
	
	/*valor de entrada del archivo*/
	
	
	
	/* Se agarra el primer valor*/
	
	Value firstVal = null;
	

	/*Con los valores de entrada, se calcula el promedio*/
	public Float calculateAvg(LinkedList<Float> valueList){
		Float avg = (float) 0;
		Float totalSum = (float) 0;
		for (int i=0;i<valueList.size();i++) {
			totalSum +=valueList.get(i);
		}
		
		avg = totalSum/valueList.size();
		return avg;
	}
	/*Con los valores del archivo, se calcula la desviación estándar*/
	public Float calculateStdDeviation(LinkedList<Float> list){
		Float stdDev = (float) 0;
		Float avg = calculateAvg(list);
		Float variance = (float) 0;
		
		for(int i=0;i<list.size();i++){
			variance=(float) (variance + Math.pow((list.get(i)-avg), 2));
		}
		stdDev = (float) Math.sqrt(variance/(list.size()-1));
		return stdDev;
	}
	
	public LinkedList<Float> readFromFile (String fileName) throws FileNotFoundException{
		
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		LinkedList<Float> list = new LinkedList<Float>();
		String value;
		try {
			value = reader.readLine();
		
			while(value !=null){
				if(!value.isEmpty()){
					list.add(Float.parseFloat(value));
					value=reader.readLine();

		}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}

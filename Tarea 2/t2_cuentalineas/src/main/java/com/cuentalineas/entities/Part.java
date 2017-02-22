package com.cuentalineas.entities;

/**
 * @author Ciro D�az
 * Programa contador de l�neas
 * Versi�n: 1.0
 * Creado: 18/02/2017
 * �ltima modificaci�n: 21/02/2017
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Clase part, guarda el comportamiento que deben tener los archivos
   para aplicar est�ndares de conteo de l�neas
 */
public class Part {
	

	private String partName;
	private int lineAmount;
	private int methodAmount;
	private LinkedList<String> stringTest = new LinkedList<String>(); //Cadena para probar que el est�ndar no est� contando declaraciones de objetos como m�todos
	
	/**
	 * @return the partName
	 */
	public String getPartName() {
		return partName;
	}
	
	/**
	 * @param partName the partName to set
	 */
	public void setPartName(String partName) {
		this.partName = partName;
	}
	
	/**
	 * @return the lineAmount
	 */
	public int getLineAmount() {
		return lineAmount;
	}
	
	/**
	 * M�todo que establece la cantidad de l�neas que tiene un archivo dado, seg�n las reglas que se le alimenten para el conteo.
	 * @param lineAmount the lineAmount to set
	 * @throws IOException 
	 */
	public void setLineAmount(File file, LinkedList<Expression> standardRules) {
		try {
		FileInputStream fis = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		
			String line = reader.readLine();
			while(line !=null)
			{
				String appliedRules = standardRules.get(2).getRule();
				//esto es un comentario de prueba, no se deber�a contar
				Pattern p = Pattern.compile(appliedRules);
				Matcher m = p.matcher(line);
				if(!m.find())
				this.lineAmount ++ ;
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * @return the methodAmount
	 */
	public int getMethodAmount() {
		return methodAmount;
	}
	
	/**
	 * Cuenta los m�todos o funciones, seg�n las reglas proporcionadas en el archivo de propiedades
	 * @param methodAmount the methodAmount to set
	 * @throws IOException 
	 */
	public void setMethodAmount(File file, LinkedList<Expression> standardRules) {
		try {
		FileInputStream fis = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		
			String line = reader.readLine();
			
			while(line !=null)
			{
				String methodStartRules = standardRules.get(0).getRule();
				String methodEndRules = standardRules.get(1).getRule();
				String notMethodRules = standardRules.get(3).getRule();
				
				Pattern p1 = Pattern.compile(methodStartRules);
				Matcher m1 = p1.matcher(line);
				Pattern p2 = Pattern.compile(methodEndRules);
				Matcher m2 = p2.matcher(line);
				Pattern p3 = Pattern.compile(notMethodRules);
				Matcher m3 = p3.matcher(line);
				
			    //String matchResult = m2.find()+" "+m1.find()+" " + m3.find();
					if(m1.find()&&m2.find()&&!m3.find())
					{
						this.methodAmount++;
					}
				
				line = reader.readLine();
			}
			
			System.out.println("La cantidad de M�todos en este archivo es:");
			System.out.println(methodAmount);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	

}
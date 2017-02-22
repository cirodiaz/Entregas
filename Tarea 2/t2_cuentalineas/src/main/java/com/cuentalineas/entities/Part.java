package com.cuentalineas.entities;

/**
 * @author Ciro Díaz
 * Programa contador de líneas
 * Versión: 1.0
 * Creado: 18/02/2017
 * Última modificación: 21/02/2017
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
   para aplicar estándares de conteo de líneas
 */
public class Part {
	

	private String partName;
	private int lineAmount;
	private int methodAmount;
	private LinkedList<String> stringTest = new LinkedList<String>(); //Cadena para probar que el estándar no está contando declaraciones de objetos como métodos
	
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
	 * Método que establece la cantidad de líneas que tiene un archivo dado, según las reglas que se le alimenten para el conteo.
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
				//esto es un comentario de prueba, no se debería contar
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
	 * Cuenta los métodos o funciones, según las reglas proporcionadas en el archivo de propiedades
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
			
			System.out.println("La cantidad de Métodos en este archivo es:");
			System.out.println(methodAmount);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	

}
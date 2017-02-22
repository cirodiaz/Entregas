package com.cuentalineas.entities;
/**
 * @author Ciro Díaz
 * Programa contador de líneas
 * Versión: 1.0
 * Creado: 18/02/2017
 * Última modificación: 21/02/2017
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Properties;

public class CodingStandard {
	
	/*Clase que guardará los estándares de codificación contra los que se comparará el archivo; los guardará en objetos tipo Expression
	  y los leerá desde un archivo
	  */
	
	public CodingStandard(String fileName) throws FileNotFoundException{
		
		try{
			LinkedList<Expression> standardExList = setStandards (fileName);	
		} catch (FileNotFoundException fne){
			throw new FileNotFoundException("El archivo de estándares '" + fileName + "' no se encuentra en la ruta esperada");
		}
		
		
	}
	
	String standardsFileLocation;
	
	/*******
	 * Llenará las expresiones del estándar de programación desde un archivo de propiedades; las propiedades tendrán las siguientes categorías:
	 * iniciometodo= {  
	 * finmetodo= }
	 * nocontable= &crlf|/|/*|
	 * @param fileName
	 */
	public LinkedList<Expression> setStandards (String fileName) throws FileNotFoundException{
		
		FileInputStream fileStream = new FileInputStream(fileName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileStream));
		Properties prop = new Properties();
		LinkedList<Expression> expressionList = new LinkedList<Expression>();
		LinkedList<Expression> expressions = new LinkedList<Expression>();
		Expression methodStart = new Expression();
		Expression methodEnd= new Expression();
		Expression notAccountable= new Expression();
		Expression notMethod= new Expression();
		
		try {
			
				prop.load(fileStream);
				/*las propiedades se recuperan en el orden que vienen, deben venir siempre las mismas.
				 * 
				 */
				methodStart.setRuleType("iniciometodo");
				methodStart.setRule(prop.getProperty("iniciometodo"));
				expressionList.add(0,methodStart);
				methodEnd.setRuleType("finmetodo");
				methodEnd.setRule(prop.getProperty("finmetodo"));
				expressionList.add(1,methodEnd);
				notAccountable.setRuleType("nocontable");
				notAccountable.setRule(prop.getProperty("nocontable"));
				expressionList.add(2,notAccountable);
				notMethod.setRuleType("noMetodo");
				notMethod.setRule(prop.getProperty("noMetodo"));
				expressionList.add(3,notMethod);
				
				
		
		} catch (Exception e) {
			// si falla la carga del archivo, se vuelca la excepción a consola
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return expressionList;
		
	}
}

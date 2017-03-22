package com.estadisticas.entities;




/**
 * @author Ciro Diaz
 * Programa calculador de regresion lineal, correlacion y estimacion mejorada para PSP2 
 * Versiin: 1.1 (web)
 * Creado: 20/03/2017
 * Ultima modificaciin: 20/03/2017
 */

import java.util.LinkedList;

import com.sun.javafx.collections.MappingChange.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import java.util.HashMap;
public class Calculator {
	
	public static void main(String args[]){
		
		//NO se requiere archivo de entrada, pues al crear un elemento tipo ValuesArray, se precarga una lista de valores para usar
		//final String DEFAULT_FILENAME = "C:\\tarea3\\archivoin.txt";
		
		
		port(Integer.valueOf(System.getenv("PORT")));
	    staticFileLocation("/public");

	    get("/testnull", (req, res) -> {

	          return "E=mc^2: 12 GeV = " ;
	        });
	    //Metodo para generar datos de prueba 1
	    get("/test1", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			ValuesArray valArray = new ValuesArray(1);
			LinkedList<Value> valuesToCalc = valArray.valArray;
			LinkedList<Value> ranges = valArray.setRanges(valuesToCalc);
			LinkedList<String> valuesToPrint = new LinkedList<String>();
			for(int i= 0;i<ranges.size();i++){
				valuesToPrint.add("Etiqueta: "+ ranges.get(i).getLabel()+"; valor: "+ ranges.get(i).getValue());
			}
			attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
	    //Metodo para generar datos de prueba 2
	    get("/test2", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			ValuesArray valArray = new ValuesArray(2);
			LinkedList<Value> valuesToCalc = valArray.valArray;
			LinkedList<Value> ranges = valArray.setRanges(valuesToCalc);
			LinkedList<String> valuesToPrint = new LinkedList<String>();
			for(int i= 0;i<ranges.size();i++){
				valuesToPrint.add("Etiqueta: "+ ranges.get(i).getLabel()+"; valor: "+ ranges.get(i).getValue());
			}
			attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
//		System.out.println("Los valores base para los cilculos de rangos son: \n");
//		for(int i=0;i<valuesToCalc.size();i++){
//			System.out.println("Etiqueta: "+i+" "+valuesToCalc.get(i).getLabel()+"; " + "valor: "+i+" "+valuesToCalc.get(i).getValue()+"\n");
//			
//		}
//		
//		System.out.println("Los valores base para los cilculos de rangos son: \n");
//		for(int i=0;i<rangeValues.size();i++){
//			System.out.println("Tamano: "+i+" "+rangeValues.get(i).getLabel()+"; " + "valor: "+i+" "+rangeValues.get(i).getValue()+"\n");
//			
//		}		
		
		
			
		
		
	}



}

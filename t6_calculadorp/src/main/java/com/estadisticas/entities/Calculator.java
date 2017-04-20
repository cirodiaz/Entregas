package com.estadisticas.entities;




/**
 * @author Ciro Diaz
 * Programa calculador de integrales por metodo de simpson, con extension para hallar el valor de x para una p esperada
 * Versiin: 1.0 (web)
 * Creado: 19/04/2017
 * Ultima modificaciin: N/A
 */

import java.util.LinkedList;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import java.util.HashMap;
public class Calculator {
	
	public static void main(String args[]){
		
		//Para este programa, solo se hara la impresion para los valores de prueba determinados en el ejercicio
		
		//XValuesCalculator calc = new XValuesCalculator(); //Solo para pruebas en consola
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

	    
	    //Metodo para generar datos de las pruebas
	    get("/test1", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			XValuesCalculator calc = new XValuesCalculator();

			LinkedList<String> valuesToPrint = new LinkedList<String>();
			//se insertan los valores para mostrarlos en la pagina de pruebas
				valuesToPrint.add("Prueba 1: grados de libertad = 6, p = 0.20 esperado = 0.55338, Resultado: x= "+ calc.computeXValueForP(0.20, 6));
				valuesToPrint.add("Prueba 2: grados de libertad = 15, p = 0.45 esperado = 1.75305, Resultado: x= "+ calc.computeXValueForP(0.45, 15));
				valuesToPrint.add("Prueba 3: grados de libertad = 4, p = 0.495 esperado = 4.60409, Resultado: x= "+ calc.computeXValueForP(0.495, 4));
			attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
	    
			//System.out.println("Prueba 1: grados de libertad = 6, p = 0.20 esperado = 0.55338, Resultado: x= "+ calc.computeXValueForP(0.20, 6));
			//System.out.println("Prueba 2: grados de libertad = 15, p = 0.45 esperado = 1.75305, Resultado: x= "+ calc.computeXValueForP(0.45, 15));
			//System.out.println("Prueba 3: grados de libertad = 4, p = 0.495 esperado = 4.60409, Resultado: x= "+ calc.computeXValueForP(0.495, 4));
			
		
		
	}



}

package com.estadisticas.entities;




/**
 * @author Ciro Diaz
 * Programa calculador de calculador de integrales por metodo de simpson
 * Versiin: 1.0 (web)
 * Creado: 04/04/2017
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
		
		//SimpsonsRuleIntegrator simpsonsIntegrator = new SimpsonsRuleIntegrator(0.00001); //Solo para pruebas en consola
		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

	    
	    //Metodo para generar datos de las pruebas
	    get("/test1", (req, res) -> {
			
			java.util.Map<String, Object> attributes = new HashMap<String,Object>();
			SimpsonsRuleIntegrator simpsonsIntegrator = new SimpsonsRuleIntegrator(0.00001);

			LinkedList<String> valuesToPrint = new LinkedList<String>();
			//se insertan los valores para mostrarlos en la pagina de pruebas
				valuesToPrint.add("Prueba 1: x= 1.1, grados de libertad = 9, segmentos iniciales = 10. Resultado: p = "+ simpsonsIntegrator.computeFullSimpsons(1.1, 9, 10));
				valuesToPrint.add("Prueba 2: x= 1.1812, grados de libertad = 10, segmentos iniciales = 10. Resultado: p = "+ simpsonsIntegrator.computeFullSimpsons(1.1812, 10, 10));
				valuesToPrint.add("Prueba 3: x= 2.750, grados de libertad = 30, segmentos iniciales = 10. Resultado: p = "+ simpsonsIntegrator.computeFullSimpsons(2.750, 30, 10));

			attributes.put("results", valuesToPrint);
			return new ModelAndView(attributes, "calculation.ftl");
		}, new FreeMarkerEngine());
	    
			//System.out.println("Prueba 3: x= 2.750, grados de libertad = 30, segmentos iniciales = 10. Resultado: p = "+ simpsonsIntegrator.computeFullSimpsons(2.750, 30, 10));

		
		
			
		
		
	}



}

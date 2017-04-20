/**
 * 
 */
package com.estadisticas.entities;

/**
 * @author Ciro Diaz
 * Programa calculador de integrales por metodo de simpson
 * Versiin: 1.1 (web)
 * Creado: 04/04/2017
 * Ultima modificaciin: N/A
 */

public interface Function {
	
	
	/**
	 * Metodo generico para indicar las entradas y salidas de una funcion, entendida como una funcion de una sola variable.
	 * @param x El valor independiente
	 * @return fx El valor dependiente
	 */
	
	public double computeFunction(double x);

}

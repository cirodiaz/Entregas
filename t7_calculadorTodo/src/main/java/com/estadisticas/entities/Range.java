package com.estadisticas.entities;

/**
 * @author Ciro Díaz
 * Programa calculador de rangos de valores para PSP2 
 * Versión: 1.0
 * Creado: 20/03/2017
 * Última modificación: N/A
 */

public enum Range {

	//Se definen las etiquetas para cada rango de valores, de manera que se puedan mostrar de forma consistente.
	VERY_SMALL("VS"),SMALL("S"),MEDIUM("M"),LARGE("L"),VERY_LARGE("VL");
	private String size;
	
	private Range(String size){
		this.size = size;
	}
	@Override
	public String toString(){
		return this.size;
	}
}

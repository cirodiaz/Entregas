package com.estadisticas.entities;

/**
 * @author Ciro D�az
 * Programa calculador de regresion lineal, correlacion y estimacion mejorada para PSP2 
 * Versi�n: 1.0
 * Creado: 06/03/2017
 * �ltima modificaci�n: N/A
 */

public class Value {
	

	
	/**
	 * Constructor; cada vez que se instancie un objeto tipo value, se tiene que inicalizar
	 * @param xValue
	 * @param yValue
	 */
	
	public Value(float xValue, float yValue) {
		super();
		this.xValue = xValue;
		this.yValue = yValue;
	}

	private float xValue;
	private float yValue;
	
	/**
	 * @return  xValue
	 */
	
	public float getxValue() {
		return xValue;
	}
	
	/**
	 * @param xValue  xValue a establecer
	 */
	public void setxValue(float xValue) {
		this.xValue = xValue;
	}
	
	/**
	 * @return  yValue
	 */
	public float getyValue() {
		return yValue;
	}
	
	/**
	 * @param yValue  yValue a establecer
	 */
	public void setyValue(float yValue) {
		this.yValue = yValue;
	}
}


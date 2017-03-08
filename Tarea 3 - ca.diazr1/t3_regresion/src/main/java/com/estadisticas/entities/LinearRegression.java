package com.estadisticas.entities;
/**
 * @author Ciro D�az
 * Programa calculador de regresion lineal para PSP2 
 * Versi�n: 1.0
 * Creado: 06/03/2017
 * �ltima modificaci�n: N/A
 */

public class LinearRegression {

	//beta0 es el corte con el eje y cuando x=0 para la ecuaci�n lineal; beta1 es la pendiente de la regresi�n.
	private double beta0;
	private double beta1;

	/**
	 * Constructor; al instanciar una Regresi�n, se le deben asignar valores.
	 * @param beta0
	 * @param beta1
	 */
	public LinearRegression(double beta0, double beta1) {
		super();
		this.beta0 = beta0;
		this.beta1 = beta1;
	}

	/**
	 * @return  beta0
	 */
	public double getBeta0() {
		return beta0;
	}
	
	/**
	 * @param d  beta0 a ingresar
	 */
	public void setBeta0(double d) {
		this.beta0 = d;
	}
	
	/**
	 * @return beta1
	 */
	public double getBeta1() {
		return beta1;
	}
	
	/**
	 * @param d beta1 a ingresar
	 */
	public void setBeta1(double d) {
		this.beta1 = d;
	}
	
}

package com.estadisticas.entities;


/**
 * @author Ciro Diaz
 * Programa calculador de integrales por metodo de simpson, con extension para hallar el valor de x para una p esperada
 * Versiin: 1.0 (web)
 * Creado: 19/04/2017
 * Ultima modificaciin: N/A
 */


public class XValuesCalculator {
	
	//valores de control para los parametros del algoritmo de convergencia
	final double INITIAL_X_VALUE =1;
	final double D_VALUE = 0.5;
	final double ERROR_MARGIN = 0.0000000001;
	private SimpsonsRuleIntegrator simpsonsIntegrator = new SimpsonsRuleIntegrator(ERROR_MARGIN);
	
	/**
	 * metodo para calcular donde converge x para la funcion t, con un valor p esperado
	 * @param p valor objetivo
	 * @param dof grados de libertad propios de la funcion t
	 * 
	 */
	public double computeXValueForP(double p, int dof){
		double x = INITIAL_X_VALUE;
		double difference;
		double lastDifference = 0.1;
		double result = 0;
		double d= D_VALUE;
		
		do 
		{
			
			result = simpsonsIntegrator.computeFullSimpsons(x, dof, 10);
			difference = result-p;
			if (difference < 0){
				if(lastDifference<0){
					x +=d;	
				} else {
					d=d/2;
					x+=d;
				}
				
			}
			else if(difference > 0){
				if(lastDifference>0){
				x -=d;
				} else {
					d=d/2;
					x-=d;
				}
			}
			lastDifference = difference;
		}
		while (Math.abs(difference) > ERROR_MARGIN); 
		return x;
	}

}

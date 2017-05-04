package com.estadisticas.entities;

/**
 * @author Ciro Diaz
 * Programa calculador de integrales por metodo de simpson
 * Versiin: 1.1 (web)
 * Creado: 04/04/2017
 * Ultima modificaciin: N/A
 */

import org.apache.commons.math3.special.Gamma;

public class SimpsonsRuleIntegrator implements Function {

	//miembros de la clase, siempre se deben inicializar para poder hacer un calculo
	private double errorMargin;
	
	/**
	 * Inicializa el objeto con un margen de error determinado; este margen de error no se podra cambiar sin crear un nuevo objeto 
	 * @param errorMargin
	 */
	public SimpsonsRuleIntegrator(double errorMargin){
		this.errorMargin = errorMargin;
	}
	
	/**
	 * Computa una iteracion de la integral de simpsons
	 * @param x el valor de x con el cual queremos hacer el calculo del integral para el intervalo
	 * @param dof grados de libertad; este calculo esta atado a la funcion t para estadistica
	 * @param segments - cantidad de segmentos de la iteracion
	 * @return simpsons el valor de la iteracion
	 */
	private double computeIntegral(double x, double dof, int segments){
		double w = x/segments;
		double evenTotal =0;
		double oddTotal=0;
		//valores para los sum(1 a n-1) de 4(iW)
		for(int i = 1; i < segments;i+=2){
			oddTotal+=w*4*computeTFunction(w*i, dof)/3;
			//System.out.println(oddTotal);
		}
		//valores para los sum(2 a n-2) de2(iW)
		for(int i = 2; i < segments-1;i+=2){
			evenTotal+=w*2*computeTFunction(w*i, dof)/3;
			//System.out.println(evenTotal);
		}
		
		//double fzero=(w/3)*computeTFunction(0, dof);
		//double fx = (w/3)*(computeTFunction(0, dof)+computeTFunction(x, dof));
		//System.out.println(fzero + " " + fx);
		//devuelve la funcion como w/3(f(0) + sum(1 a n-1) de 4(iW) + sum(2 a n-2) de2(iW) + f(x))
		double simpsons = (w/3)*(computeTFunction(0, dof)+computeTFunction(x, dof)) + evenTotal + oddTotal;
		
		
		return simpsons;
	}
	
	/* (non-Javadoc)
	 * implementacion de la funcion gamma
	 * @see com.estadisticas.entities.Function#computeFunction(double)
	 */
	public double computeFunction(double x){
		return Gamma.gamma(x);
			
		}
	/**
	 * Implementacion de la funcion t para distribuciones estadisticas
	 * @param x valor para el cual se quiere calcular la funcion
	 * @param dof grados de libertad de la funcion t
	 * @return el calculo total de la funcion t
	 */
	private double computeTFunction(double x, double dof){
		double part1 = computeFunction(((dof+1)/2));
		double part2 = (Math.pow((dof*Math.PI),0.5))*computeFunction(dof/2);
		double part3 = Math.pow((1+(Math.pow(x, 2)/dof)),(-(dof+1)/2));
		double result = (part1/part2)*part3;
		return result;
			
		}
	
	
	/**
	 * Calculo del valor de la integral por metodo de simpsons con margen de error
	 * @param x valor maximo de intervalo para el cual se va a calcular el area 
	 * @param dof grados de libertad de la funcion t
	 * @param segments cantidad de segmentos que se utilizaran como base para las iteraciones
	 * @return simpsons2 ultimo valor cuando el error sea menor al errorMargin con el que se creo el objeto
	 */
	public double computeFullSimpsons(double x, double dof, int segments){
		double totalError = 1;
		double simpsons = computeIntegral(x,dof,segments);
		segments = segments*2;
		double simpsons2 = computeIntegral(x,dof,segments);
		totalError = simpsons2-simpsons;
		while(totalError > errorMargin) {
			simpsons = computeIntegral(x,dof,segments);
			segments = segments*2;
			simpsons2 = computeIntegral(x,dof,segments);
			totalError = simpsons2-simpsons;
			
		}
		return simpsons2;
		
	}
			
	}


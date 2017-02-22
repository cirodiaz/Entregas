package com.cuentalineas.entities;

/**
 * @author Ciro D�az
 * Programa contador de l�neas
 * Versi�n: 1.0
 * Creado: 18/02/2017
 * �ltima modificaci�n: 21/02/2017
 */
public class Expression {
	/**
	 * Clase que representa las expresiones regulares. 
	 */
	private String rule;
	private String ruleType;

	/**
	 * @return the ruleType
	 */
	public String getRuleType() {
		return ruleType;
	}

	/**
	 * @param ruleType the ruleType to set
	 */
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	/**
	 * @return the rule
	 */
	public String getRule() {
		return rule;
	}

	/**
	 * @param rule the rule to set
	 */
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	

} 

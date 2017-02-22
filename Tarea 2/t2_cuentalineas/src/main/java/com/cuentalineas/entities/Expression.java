package com.cuentalineas.entities;

/**
 * @author Ciro Díaz
 * Programa contador de líneas
 * Versión: 1.0
 * Creado: 18/02/2017
 * Última modificación: 21/02/2017
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

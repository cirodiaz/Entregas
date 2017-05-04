package com.estadisticas.entities;

/**
 * @author Ciro D�az
 * Programa calculador de rangos de valores para PSP2 
 * Versi�n: 1.0
 * Creado: 20/03/2017
 * �ltima modificaci�n: N/A
 */

public class ValueLabel {
	

	
	/**
	 * Constructor; cada vez que se instancie un objeto tipo value, se tiene que inicalizar
	 * @param label
	 * @param value
	 */
	
	public ValueLabel(String label, float value) {
		super();
		this.label = label;
		this.value = value;
	}

	private String label;
	private float value;
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	
	
	
}


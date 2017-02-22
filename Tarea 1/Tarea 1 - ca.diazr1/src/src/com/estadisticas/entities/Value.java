package com.estadisticas.entities;

public class Value {
	
	public Value (float val) {
		value = val;
	}
	
	private float value;

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
	
	/**
	 * @return the value
	 */
	public float getNextValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setNextValue(float value) {
		this.value = value;
	}
	/**
	 * @return the value
	 */
	public float getLastValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setLastValue(float value) {
		this.value = value;
	}
	

}

package edu.tongji.anliantest.utils;

import java.math.BigDecimal;

public class ValueAndScale {
	private BigDecimal value;
	private Integer scale;

	public ValueAndScale() {
	}

	public ValueAndScale(BigDecimal value, Integer scale) {
		this.value = value;
		this.setScale(scale);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	@Override
	public String toString() {
		if (value == null || scale == null)
			return null;
		return value.setScale(scale).toString();
	}
	
	public String toTypeString(String type) {
		if (value == null || scale == null)
			return null;
		return type + value.setScale(scale).toString();
	}
}

package com.gojek.entity;

import java.util.Map;

public class Parkinglot {

	private Map<Integer, Vehicle> parkinglot;

	public Map<Integer, Vehicle> getParkinglot() {
		return parkinglot;
	}

	public void setParkinglot(Map<Integer, Vehicle> parkinglot) {
		this.parkinglot = parkinglot;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parkinglot == null) ? 0 : parkinglot.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parkinglot other = (Parkinglot) obj;
		if (parkinglot == null) {
			if (other.parkinglot != null)
				return false;
		} else if (!parkinglot.equals(other.parkinglot))
			return false;
		return true;
	}

}

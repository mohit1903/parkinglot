package com.gojek.entity;

public class Vehicle {

	private int SlotNo;
	private String RegistrationNumber;
	private String Colour;

	public int getSlotNo() {
		return SlotNo;
	}

	public void setSlotNo(int slotNo) {
		SlotNo = slotNo;
	}

	public String getRegistrationNumber() {
		return RegistrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		RegistrationNumber = registrationNumber;
	}

	public String getColour() {
		return Colour;
	}

	public void setColour(String colour) {
		Colour = colour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Colour == null) ? 0 : Colour.hashCode());
		result = prime * result + ((RegistrationNumber == null) ? 0 : RegistrationNumber.hashCode());
		result = prime * result + SlotNo;
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
		Vehicle other = (Vehicle) obj;
		if (Colour == null) {
			if (other.Colour != null)
				return false;
		} else if (!Colour.equals(other.Colour))
			return false;
		if (RegistrationNumber == null) {
			if (other.RegistrationNumber != null)
				return false;
		} else if (!RegistrationNumber.equals(other.RegistrationNumber))
			return false;
		if (SlotNo != other.SlotNo)
			return false;
		return true;
	}

}

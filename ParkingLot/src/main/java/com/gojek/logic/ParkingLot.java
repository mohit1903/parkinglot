package com.gojek.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gojek.entity.Car;

public class ParkingLot {

	private int noOfParkingSlots = 0;

	private List<Integer> availableSlotList;

	private Map<Integer, Car> slotCarMap;

	private Map<String, Integer> regNoCarSlotMap;

	private Map<String, List<String>> colorCarMap;

	private static ParkingLot parkingLotProcessor = null;

	// Making the class singleton
	private ParkingLot(int noOfParkingSlots) {
		this.noOfParkingSlots = noOfParkingSlots;
		availableSlotList = new ArrayList<Integer>();

		for (int i = 1; i <= noOfParkingSlots; i++) {
			availableSlotList.add(i);
		}

		slotCarMap = new HashMap<Integer, Car>();
		regNoCarSlotMap = new HashMap<String, Integer>();
		colorCarMap = new HashMap<String, List<String>>();
		System.out.println("Created parking lot with " + noOfParkingSlots + " slots");
		System.out.println();
	}

	public static ParkingLot createParkingLot(int noOfParkingSlots) {
		if (parkingLotProcessor != null) {
			return parkingLotProcessor;
		} else {
			parkingLotProcessor = new ParkingLot(noOfParkingSlots);
			return parkingLotProcessor;
		}

	}

	public void parkCar(Car car) {
		if (noOfParkingSlots == 0) {
			System.out.println("Sorry, parking lot is not created\n");
			return;
		} else if (slotCarMap.size() == noOfParkingSlots) {
			System.out.println("Sorry, parking lot is full\n");
			return;
		} else {
			Collections.sort(availableSlotList);
			int slot = availableSlotList.get(0);
			slotCarMap.put(slot, car);
			regNoCarSlotMap.put(car.getRegNo(), slot);
			if (colorCarMap.containsKey(car.getColor())) {
				List<String> regNoList = colorCarMap.get(car.getColor());
				colorCarMap.remove(car.getColor());
				regNoList.add(car.getRegNo());
				colorCarMap.put(car.getColor(), regNoList);
			} else {
				// LinkedList because frequent updation is required
				LinkedList<String> regNoList = new LinkedList<String>();
				regNoList.add(car.getRegNo());
				colorCarMap.put(car.getColor(), regNoList);
			}
			System.out.println("Allocated slot number: " + slot + "\n");
			availableSlotList.remove(0);
		}
	}

}

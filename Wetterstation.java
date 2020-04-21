package javaUebungenAusDemNetz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Wetterstation {

	public static void main(String[] args) {

		HashMap<Integer, Integer> temperatureValues = new HashMap<Integer, Integer>();

		temperatureValues.put(1, 12);
		temperatureValues.put(2, 14);
		temperatureValues.put(3, 9);
		temperatureValues.put(4, 12);
		temperatureValues.put(5, 15);
		temperatureValues.put(6, 16);
		temperatureValues.put(7, 15);
		temperatureValues.put(8, 15);
		temperatureValues.put(9, 11);
		temperatureValues.put(10, 8);
		temperatureValues.put(11, 13);
		temperatureValues.put(12, 13);
		temperatureValues.put(13, 15);
		temperatureValues.put(14, 12);

		System.out.println(midTemperature(temperatureValues));
		System.out.println(minAndMaxValues(temperatureValues));
		System.out.println(temperatureDifference(temperatureValues));
		System.out.println(temperatureValues);
	}

	public static int midTemperature(HashMap<Integer, Integer> values) {
		int valueCount = 0;
		for (int i = 1; i <= values.size(); i++) {
			valueCount += values.get(i);
		}

		return valueCount / values.size();
	}

	public static String minAndMaxValues(HashMap<Integer, Integer> values) {
		int min = Collections.min(values.values());
		int max = Collections.max(values.values());
		return "Die Höchsttemperatur beträgt " + max + " Grad Celsius und die niedrigste Temperatur beträgt " + min
				+ " Grad Celsius";
	}

	public static ArrayList<Integer> temperatureDifference(HashMap<Integer, Integer> values) {
		ArrayList<Integer> days = new ArrayList<Integer>();
		int tempDiffer = 0;
		int compareValue = 0;
		int finalValue = 0;
		for (int i = 1; i <= values.size(); i++) {
			if (i + 1 == 15) {
				break;
			}
			if (compareValue < tempDiffer) {
				compareValue = tempDiffer;
			}
			tempDiffer = Math.abs(values.get(i) - values.get(i + 1));

			if (tempDiffer > compareValue) {
				finalValue = tempDiffer;
			}
		}
		for (int i = 1; i <= values.size(); i++) {
			if (i + 1 == 15) {
				break;
			}
			int k = Math.abs(values.get(i) - values.get(i + 1));

			if (k == finalValue) {
				days.add((Integer) values.keySet().toArray()[i - 1]);
				days.add((Integer) values.keySet().toArray()[i]);
			}
		}
		return days;
	}
}

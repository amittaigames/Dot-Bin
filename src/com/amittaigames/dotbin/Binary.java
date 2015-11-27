package com.amittaigames.dotbin;

public class Binary {

	public static String decToBin(int dec) {
		StringBuilder sb = new StringBuilder();
		if (dec != 0) {
			while (dec > 0) {
				if (dec % 2 == 0) {
					sb.insert(0, "0");
				} else {
					sb.insert(0, "1");
				}
				dec /= 2;
			}
		} else {
			sb.insert(0, "0");
		}
		return sb.toString();
	}
	
}
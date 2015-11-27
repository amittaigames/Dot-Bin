package com.amittaigames.dotbin;

public class Binary {

	public static String decToBin(int dec) {
		StringBuilder sb = new StringBuilder();
		while (dec > 0) {
			if (dec % 2 == 0) {
				sb.insert(0, "0");
			} else {
				sb.insert(0, "1");
			}
			dec /= 2;
		}
		return sb.toString();
	}
	
}
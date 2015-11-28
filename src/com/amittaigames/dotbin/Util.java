package com.amittaigames.dotbin;

public class Util {

	public static String cat(String[] arr, int start, String cat) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = start; i < arr.length; i++) {
	        sb.append(arr[i]);
	        if (i != arr.length - 1) {
	            sb.append(cat);
	        }   
	    }
	    return sb.toString();
	}
	
}
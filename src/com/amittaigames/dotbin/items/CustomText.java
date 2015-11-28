package com.amittaigames.dotbin.items;

import java.util.ArrayList;
import java.util.List;

public class CustomText {

	private String text;
	private int x;
	private int y;
	
	public static List<CustomText> list = new ArrayList<CustomText>();
	
	public CustomText(String text, int x, int y) {
		this.text = text;
		this.x = x;
		this.y = y;
		list.add(this);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
package com.amittaigames.dotbin.items;

import java.util.ArrayList;
import java.util.List;

import com.amittaigames.ludumgl.graphics.Rect;

public abstract class Item {

	private Rect rect;
	
	public static List<Item> list = new ArrayList<Item>();
	
	public Item(Rect rect) {
		this.rect = rect;
	}
	
	public abstract void onCollision();
	
	public Rect getRect() {
		return this.rect;
	}
	
}
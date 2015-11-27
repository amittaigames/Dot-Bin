package com.amittaigames.dotbin.items;

import java.util.ArrayList;
import java.util.List;

import com.amittaigames.ludumgl.graphics.Rect;

public abstract class Item {

	private Rect rect;
	private boolean interacted = false;
	
	public static List<Item> list = new ArrayList<Item>();
	
	public Item(Rect rect) {
		this.rect = rect;
	}
	
	public abstract void onCollision(float x, float y);
	public abstract void onNoCollision();
	public abstract void onInteraction(float x, float y);
	
	public Rect getRect() {
		return this.rect;
	}
	
	public void setInteracted(boolean v) {
		this.interacted = v;
	}
	
	public boolean getInteracted() {
		return interacted;
	}
	
}
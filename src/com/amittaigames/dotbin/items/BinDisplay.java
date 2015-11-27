package com.amittaigames.dotbin.items;

import com.amittaigames.dotbin.Binary;
import com.amittaigames.dotbin.Message;
import com.amittaigames.ludumgl.graphics.Rect;

public class BinDisplay extends Item {

	private Rect rect;
	private int dec;
	private String bin;
	
	public BinDisplay(Rect rect, int dec) {
		super(rect);
		this.rect = rect;
		this.dec = dec;
		this.bin = Binary.decToBin(dec);
		Item.list.add(this);
	}
	
	@Override
	public void onCollision(float x, float y) {
		Message.text = "Binary: " + bin;
		Message.shown = true;
	}
	
	@Override
	public void onNoCollision() {
		Message.shown = false;
	}
	
	@Override
	public void onInteraction(float x, float y) {
		
	}
	
	public void setNumbers(int dec) {
		this.dec = dec;
		this.bin = Binary.decToBin(dec);
	}
	
	public Rect getRect() {
		return rect;
	}

	public int getDec() {
		return dec;
	}

	public String getBin() {
		return bin;
	}
	
}
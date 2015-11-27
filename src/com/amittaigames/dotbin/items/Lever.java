package com.amittaigames.dotbin.items;

import com.amittaigames.ludumgl.graphics.Rect;

public class Lever extends Item {

	private Rect rect;
	private int dec;
	private boolean on;
	
	public Lever(Rect rect, int dec) {
		super(rect);
		this.rect = rect;
		this.dec = dec;
		this.on = false;
		Item.list.add(this);
	}

	@Override
	public void onCollision() {
		
	}

	@Override
	public void onNoCollision() {
		
	}

	@Override
	public void onInteraction() {
		BinDisplay display = null;
		for (Item i : Item.list) {
			if (i instanceof BinDisplay) {
				display = (BinDisplay) i;
				break;
			}
		}
		if (on) {
			display.setNumbers(display.getDec() - dec);
			on = false;
		} else {
			display.setNumbers(display.getDec() + dec);
			on = true;
		}
	}
	
	public boolean isOn() {
		return on;
	}
	
	public Rect getRect() {
		return rect;
	}
	
	public int getDecimal() {
		return dec;
	}

}
package com.amittaigames.dotbin.items;

import com.amittaigames.dotbin.LevelHandler;
import com.amittaigames.ludumgl.graphics.Rect;

public class Finish extends Item {

	private Rect rect;
	
	public Finish(Rect rect) {
		super(rect);
		this.rect = rect;
		Item.list.add(this);
	}
	
	@Override
	public void onCollision(float x, float y) {
		LevelHandler.LEVEL++;
		LevelHandler.loadLevel(LevelHandler.LEVEL);
	}

	@Override
	public void onNoCollision() {
		
	}

	@Override
	public void onInteraction(float x, float y) {
		
	}
	
	public Rect getRect() {
		return rect;
	}
	
}
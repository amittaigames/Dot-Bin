package com.amittaigames.dotbin.items;

import com.amittaigames.dotbin.Player;
import com.amittaigames.ludumgl.graphics.Rect;

public class Wall extends Item {

	private Rect rect;
	
	public Wall(Rect rect) {
		super(rect);
		this.rect = rect;
		Item.list.add(this);
	}
	
	@Override
	public void onCollision(float x, float y) {
		Player p = Player.list.get(Player.selected);
		if (x + p.getRect().getWidth() >= rect.getX() && x + p.getRect().getWidth() <= rect.getX() + Player.speed) {
			p.getRect().setX(rect.getX() - p.getRect().getWidth());
		}
		if (y + p.getRect().getHeight() >= rect.getY() && y + p.getRect().getHeight() <= rect.getY() + Player.speed) {
			p.getRect().setY(rect.getY() - p.getRect().getHeight());
		}
		if (x <= rect.getX() + rect.getWidth() && x >= rect.getX() + rect.getWidth() - Player.speed) {
			p.getRect().setX(rect.getX() + rect.getWidth());
		}
		if (y <= rect.getY() + rect.getHeight() && y >= rect.getY() + rect.getHeight() - Player.speed) {
			p.getRect().setY(rect.getY() + rect.getHeight());
		}
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
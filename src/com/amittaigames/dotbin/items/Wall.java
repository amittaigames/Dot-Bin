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
		if (x >= rect.getX()) {
			p.getRect().translate(Player.speed, 0);
		}
		if (x <= rect.getX()) {
			p.getRect().translate(-Player.speed, 0);
		}
		if (y >= rect.getY()) {
			p.getRect().translate(0, Player.speed);
		}
		if (y <= rect.getY()) {
			p.getRect().translate(0, -Player.speed);
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
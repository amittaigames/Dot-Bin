package com.amittaigames.dotbin.items;

import com.amittaigames.dotbin.Message;
import com.amittaigames.dotbin.Player;
import com.amittaigames.ludumgl.graphics.Rect;

public class Door extends Wall implements NumberListener {

	private Rect rect;
	private int opensOn;
	private boolean open;
	
	public Door(Rect rect, int opensOn) {
		super(rect);
		this.rect = rect;
		this.opensOn = opensOn;
		this.open = false;
	}
	
	@Override
	public void numberChanged(int num) {
		if (num == opensOn) {
			open = true;
		} else {
			open = false;
		}
	}
	
	@Override
	public void onCollision(float x, float y) {
		if (!open) {
			Player p = Player.list.get(Player.selected);
			if (x + p.getRect().getWidth() >= rect.getX() && x + p.getRect().getWidth() <= rect.getX() + Player.speed) {
				p.getRect().setX(rect.getX() - p.getRect().getWidth());
			}
			if (y + p.getRect().getHeight() >= rect.getY()
					&& y + p.getRect().getHeight() <= rect.getY() + Player.speed) {
				p.getRect().setY(rect.getY() - p.getRect().getHeight());
			}
			if (x <= rect.getX() + rect.getWidth() && x >= rect.getX() + rect.getWidth() - Player.speed) {
				p.getRect().setX(rect.getX() + rect.getWidth());
			}
			if (y <= rect.getY() + rect.getHeight() && y >= rect.getY() + rect.getHeight() - Player.speed) {
				p.getRect().setY(rect.getY() + rect.getHeight());
			}
			Message.text = "Opens On: " + opensOn;
			Message.shown = true;
		}
	}
	
	@Override
	public void onNoCollision() {
		
	}
	
	public boolean isOpen() {
		return open;
	}
	
	public Rect getRect() {
		return rect;
	}

}
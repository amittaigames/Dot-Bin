package com.amittaigames.dotbin;

import java.awt.Color;
import java.awt.Font;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.amittaigames.dotbin.items.BinDisplay;
import com.amittaigames.dotbin.items.Item;
import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Render;

public class Game extends CoreGame {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	public static final String VERSION = "0.1";
	public static Game inst;
	
	@Override
	public void init() {
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		FontHandler.registerFont(new Font("Arial", Font.PLAIN, 16), true);
	}

	@Override
	public void render(Render r) {
		// Background
		r.clear(225, 225, 225);
		
		// Items
		for (Item i : Item.list) {
			Color c = new Color(255, 0, 255); // Pink for missing
			if (i instanceof BinDisplay) {
				c = new Color(125, 125, 125);
			}
			r.setColor(c.getRed(), c.getGreen(), c.getBlue());
			r.fillRect(i.getRect());
		}
		
		// Players
		for (int i = Player.list.size() - 1; i >= 0; i--) {
			Player p = Player.list.get(i);
			r.setColor(p.getColor().getRed(), p.getColor().getGreen(), p.getColor().getBlue());
			r.fillRect(p.getRect());
			if (i == Player.selected) {
				r.setColor(0, 0, 0);
				r.drawRect(p.getRect());
			}
		}
		
		// FPS
		r.setColor(0, 0, 0);
		FontHandler.setFont("Arial 16");
		r.drawText("FPS: " + Window.getCurrentFPS(), 15, 15);
	}

	@Override
	public void update(int delta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
			if (!Player.cycled)
				Player.cycle();
		}
		if (!Keyboard.isKeyDown(Keyboard.KEY_TAB)) {
			Player.cycled = false;
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			Player.list.get(Player.selected).getRect().translate(delta / Player.speed, 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			Player.list.get(Player.selected).getRect().translate(-(delta / Player.speed), 0);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			Player.list.get(Player.selected).getRect().translate(0, delta / Player.speed);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			Player.list.get(Player.selected).getRect().translate(0, -(delta / Player.speed));
		}
		
		for (Item i : Item.list) {
			// Collision
		}
		
		Player p = Player.list.get(Player.selected);
		if (p.getRect().getX() < 0) {
			p.getRect().setX(0);
		}
		if (p.getRect().getY() < 0) {
			p.getRect().setY(0);
		}
		if (p.getRect().getX() + p.getRect().getWidth() > WIDTH) {
			p.getRect().setX(WIDTH - p.getRect().getWidth());
		}
		if (p.getRect().getY() + p.getRect().getHeight() > HEIGHT) {
			p.getRect().setY(HEIGHT - p.getRect().getHeight());
		}
	}
	
}
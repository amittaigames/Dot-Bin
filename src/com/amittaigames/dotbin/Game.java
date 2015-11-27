package com.amittaigames.dotbin;

import java.awt.Font;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Render;

public class Game extends CoreGame {
	
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
	}
	
}
package com.amittaigames.dotbin;

import java.awt.Font;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.FontHandler;
import com.amittaigames.ludumgl.graphics.Render;

public class Game extends CoreGame {
	
	public static final String VERSION = "0.1";
	public static Game inst;
	
	@Override
	public void init() {
		FontHandler.registerFont(new Font("Arial", Font.PLAIN, 16), true);
	}

	@Override
	public void render(Render r) {
		r.clear(225, 225, 225);
		
		r.setColor(0, 0, 0);
		FontHandler.setFont("Arial 16");
		r.drawText("FPS: " + Window.getCurrentFPS(), 15, 15);
	}

	@Override
	public void update(int delta) {
		
	}
	
}
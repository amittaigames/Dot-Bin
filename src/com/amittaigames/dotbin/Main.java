package com.amittaigames.dotbin;

import com.amittaigames.ludumgl.CoreGame;
import com.amittaigames.ludumgl.Window;
import com.amittaigames.ludumgl.graphics.Render;

public class Main extends CoreGame {
	
	public static void main(String[] args) {
		Window.config(1, 1);
		Window.init(".BIN", 800, 600, new Main(), 60);
	}
	
	@Override
	public void init() {
		
	}

	@Override
	public void render(Render r) {
		r.clear(225, 225, 225);
	}

	@Override
	public void update(int delta) {
		
	}
	
}
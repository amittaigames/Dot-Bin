package com.amittaigames.dotbin;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.amittaigames.dotbin.items.BinDisplay;
import com.amittaigames.ludumgl.graphics.Rect;

public class LevelHandler {

	public static void loadLevel(int level) {
		try {
			Player.clearPlayers();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					LevelHandler.class.getResourceAsStream("/levels/" + level + ".txt")));
			
			String line;
			while ((line = br.readLine()) != null) {
				String[] args = line.split(" ");
				if (args[0].equals("player")) {
					Color color = new Color(255, 0, 255); // Pink for error
					if (args[1].equals("Red")) {
						color = new Color(214, 122, 122);
					}
					if (args[1].equals("Blue")) {
						color = new Color(124, 202, 235);
					}
					if (args[1].equals("Green")) {
						color = new Color(124, 217, 162);
					}
					Rect rect = new Rect(Integer.parseInt(args[2]), Integer.parseInt(args[3]), 50, 50);
					new Player(rect, color);
				}
				if (args[0].equals("display")) {
					new BinDisplay(new Rect(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
							Integer.parseInt(args[3]), Integer.parseInt(args[4])), Integer.parseInt(args[5]));
				}
			}
			
			br.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
}
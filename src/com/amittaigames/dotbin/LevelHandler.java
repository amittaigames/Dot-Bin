package com.amittaigames.dotbin;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
					Rect rect = new Rect(Integer.parseInt(args[2]), Integer.parseInt(args[3]), 75, 75);
					new Player(rect, color);
				}
			}
			
			br.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
}
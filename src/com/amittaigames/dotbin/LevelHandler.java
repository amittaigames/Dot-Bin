package com.amittaigames.dotbin;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import com.amittaigames.dotbin.items.BinDisplay;
import com.amittaigames.dotbin.items.CustomText;
import com.amittaigames.dotbin.items.Door;
import com.amittaigames.dotbin.items.Finish;
import com.amittaigames.dotbin.items.Item;
import com.amittaigames.dotbin.items.Lever;
import com.amittaigames.dotbin.items.Wall;
import com.amittaigames.ludumgl.graphics.Rect;

public class LevelHandler {

	public static int LEVEL;
	public static int LEVEL_MAX = 2;
	public static boolean load1 = true;
	public static boolean load2 = true;
	public static boolean loading = false;
	
	public static void loadLevel(int level) {
		if (!load2)
			return;
		
		try {
			loading = true;
			Player.clearPlayers();
			CustomText.list.clear();
			Item.list.clear();
			
			if (level > LEVEL_MAX && load1) {
				load1 = false;
				loadLevel(749);
				return;
			}
			
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
				if (args[0].equals("lever")) {
					new Lever(new Rect(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
							Integer.parseInt(args[3]), Integer.parseInt(args[4])), Integer.parseInt(args[5]));
				}
				if (args[0].equals("wall")) {
					new Wall(new Rect(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
							Integer.parseInt(args[3]), Integer.parseInt(args[4])));
				}
				if (args[0].equals("door")) {
					new Door(new Rect(Integer.parseInt(args[1]), Integer.parseInt(args[2]),
							Integer.parseInt(args[3]), Integer.parseInt(args[4])), Integer.parseInt(args[5]));
				}
				if (args[0].equals("finish")) {
					new Finish(new Rect(Integer.parseInt(args[1]), Integer.parseInt(args[2]), 50, 50));
				}
				if (args[0].equals("text")) {
					new CustomText(Util.cat(args, 3, " "), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
				}
			}
			
			if (!load1)
				load2 = false;
			
			br.close();
			
			loading = false;
		} catch (NullPointerException e) { 
			JOptionPane.showMessageDialog(null, "That level does not exist!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
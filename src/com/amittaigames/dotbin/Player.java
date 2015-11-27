package com.amittaigames.dotbin;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.amittaigames.ludumgl.graphics.Rect;

public class Player {

	private Rect rect;
	private Color color;
	
	public static int selected = 0;
	public static List<Player> list = new ArrayList<Player>();
	public static boolean cycled = false;
	public static float speed = 6.25f;
	
	public Player(Rect rect, Color color) {
		this.rect = rect;
		this.color = color;
		list.add(this);
	}
	
	public static void cycle() {
		if (selected < list.size() - 1) {
			selected++;
		} else {
			selected = 0;
		}
		cycled = true;
	}
	
	public static void clearPlayers() {
		selected = 0;
		list.clear();
	}

	public Rect getRect() {
		return rect;
	}

	public Color getColor() {
		return color;
	}
	
}
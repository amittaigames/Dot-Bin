package com.amittaigames.dotbin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.amittaigames.ludumgl.Window;

public class Main {

	public static void main(String[] args) {
		buildWindow();
	}
	
	private static void buildWindow() {
		final JFrame frame = new JFrame(".BIN Launcher");
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(10, 1));
		
		final JLabel lFPS = new JLabel("FPS:");
		content.add(lFPS);
		
		final JTextField tFPS = new JTextField("30");
		content.add(tFPS);
		
		final JButton bHost = new JButton("Start Game");
		bHost.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Game.inst = new Game();
				Window.config(1, 1);
				Window.init(".BIN - " + Game.VERSION, 800, 600, Game.inst, Integer.parseInt(tFPS.getText()));
			}
		});
		content.add(bHost);
		
		frame.setContentPane(content);
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
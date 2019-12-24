package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;

import util.BasePlayer;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GamePanel extends JFrame {

	ChessboardCanvas game_canvas;
	
	public GamePanel() {

		setTitle("AI五子棋！");
		setBounds(400, 50, 585, 650);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		getContentPane().add(panel, BorderLayout.NORTH);

		JRadioButton choice1 = new JRadioButton("人机对战");
		JRadioButton choice2 = new JRadioButton("单机对战");
		choice1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				choice1.setSelected(true);
				choice2.setSelected(false);
			}
		});
		choice1.setBackground(Color.ORANGE);
		choice1.setSelected(true);
		panel.add(choice1);

		choice2.setBackground(Color.ORANGE);
		choice2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				choice2.setSelected(true);
				choice1.setSelected(false);
			}
		});
		panel.add(choice2);

		JButton startGame = new JButton("开始游戏");
		startGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		startGame.setBackground(Color.GREEN);
		startGame.setForeground(Color.BLACK);
		panel.add(startGame);
		
		game_canvas = new ChessboardCanvas();
		getContentPane().add(game_canvas, BorderLayout.CENTER);
	}
	
	public void setPlayers(BasePlayer basePlayerA,BasePlayer basePlayerB){
		
		game_canvas.setPlayers(basePlayerA, basePlayerB);
	}
	
}

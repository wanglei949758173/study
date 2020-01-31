package main;

import gui.GamePanel;
import util.AiPlayer;
import util.BasePlayer;
import util.IChessboard;

public class GameStart {

	public static void main(String[] args) {
		
		IChessboard chessboard=new IChessboard();
		
		BasePlayer humanplayer=new BasePlayer(chessboard);
		AiPlayer computerplayer=new AiPlayer(chessboard,humanplayer.getMyPoints());
		
		GamePanel gamePanel=new GamePanel();
		gamePanel.setPlayers(humanplayer, computerplayer);
		
		gamePanel.setVisible(true);
	}
}

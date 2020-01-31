package chess.robot.testrobot;

import chess.robot.IRobot;
import chess.robot.Position;

public class TestRobot implements IRobot {
	private boolean isBlack;
	private int stepIndex;
	
	@Override
	public String playerName() {
		return "test";
	}

	@Override
	public void play(boolean isBlack) {
		this.isBlack = isBlack;
		stepIndex = 1;
	}

	@Override
	public Position nextStep() {
		Position pos = new Position();
		
		if(isBlack) {
			pos.x = 0 + stepIndex;
			pos.y = 0 + stepIndex;
//			pos.x = 10;
//			pos.y = 1 + stepIndex;
		} else {
			pos.x = 10;
			pos.y = 0 + 2 * stepIndex;
		}
		stepIndex++;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pos;
	}

	@Override
	public void putChess(Position pos) {
	}

}

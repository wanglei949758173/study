package chess.robot;

/**
 * 机器人接口
 * @author Administrator
 *
 */
public interface IRobot {
	/**
	 * 获取参数选手的名字
	 * @return 选手名字
	 */
	String playerName();
	
	/**
	 * 开始游戏
	 * @param isBlack 是否持黑子
	 */
	void play(boolean isBlack);
	
	/**
	 * 下一步
	 * @return
	 */
	Position nextStep();
	
	/**
	 * 对手落子位置
	 * @param pos
	 */
	void putChess(Position pos);
}

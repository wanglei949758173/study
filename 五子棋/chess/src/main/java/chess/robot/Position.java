package chess.robot;

/**
 * @author 坐标说明：棋盘的左上角为棋盘原点，坐标为（0，0），右下角为最大值，按照本次大赛规定右下角坐标为（18，18）
 */
public class Position {
	/**
	 * 棋盘横坐标，横坐标从0开始，自左到右排序，最大为18.
	 */
	public int x;
	/**
	 * 棋盘纵坐标，纵纵坐标从0开始，自上而下排序，最大为18.
	 */
	public int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
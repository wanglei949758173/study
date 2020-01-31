package chess.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import chess.runner.Chessman;
import chess.runner.TimerMode;

/**
 * 棋盘类
 * @author Administrator
 *
 */
public class ChessBoard extends JPanel {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = -4708294053812525776L;
	/**
	 * 背景图
	 */
	private Image backgroundImage;
	/**
	 * 黑子图片
	 */
	private Image blackChessmanImage;
	/**
	 * 白子图片
	 */
	private Image whiteChessmanImage;
	/**
	 * 钟表图片
	 */
	private Image timerImage;
	/**
	 * 黑棋选手头像
	 */
	private Image blackPlayerImage;
	/**
	 * 白棋选手头像
	 */
	private Image whitePlayerImage;
	/**
	 * 落子情况
	 */
	private Chessman[] chessmans = new Chessman[361];
	/**
	 * 黑棋计时
	 */
	private int blackTime = 0;
	/**
	 * 白棋计时
	 */
	private int whiteTime = 0;
	/**
	 * 计时模式
	 */
	private TimerMode timerMode;
	
	/**
	 * 构造函数
	 */
	public ChessBoard() {
		this.setPreferredSize(new Dimension(768, 768));
		
		loadImages();	
		
		reset();
	}
	
	/**
	 * 加载所有图片
	 */
	private void loadImages() {
		try {
			backgroundImage = ImageIO.read(this.getClass().getResource("/bkg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			blackChessmanImage = ImageIO.read(this.getClass().getResource("/blackchessman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			whiteChessmanImage = ImageIO.read(this.getClass().getResource("/whitechessman.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			timerImage = ImageIO.read(this.getClass().getResource("/timer.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 绘制
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//绘制背景
		g.drawImage(backgroundImage, 0,  0, null);
		
		//绘制黑子选手头像
		if(blackPlayerImage != null) {
			g.drawImage(blackPlayerImage, 805, 76, 196, 196, null);
		}

		//绘制白子选手头像
		if(whitePlayerImage != null) {
			g.drawImage(whitePlayerImage, 805, 392, 196, 196, null);
		}

		//绘制棋子
		for(int r = 0; r < 19; r++) {
			for(int c = 0; c < 19; c++) {
				if(chessmans[r*19 + c] == Chessman.Black) {
					g.drawImage(blackChessmanImage, (int)Math.round(22 + c * 38.4), (int)Math.round(22 + r * 38.4), 32, 32, null);
				} else if(chessmans[r*19 + c] == Chessman.White) {
					g.drawImage(whiteChessmanImage, (int)Math.round(22 + c * 38.4), (int)Math.round(22 + r * 38.4), 32, 32, null);					
				}
			}
		}
		
		//绘制计时
		if(timerMode != TimerMode.NoTimer) {
			Font font = new Font("微软雅黑", Font.BOLD, 30);
			g.setFont(font);
			
			//黑子计时
			String str = String.format("%02d:%02d", this.blackTime / 60, this.blackTime);
			g.drawString(str, 850, 307);
			
			//白子计时
			str = String.format("%02d:%02d", this.whiteTime / 60, this.whiteTime);
			g.drawString(str, 850, 623);
			
			//绘制钟表
			if(timerMode == TimerMode.BlackTimer) {
				g.drawImage(timerImage, 810, 280, null);
			} else {
				g.drawImage(timerImage, 810, 596, null);
			}
		}
	}
	
	/**
	 * 设置黑子棋手头像
	 * @param img
	 */
	public void setBlackPlayerImage(Image img) {
		blackPlayerImage = img;
		this.repaint();
	}
	
	/**
	 * 设置白子棋手头像
	 * @param img
	 */
	public void setWhitePlayerImage(Image img) {
		whitePlayerImage = img;
		this.repaint();
	}

	/**
	 * 重置
	 */
	public void reset() {
		for(int i = 0; i < chessmans.length; i++) {
			chessmans[i] = Chessman.Empty;
		}
		
		blackTime = 0;
		whiteTime = 0;
		timerMode = TimerMode.NoTimer;
	}
	
	/**
	 * 放置棋子
	 * @param r
	 * @param c
	 * @param chessman
	 */
	public void putChessman(int r, int c, Chessman chessman) {
		if(r >= 0 && r < 19 && c >= 0 && c < 19) {
			chessmans[r * 19 + c] = chessman;
			repaint();
		}
	}

	/**
	 * 设置棋手用时
	 * @param mode
	 * @param time
	 */
	public void setPlayerTime(TimerMode mode, int time) {
		if(mode == TimerMode.BlackTimer) {
			if(blackTime != time || timerMode != mode) {
				timerMode = mode;
				blackTime = time;
				repaint();
			}
		} else if(mode == TimerMode.WhiteTimer) {
			if(whiteTime != time || timerMode != mode) {
				timerMode = mode;
				whiteTime = time;
				repaint();
			}
		} else if(timerMode != mode) {
			timerMode = mode;
			repaint();
		}
	}
	
	/**
	 * 取得棋子状态
	 * @return
	 */
	public Chessman[] getChessmans() {
		return chessmans;
	}
}

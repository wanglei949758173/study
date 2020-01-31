package gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import util.BasePlayer;
import util.Point;

public class ChessboardCanvas extends Canvas implements MouseListener{
	
	int width=0;
	int height=0;
	
	/**
	 * 判断当前该白色还是黑色落子
	 */
	boolean ishuman=true;
	
	int paddingX;
	int paddingY;
	
	BasePlayer basePlayerA;
	BasePlayer basePlayerB;
	
	/**
	 * 棋格的宽度
	 */
	int qige;
	
	int weidu=15;

	BufferedImage image = new BufferedImage(934, 673, BufferedImage.TYPE_INT_RGB);
	Graphics graphics = image.getGraphics();
	private Image offScreenImage; // 图形缓存
	
	/**
	 * 棋盘背景
	 */
	private Image chessboardImage;
	
	private Image white_chess_image;
	private Image black_chess_image;
	
	ArrayList<Point> white_points;
	ArrayList<Point> black_points;
	
	@Override
	public void paint(Graphics g) {

		if(width==0){
			width=getWidth();
			height=getHeight();
			
			addMouseListener(this);
			
			paddingX=22;
			paddingY=22;
			qige=(int) ((width-17-paddingX)/14.0);
			
			try 
			{
				white_chess_image=ImageIO.read(new File("file\\while_chessman_image.png"));
				black_chess_image=ImageIO.read(new File("file\\black_chessman_image.png"));
				chessboardImage=ImageIO.read(new File("file\\qp.jpg"));
				
				graphics.drawImage(chessboardImage, 0, 0, height, height, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(image, 0, 0, null);
	}
	 
	
	@Override
	public void update(Graphics g) {
		
		if(black_points!=null)
			for(Point point:black_points){
				int xx=point.x;
				int yy=point.y;
				graphics.drawImage(black_chess_image, (int)((xx-1)*qige+paddingX-qige*0.24),
						(int)((yy-1)*qige+paddingY-qige*0.24), (int)(qige*0.8), (int)(qige*0.8), null);
			}
		
		if(white_points!=null)
			for(Point point:white_points){
				int xx=point.x;
				int yy=point.y;
				graphics.drawImage(white_chess_image, (int)((xx-1)*qige+paddingX-qige*0.24),
						(int)((yy-1)*qige+paddingY-qige*0.24), (int)(qige*0.8), (int)(qige*0.8), null);
			}
		 
		if (offScreenImage == null)
			offScreenImage = this.createImage(width, height); // 新建一个图像缓存空间,这里图像大小为800*600
		Graphics gImage = offScreenImage.getGraphics(); // 把它的画笔拿过来,给gImage保存着
		paint(gImage); // 将要画的东西画到图像缓存空间去
		g.drawImage(offScreenImage, 0, 0, null); // 然后一次性显示出来
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int clickX = e.getX();
		int clickY = e.getY();
		
		int xx = (clickX - paddingX + qige / 2) / qige+1;
		int yy = (clickY - paddingY + qige / 2) / qige+1; 
		
		
		
		if(ishuman){
			if(!white_points.contains(new Point(xx, yy))){
				basePlayerA.run(new Point(xx, yy));
				long time1=System.currentTimeMillis();
				basePlayerB.run(null);
				long time2=System.currentTimeMillis();
				repaint();
				System.out.println("AI计算时间："+(time2-time1)+"毫秒");
			}
		}
		
		if(basePlayerA.hasWin()){
			JOptionPane.showMessageDialog(this, "游戏结束，白子赢了！");
			clear();
		}else if(basePlayerB.hasWin()){
			JOptionPane.showMessageDialog(this, "游戏结束，黑子赢了！");
			clear();
		}
	}
	
	public void clear(){
		ishuman=true;
		graphics.drawImage(chessboardImage, 0, 0, height, height, null);
		basePlayerA.getMyPoints().clear();
		basePlayerA.getChessboard().init();
		basePlayerB.getMyPoints().clear();
		repaint();
		
	}
	
	public void setPlayers(BasePlayer basePlayerA,BasePlayer basePlayerB){
		
		this.basePlayerA=basePlayerA;
		this.basePlayerB=basePlayerB;
		
		this.white_points=(ArrayList<Point>) this.basePlayerA.getMyPoints();
		this.black_points=(ArrayList<Point>) this.basePlayerB.getMyPoints();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}

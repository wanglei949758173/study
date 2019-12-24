package chess.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import chess.robot.IRobot;
import chess.robot.human.Human;
import chess.runner.ChessRunner;
import chess.runner.PlayResult;

/**
 * 主窗口
 * 
 * @author Administrator
 *
 */
public class MainWnd extends JFrame implements MouseListener, MouseMotionListener {
	/**
	 * 版本ID
	 */
	private static final long serialVersionUID = -2393051340371140694L;
	/**
	 * 拖动锚点
	 */
	private Point draggingAnchor;
	/**
	 * 拖动起始位置
	 */
	private Point draggingFromPos;
	/**
	 * 棋盘
	 */
	private ChessBoard chessBoard;
	/**
	 * 黑棋选手选择框
	 */
	private JComboBox<String> blackPlayerComboBox;
	/**
	 * 白棋棋选手选择框
	 */
	private JComboBox<String> whitePlayerComboBox;
	/**
	 * 开始游戏按钮
	 */
	private JButton startButton;
	/**
	 * 头像文件集合
	 */
	private Map<String, Image> headImages;
	/**
	 * 机器人集合
	 */
	private Map<String, IRobot> robots;
	/**
	 * 运行器
	 */
	private ChessRunner chessRunner;

	/**
	 * 构造函数
	 * 
	 * @param imagePath 头像文件路径
	 */
	public MainWnd(String imagePath) {
		try {
			// 加载头像
			loadHeadImages(imagePath);

			// 创建所有选手名
			createRobots();

			// 初始化
			initialize();

			// 设置窗口关闭时退出
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// 设置窗口大小
			setPreferredSize(new Dimension(1027, 768));

			// 显示窗口
			pack();
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载配置
	 * 
	 * @param imagePath 头像文件路径
	 */
	private void loadHeadImages(String imagePath) {
		headImages = new HashMap<String, Image>();

		File path = new File(imagePath);
		File[] files = path.listFiles((File dir, String name) -> {
			return name.endsWith(".png");
		});

		if (files != null) {
			for (File f : files) {
				try {
					Image img = ImageIO.read(f);
					if (img != null) {
						String name = f.getName();
						name = name.substring(0, name.lastIndexOf('.'));
						headImages.put(name, img);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 创建所有机器人
	 */
	private void createRobots() {
		robots = new HashMap<String, IRobot>();

		robots.put(human.playerName(), human);
		
//		IRobot robot = new chess.robot.testrobot.TestRobot();
//		robots.put(robot.playerName(), robot);
		
		IRobot robot = new chess.robot.wanglei.Robot();
		robots.put("王群", robot);

		robot = new chess.robot.testrobot.TestRobot();
		robots.put("郑维娜", robot);
	}

	/**
	 * 初始化
	 */
	private void initialize() {
		// 设置绝对布局
		this.setLayout(null);

		// 去掉标题栏
		setUndecorated(true);

		// 创建棋盘
		chessBoard = new ChessBoard();
		chessBoard.setBounds(0, 0, 1024, 768);
		chessBoard.setVisible(true);
		this.getLayeredPane().add(chessBoard, new Integer(Integer.MIN_VALUE));
		
		//创建运行器
		chessRunner = new ChessRunner(this, chessBoard);

		// 设置透明
		((JPanel) getContentPane()).setOpaque(false);

		// 创建黑棋选手选择框
		Font font = new Font("微软雅黑", Font.BOLD, 20);
		blackPlayerComboBox = new JComboBox<String>(robots.keySet().toArray(new String[robots.keySet().size()]));
		blackPlayerComboBox.setBounds(850, 33, 150, 34);
		blackPlayerComboBox.setFont(font);
		blackPlayerComboBox.setSelectedIndex(-1);
		blackPlayerComboBox.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String name = (String) e.getItem();
				removeItemFromComboBox(whitePlayerComboBox, name);
				
				if(headImages.containsKey(name)) {
					chessBoard.setBlackPlayerImage(headImages.get(name));
				} else {
					chessBoard.setBlackPlayerImage(null);
				}
			} else {
				String name = (String) e.getItem();
				addItemToComboBox(whitePlayerComboBox, name);
			}
		});
		blackPlayerComboBox.setVisible(true);
		blackPlayerComboBox.setFocusable(false);
		this.getContentPane().add(blackPlayerComboBox);

		// 创建白棋选手选择框
		whitePlayerComboBox = new JComboBox<String>(robots.keySet().toArray(new String[robots.keySet().size()]));
		whitePlayerComboBox.setBounds(850, 347, 150, 34);
		whitePlayerComboBox.setFont(font);
		whitePlayerComboBox.setSelectedIndex(-1);
		whitePlayerComboBox.addItemListener((e) -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String name = (String) e.getItem();
				removeItemFromComboBox(blackPlayerComboBox, name);
				
				if(headImages.containsKey(name)) {
					chessBoard.setWhitePlayerImage(headImages.get(name));
				} else {
					chessBoard.setWhitePlayerImage(null);
				}
			} else {
				String name = (String) e.getItem();
				addItemToComboBox(blackPlayerComboBox, name);
			}
		});
		whitePlayerComboBox.setVisible(true);
		whitePlayerComboBox.setFocusable(false);
		this.getContentPane().add(whitePlayerComboBox);

		// 创建开始游戏按钮
		startButton = new JButton();
		startButton.setIcon(new ImageIcon(MainWnd.class.getResource("/playgamebutn.png")));
		startButton.setPressedIcon(new ImageIcon(MainWnd.class.getResource("/playgamebutd.png")));
		startButton.setBackground(null);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(false);
		startButton.setBounds(838, 700, 128, 34);
		startButton.setVisible(true);
		startButton.addActionListener((e) -> {
			playGame();
		});
		this.getContentPane().add(startButton);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	private void removeItemFromComboBox(JComboBox<String> comboBox, String text) {
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).equals(text)) {
				comboBox.removeItemAt(i);
				break;
			}
		}
	}

	private void addItemToComboBox(JComboBox<String> comboBox, String text) {
		boolean existFlag = false;
		for (int i = 0; i < comboBox.getItemCount(); i++) {
			if (comboBox.getItemAt(i).equals(text)) {
				existFlag = true;
				break;
			}
		}

		if (!existFlag) {
			comboBox.addItem(text);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			draggingAnchor = e.getLocationOnScreen();
			draggingFromPos = getLocation();
		} else {
			setLocation(0, 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		draggingAnchor = null;
		draggingFromPos = null;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (draggingAnchor != null) {
			Point pos = new Point(draggingFromPos);
			pos.translate(e.getLocationOnScreen().x - draggingAnchor.x, e.getLocationOnScreen().y - draggingAnchor.y);
			setLocation(pos);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		human.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * 开始游戏
	 */
	private void playGame() {
		String blackPlayer = (String) blackPlayerComboBox.getSelectedItem();
		String whitePlayer = (String) whitePlayerComboBox.getSelectedItem();

		if (blackPlayer == null || (!robots.containsKey(blackPlayer)) || whitePlayer == null
				|| (!robots.containsKey(whitePlayer))) {
			JOptionPane.showMessageDialog(this, "请选择双方选手！", "开始游戏", JOptionPane.ERROR_MESSAGE);
		} else {
			int res = JOptionPane.showConfirmDialog(this, "您确认双方选手选择无误，可以开始比赛？", "开始游戏", JOptionPane.OK_CANCEL_OPTION);
			if (res == JOptionPane.OK_OPTION) {
				blackPlayerComboBox.setEnabled(false);
				whitePlayerComboBox.setEnabled(false);
				startButton.setEnabled(false);
				JOptionPane.showMessageDialog(this, "比赛开始！", "开始游戏", JOptionPane.INFORMATION_MESSAGE);
				
				IRobot blackRobot = robots.get(blackPlayerComboBox.getSelectedItem());
				IRobot whiteRobot = robots.get(whitePlayerComboBox.getSelectedItem());
				chessRunner.start(blackRobot, whiteRobot);
			}
		}
	}
	
	/**
	 * 游戏结束
	 * @param result
	 */
	public void playEnd(PlayResult result) {
		if(result == PlayResult.BlackWin) {
			JOptionPane.showMessageDialog(this, "黑棋获胜！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
		} else if(result == PlayResult.WhiteWin) {
			JOptionPane.showMessageDialog(this, "白棋获胜！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
		} if(result == PlayResult.Tied) {
			JOptionPane.showMessageDialog(this, "和棋！", "游戏结束", JOptionPane.INFORMATION_MESSAGE);
		}
		
		blackPlayerComboBox.setEnabled(true);
		whitePlayerComboBox.setEnabled(true);
		startButton.setEnabled(true);
	}

	static Human human = null;
	public static void main(String[] args) {
		// 必须传入头像文件目录
		if (args.length != 1) {
			return;
		}
		
		human = new Human();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainWnd(args[0]);
			}
		});
	}

}

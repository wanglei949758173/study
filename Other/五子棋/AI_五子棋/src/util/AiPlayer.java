package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AiPlayer extends BasePlayer {

	/**
	 * 表示方向,0水平方向，1水平方向逆时针45度，2垂直方向，3垂直方向逆时针旋转45度
	 */
	final int XXXXXX = 0;
	final int XXXXXX_45 = 1;
	final int YYYYYY = 2;
	final int YYYYYY_45 = 3;
	
	int x_direction[]={0,1,1,-1};
	int y_direction[]={1,0,1,1};

	int addcount[] = { 10, 8, 5, 3 };

	int reducecount[] = { 18, 8, 5, 3 };

	// 计算范围，太大的范围会有性能问题
	private class CalcuteRange {
		int xStart, yStart, xStop, yStop;

		private CalcuteRange(int xStart, int yStart, int xStop, int yStop) {
			this.xStart = xStart;
			this.yStart = yStart;
			this.xStop = xStop;
			this.yStop = yStop;
		}
	}

	List<Point> hunmanPoints;

	CalcuteRange currentRange = new CalcuteRange(1, 1, 1, 1);

	public AiPlayer(IChessboard chessboard, List<Point> hunmanPoints) {
		super(chessboard);
		this.hunmanPoints = hunmanPoints;
	}

	/**
	 * AI通过计算返回最有利的点
	 * 
	 * @return
	 */
	public Point getBestPoint() {

		//所有需要计算权值的点
		ArrayList<Point> arrayList = getAllneedComputer();
		//---------------------------判断电脑是否有可以构成五连的坐标
		for(Point point:arrayList){
			
			if(islianwu(point, hadLocalPoints))
				return point;
		}
		//---------------------------判断对手是否有可以构成五连的坐标
		for(Point point:arrayList){
			
			if(islianwu(point, hunmanPoints))
				return point;
		}
		//---------------------------判断电脑是否有可以构成活四的坐标，一般会有两个点，需要计算最优点
		for(Point point:arrayList){
			
			if(ishuosi(point, hadLocalPoints))
				return point;
		}
		//---------------------------判断人类是否有可以构成活四的坐标
		for(Point point:arrayList){
			
			if(ishuosi(point, hunmanPoints))
				return point;
		}
		
		for(Point point:arrayList){
			
			if(isdouble3(point, hadLocalPoints))
				return point;
		}
		
		for(Point point:arrayList){
			
			if(isdouble3(point, hunmanPoints))
				return point;
		}

		int max_computer = 0;
		//记录计算机有利权值最大的点
		ArrayList<Point> max_computer_points=new ArrayList<>();

		int max_human = 0;
		//记录人类有利权值最大的点
		ArrayList<Point> max_human_points=new ArrayList<>();
		for (Point point : arrayList) {

			int computerGoal = computerPointGoal(point, hadLocalPoints);
			if (computerGoal > max_computer) {
				max_computer = computerGoal;
				max_computer_points.clear();
				max_computer_points.add(point);
			}else if(computerGoal == max_computer){
				max_computer_points.add(point);
			}
		}

		for (Point point : arrayList) {

			int humanGoal = computerPointGoal(point, hunmanPoints);
			if (humanGoal > max_human) {
				max_human = humanGoal;
				max_human_points.clear();
				max_human_points.add(point);
			}else if(humanGoal == max_human){
				max_human_points.add(point);
			}
		}

		if (max_computer > max_human){
			System.out.println("自己活！"+"...可走的方案："+max_computer_points.size());
			return max_computer_points.get(max_computer_points.size()-1);
		}
		System.out.println("堵对手！"+"...可走的方案："+max_human_points.size());
		Random random=new Random();
		return max_human_points.get(random.nextInt(max_human_points.size()));
	} 
	
	/**
	 *判断落子处的一个方向上是否构成双活三
	 * @param point
	 * @param x
	 * @param y
	 * @param points
	 * @return
	 */
	public boolean isdouble3(Point point, List<Point> points){
		int x=0;
		int y=0;
		
		int threeCount=0;
		
		for(int i=0;i<4;i++){
			x=x_direction[i];
			y=y_direction[i];
			int countall=1;
			int kongweiX=0;
			int kongweiY=0;
			for (int ri = 1; ri <= 4; i++) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				} else if (freePoints.contains(point2)) {
					kongweiX++;
				}else{
					break;
				}
			}
			
			for (int ri = 1; ri <= 4; i++) {
				Point point2 = new Point(point.x - x * i, point.y - y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				} else if (freePoints.contains(point2)) {
					kongweiY++;
				}else{
					break;
				}
			}
			
			if(countall>2&&((kongweiX>=2&&kongweiY>=1)||(kongweiY>=2&&kongweiX>=1))){
				threeCount++;
			}else if(countall>3&&(kongweiX>=1||kongweiY>=1)){
				threeCount++;
			}
		}
		
		if(threeCount>=2)
			return true;
		
		return false;
	}

	/**
	 * 判断落子处的一个方向上是否构成活四
	 * 
	 * @param point
	 * @param x
	 * @param y
	 * @param points
	 * @return
	 */
	public boolean ishuosi(Point point, List<Point> points) {
		int x,y;
		for(int ri=0;ri<4;ri++){
			x=x_direction[ri];
			y=y_direction[ri];
			int countall = 1;
			int huowei = 0;
			
			for (int i = 1; i <= 4; i++) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				} else if (freePoints.contains(point2)) {
					huowei++;
					break;
				}else{
					break;
				}
			}
			
			for (int i = -1; i >= -4; i--) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				} else if (freePoints.contains(point2)) {
					huowei++;
					break;
				}else{
					break;
				}
			}
			if (countall == 4 && huowei == 2)
				return true;
		}

		return false;
	}
	
	/**
	 * 判断落子处的一个方向上是否构成连五
	 * 
	 * @param point
	 * @param x
	 * @param y
	 * @param points
	 * @return
	 */
	public boolean islianwu(Point point,List<Point> points) {
		int x,y;
		for(int ri=0;ri<4;ri++){
			x=x_direction[ri];
			y=y_direction[ri];
			
			int countall = 1;
			for (int i = 1; i <= 4; i++) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				}  else{
					break;
				}
			}
			
			for (int i = -1; i >= -4; i--) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (points.contains(point2)) {// 有我方的子，非常有利
					countall++;
				} else{
					break;
				}
			}
			
			if (countall>4){
				return true;
			}
		}
		
		return false;
	}

	/**
	 * 获取所有需要计算的点
	 * 
	 * @return
	 */
	public ArrayList<Point> getAllneedComputer() {
		ArrayList<Point> arrayList = new ArrayList<>();

		initRange(hadLocalPoints, hunmanPoints);

		for (int i = currentRange.xStart; i <= currentRange.xStop; i++) {
			for (int ri = currentRange.yStart; ri <= currentRange.yStop; ri++) {
				Point point = new Point(i, ri);
				if (freePoints.contains(point)) {
					arrayList.add(point);
				}
			}
		}
		return arrayList;
	}

	/**
	 * 计算某点的权值
	 * 
	 * @param point
	 * @return
	 */
	public int computerPointGoal(Point point, List<Point> playpoints) {

		return computerPointGoalbyDirection(point, XXXXXX, playpoints)
				+ computerPointGoalbyDirection(point, XXXXXX_45, playpoints)
				+ computerPointGoalbyDirection(point, YYYYYY, playpoints)
				+ computerPointGoalbyDirection(point, YYYYYY_45, playpoints);
	}

	/**
	 * 表示方向,0水平方向，1水平方向逆时针45度， 2垂直方向，3垂直方向逆时针旋转45度
	 * 
	 * @param point
	 * @param direction
	 * @return
	 */
	public int computerPointGoalbyDirection(Point point, int direction, List<Point> playpoints) {

		int x = 0;
		int y = 0;
		switch (direction) {
		case 0:
			x = 1;
			y = 0;
			break;
		case 1:
			x = 1;
			y = 1;
			break;
		case 2:
			x = 0;
			y = 1;
			break;
		case 3:
			x = 1;
			y = -1;
			break;

		}

		int countall = 0;

		// 1.1 如果该方向不可能构成五子，则结果为 0。
		// 1.2如果有机会构成五子，则计算形势。比如横向构成五子。
		// 如果旁边有自己的子就加权（根据离自己的距离，分别加权10,8,5,3,2,1）--累加
		// 如果旁边有对方的子，则分别减权（15,5,3,1,1）--不累减
		if (iscanSuccess(point, x, y)) {

			Point oldPoint=null;
			for (int i = 1; i <= 4; i++) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (playpoints.contains(point2)) {// 有我方的子，非常有利
					countall += addcount[i-1];
					if(oldPoint==null||playpoints.contains(oldPoint)){
						countall+=10;
						oldPoint=point2;
					}
					
				} else if (freePoints.contains(point2)) {// 是空闲的区域，可以接受
					countall++;
				} else {// 是敌方的子，完蛋
					if(i!=4)
						countall-=reducecount[i-1];
					break;
				}
			}
			oldPoint=null;
			for (int i = -1; i >= -4; i--) {
				Point point2 = new Point(point.x + x * i, point.y + y * i);
				if (playpoints.contains(point2)) {// 有我方的子，非常有利
					countall += addcount[-1 - i];
					if(oldPoint==null||playpoints.contains(oldPoint)){
						countall+=10;
						oldPoint=point2;
					}
				} else if (freePoints.contains(point2)) {// 是空闲的区域，可以接受
					countall++;
				} else {// 是敌方的子，完蛋
					break;
				}
			}
		}
		return countall;
	}

	/**
	 * 判断是否有机会构成五子
	 * 
	 * @param point
	 * @param direction
	 * @return
	 */
	public boolean iscanSuccess(Point point, int x, int y) {
		int count = 1;
		for (int i = 1;; i++) {
			Point point2 = new Point(point.x + x * i, point.y + y * i);
			if (freePoints.contains(point2) || hadLocalPoints.contains(point2)) {
				count++;
			} else
				break;
		}
		for (int i = -1;; i--) {
			Point point2 = new Point(point.x + x * i, point.y + y * i);
			if (freePoints.contains(point2) || hadLocalPoints.contains(point2)) {
				count++;
			} else
				break;
		}
		if (count >= 5)
			return true;
		return false;
	}

	@Override
	public void run(Point want_Point) {
		want_Point = getBestPoint();
		// 更新当前玩家可以落子的位置
		freePoints.remove(want_Point);

		// 落子
		hadLocalPoints.add(want_Point);
	}

	// 限定电脑计算范围，如果整个棋盘计算，性能太差，目前是根据所有已下的棋子的边界值加RANGE_STEP值形成，目前为1
	private static final int RANGE_STEP = 1;

	/**
	 * 初始化计算范围
	 * 
	 * @param comuters
	 * @param humans
	 */
	private void initRange(List<Point> comuters, List<Point> humans) {
		currentRange.xStart = humans.get(0).getX() - RANGE_STEP;
		currentRange.yStart = humans.get(0).getY() - RANGE_STEP;
		currentRange.xStop = humans.get(0).getX() + RANGE_STEP;
		currentRange.yStop = humans.get(0).getY() + RANGE_STEP;
		for (Point point : humans) {
			if (point.getX() - RANGE_STEP < currentRange.xStart) {
				currentRange.xStart = point.getX() - RANGE_STEP;
			} else if (point.getX() + RANGE_STEP > currentRange.xStop) {
				currentRange.xStop = point.getX() + RANGE_STEP;
			}
			if (point.getY() - RANGE_STEP < currentRange.yStart) {
				currentRange.yStart = point.getY() - RANGE_STEP;
			} else if (point.getY() + RANGE_STEP > currentRange.yStop) {
				currentRange.yStop = point.getY() + RANGE_STEP;
			}
		}
		for (Point point : comuters) {
			if (point.getX() - RANGE_STEP < currentRange.xStart) {
				currentRange.xStart = point.getX() - RANGE_STEP;
			} else if (point.getX() + RANGE_STEP > currentRange.xStop) {
				currentRange.xStop = point.getX() + RANGE_STEP;
			}
			if (point.getY() - RANGE_STEP < currentRange.yStart) {
				currentRange.yStart = point.getY() - RANGE_STEP;
			} else if (point.getY() + RANGE_STEP > currentRange.yStop) {
				currentRange.yStop = point.getY() + RANGE_STEP;
			}
		}

		if (currentRange.xStart < 1)
			currentRange.xStart = 1;
		if (currentRange.xStop > 15)
			currentRange.xStop = 15;
		if (currentRange.yStart < 1)
			currentRange.yStart = 1;
		if (currentRange.yStop > 15)
			currentRange.yStop = 15;
	}

}

package chess.robot.wanglei;

import java.util.ArrayList;

import chess.robot.Position;

// 博弈树节点
class Node {
	// 最优点
	public Node bestChild = null;

	// 子节点
	public ArrayList<Node> child = new ArrayList<Node>();

	// 节点的位置信息
	public Position p = new Position();
	
	// 节点的分数
	public int mark;
	
	// 设置节点的位置信息
	public void setPoint(Position r) {
		p.x = r.x;
		p.y = r.y;
	}

	// 添加子节点
	public void addChild(Node node) {
		this.child.add(node);
	}

	// 获取最后一个子节点
	public Node getLastChild() {
		return child.get(child.size() - 1);
	}
}
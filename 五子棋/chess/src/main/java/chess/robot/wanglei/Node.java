package chess.robot.wanglei;

import java.util.ArrayList;

import chess.robot.Position;

// 树节点  
class Node{  
    public Node bestChild=null;  
    public ArrayList<Node> child=new ArrayList<Node>();  
    public Position p=new Position();  
    public int mark;  
    Node(){  
        this.child.clear();  
        bestChild=null;  
        mark=0;  
    }  
    public void setPoint(Position r){  
        p.x=r.x;  
        p.y=r.y;  
    }  
    public void addChild(Node r){  
        this.child.add(r);  
    }  
    public Node getLastChild(){  
        return child.get(child.size()-1);  
    }  
}
/*      
 * 模块编号  
 * 功能描述 
 * 文件名 TestDeepCopy.java 
 * 作者 王磊 
 * 编写日期 2020年03月23日 
 */
package test.pattern.creator.prototype.deepcopy;

public class TestDeepCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneSheep cloneSheep = new CloneSheep();
		cloneSheep.setName("克隆羊");
		cloneSheep.setAge(10);
		cloneSheep.setColor("白色");
		CloneSheep friend = new CloneSheep();
		friend.setName("克隆狼");
		friend.setAge(9);
		friend.setColor("披着羊皮");
		cloneSheep.setFriend(friend);
		
		CloneSheep sheep1 = (CloneSheep) cloneSheep.deepClone();
		CloneSheep sheep2 = (CloneSheep) cloneSheep.deepClone();
		CloneSheep sheep3 = (CloneSheep) cloneSheep.clone();
		CloneSheep sheep4 = (CloneSheep) cloneSheep.clone();
		CloneSheep sheep5 = (CloneSheep) cloneSheep.clone();
		
		System.out.println(cloneSheep);
		
		System.out.println(sheep1.getFriend().hashCode());
		System.out.println(sheep2.getFriend().hashCode());
		System.out.println(sheep3);
		System.out.println(sheep4);
		System.out.println(sheep5);
	}
}

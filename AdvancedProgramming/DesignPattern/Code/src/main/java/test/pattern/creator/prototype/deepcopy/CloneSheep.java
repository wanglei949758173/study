package test.pattern.creator.prototype.deepcopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneSheep implements Cloneable,Serializable {
	private static final long serialVersionUID = 6138372906771957939L;

	private String name;

	private int age;

	private String color;

	private CloneSheep friend;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public CloneSheep getFriend() {
		return friend;
	}

	public void setFriend(CloneSheep friend) {
		this.friend = friend;
	}

	@Override
	public String toString() {
		return "CloneSheep [name=" + name
				+ ", age="
				+ age
				+ ", color="
				+ color
				+ ", friend="
				+ friend
				+ "]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		CloneSheep cloneSheep = (CloneSheep) super.clone();
		// 深拷贝friend字段
		if (friend != null) {
			CloneSheep cloneFriend = (CloneSheep) friend.clone();
			cloneSheep.setFriend(cloneFriend);
		}
		return cloneSheep;
	}

	/**
	 * 使用反序列化的方式进行克隆
	 * @return
	 */
	protected CloneSheep deepClone() {
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			// 序列化
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			// 反序列化
			bis = new ByteArrayInputStream(bos.toByteArray());
			ois = new ObjectInputStream(bis);
			return (CloneSheep) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (bos != null) {
					bos.close();
				}
				if (oos != null) {
					oos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
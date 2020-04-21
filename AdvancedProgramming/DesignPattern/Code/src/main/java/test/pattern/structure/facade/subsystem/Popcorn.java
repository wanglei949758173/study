package test.pattern.structure.facade.subsystem;

/**
 * 爆米花机
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Popcorn {

	private static Popcorn instance = new Popcorn();

	public static Popcorn getInstance() {
		return instance;
	}

	public void on() {
		System.out.println(" popcorn on ");
	}

	public void off() {
		System.out.println(" popcorn ff ");
	}

	public void pop() {
		System.out.println(" popcorn is poping  ");
	}
}
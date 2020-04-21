package test.pattern.structure.facade.subsystem;

/**
 * 屏幕
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Screen {

	private static Screen instance = new Screen();

	public static Screen getInstance() {
		return instance;
	}

	public void up() {
		System.out.println(" Screen up ");
	}

	public void down() {
		System.out.println(" Screen down ");
	}

}
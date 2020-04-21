package test.pattern.structure.facade.subsystem;

/**
 * 投影仪
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class Projector {

	private static Projector instance = new Projector();
	
	public static Projector getInstance() {
		return instance;
	}
	
	public void on() {
		System.out.println(" Projector on ");
	}
	
	public void off() {
		System.out.println(" Projector ff ");
	}
	
	public void focus() {
		System.out.println(" Projector is Projector  ");
	}
	
	//...
}
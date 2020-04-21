/*      
 * 模块编号  
 * 功能描述 
 * 文件名 HomeTheaterFacade.java 
 * 作者 王磊 
 * 编写日期 2020年04月20日 
 */
package test.pattern.structure.facade;

import test.pattern.structure.facade.subsystem.DVDPlayer;
import test.pattern.structure.facade.subsystem.Popcorn;
import test.pattern.structure.facade.subsystem.Projector;
import test.pattern.structure.facade.subsystem.Screen;
import test.pattern.structure.facade.subsystem.Stereo;
import test.pattern.structure.facade.subsystem.TheaterLight;

/**
 * 家庭影院门面
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class HomeTheaterFacade {

	// 定义各个子系统对象
	private TheaterLight theaterLight;
	private Popcorn popcorn;
	private Stereo stereo;
	private Projector projector;
	private Screen screen;
	private DVDPlayer dVDPlayer;

	// 构造器
	public HomeTheaterFacade() {
		super();
		this.theaterLight = TheaterLight.getInstance();
		this.popcorn = Popcorn.getInstance();
		this.stereo = Stereo.getInstance();
		this.projector = Projector.getInstance();
		this.screen = Screen.getInstance();
		this.dVDPlayer = DVDPlayer.getInstanc();
	}

	// 操作分成 4 步

	public void ready() {
		popcorn.on();
		popcorn.pop();
		screen.down();
		projector.on();
		stereo.on();
		dVDPlayer.on();
		theaterLight.dim();
	}

	public void play() {
		dVDPlayer.play();
	}

	public void pause() {
		dVDPlayer.pause();
	}

	public void end() {
		popcorn.off();
		theaterLight.bright();
		screen.up();
		projector.off();
		stereo.off();
		dVDPlayer.off();
	}
}

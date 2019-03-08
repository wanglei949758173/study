package pattern.strategy;
/**
 * 
 * @ClassName: Context 
 * @Description: 锦囊类
 * @author 王磊
 *
 */
public class Context {
	/**
	 * 锦囊中的策略
	 */
	private IStrategy iStrategy;
	
	public Context(IStrategy iStrategy) {
		this.iStrategy = iStrategy;
	}
	
	public void opreate() {
		System.out.println("打开锦囊........");
		//执行锦囊里的策略
		iStrategy.operate();
	}
}

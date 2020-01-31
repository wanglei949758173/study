package pattern.strategy;
/**
 * 所有锦囊策略需要实现的接口
* @ClassName: IStrategy 
* @Description: 策略接口
* @author 王磊
*
 */
public interface IStrategy {
	//打开锦囊，执行策略
	void operate();
}

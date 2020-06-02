/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Client.java 
 * 作者 王磊 
 * 编写日期 2020年06月02日 
 */
package test.pattern.action.state;

public class Client {
	public static void main(String[] args) {
		// 两个奖品
		RaffleActivity activity = new RaffleActivity(2);

		// 连续抽50次奖
		for (int i = 0; i < 50; i++) {
			System.out.println("--------第" + (i + 1) + "次抽奖----------");
			// 参加抽奖，第一步点击扣除积分
			activity.debuctMoney();

			// 第二步抽奖
			activity.raffle();
			System.out.println();
		}
	}
}

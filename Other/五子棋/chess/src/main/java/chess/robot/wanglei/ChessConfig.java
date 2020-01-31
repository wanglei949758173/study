/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ChessConfig.java  
 * 作者 王磊 
 * 编写日期 2019年12月25日    
 */
package chess.robot.wanglei;

/**
 * 保存棋盘的一些配置信息
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public interface ChessConfig {
	// 棋盘行数
	int CHESS_ROW = 19;
	
	// 棋盘列数
	int CHESS_COLUMN = 19;
	
	// 对手落点
	int OPPONENT = 1;
	
	// 无落点
	int NO_POINT = 0;
	
	// 自己落点
	int SELF = 2;
}

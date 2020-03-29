/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Priority.java 
 * 作者 王磊 
 * 编写日期 2020年03月29日 
 */
package study.datastructures.list.stack.impl;

public final class SymbolPriority {
	private static final int PLUS_PRIORITY = 1;
	private static final int SUB_PRIORITY = 1;
	private static final int MUL_PRIORITY = 999;
	private static final int DIV_PRIORITY = 999;

	public static boolean isGraterThan(String symbol1, String symbol2) {
		int symbol1Priority = getPriority(symbol1);
		int symbol2Priority = getPriority(symbol2);
		return symbol1Priority > symbol2Priority;
	}

	private static int getPriority(String symbol) {
		if ("+".equals(symbol)) {
			return PLUS_PRIORITY;
		} else if ("-".equals(symbol)) {
			return SUB_PRIORITY;
		} else if ("*".equals(symbol)) {
			return MUL_PRIORITY;
		} else if ("/".equals(symbol)) {
			return DIV_PRIORITY;
		} else {
			throw new IllegalArgumentException("错误的符号：" + symbol);
		}
	}
}

/**
 * FileName: test.pattern.interpret
 * Author    王磊
 * Date      2019/4/21 21:00
 * Description: 抽象表达式
 */
package test.pattern.interpret;

/**
 * 抽象表达式
 *
 * @author Administrator
 * @since 1.0.0
 */
public abstract class AbstractExpression {
    /**
     * 解释的操作
     * @param ctx 上下文对象
     */
    public abstract void interpret(Context ctx);
}

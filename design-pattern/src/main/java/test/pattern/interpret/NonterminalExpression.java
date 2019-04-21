/**
 * FileName: test.pattern.interpret
 * Author    王磊
 * Date      2019/4/21 21:03
 * Description: 非终结符表达式===相当于组合对象
 */
package test.pattern.interpret;

import java.util.ArrayList;
import java.util.List;

/**
 * 非终结符表达式===相当于组合对象
 *
 * @author Administrator
 * @since 1.0.0
 */
public class NonterminalExpression extends AbstractExpression {
    private List<AbstractExpression> list = new ArrayList<AbstractExpression>();

    public void addAbstractExpression(AbstractExpression ae) {
        list.add(ae);
    }

    @Override
    public void interpret(Context ctx) {
        //实现与语法规则中的非终结符相关联的解释操作
    }
}

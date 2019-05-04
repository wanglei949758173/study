/**
 * FileName: test.pattern.state
 * Author    王磊
 * Date      DATE 20:11
 * Description: 封装与Context的一个特定状态相关的行为
 */
package test.pattern.state;

/**
 * 封装与Context的一个特定状态相关的行为
 *
 * @author Administrator
 * @since 1.0.0
 */
public interface State {
    /**
     * 状态对应的处理
     *
     * @param sampleParameter 示例参数，说明可以传入参数，具体传入
     *                        什么样的参数，传入几个参数，由具体应用来具体分析
     */
    public void handle(String sampleParameter);
}

/**
 * FileName: test.pattern.command
 * Author    王磊
 * Date      DATE 22:13
 * Description: 命令接口，声明执行的操作
 */
package test.pattern.command;

/**
 * 命令接口，声明执行的操作
 *
 * @author Administrator
 * @since 1.0.0
 */
public interface Command {
    /**
     * 执行命令对应的操作
     */
    public void execute();
}

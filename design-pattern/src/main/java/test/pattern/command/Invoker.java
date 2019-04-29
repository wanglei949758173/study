/**
 * FileName: test.pattern.command
 * Author    王磊
 * Date      2019/4/29 22:18
 * Description: 调用者
 */
package test.pattern.command;

/**
 * 调用者
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Invoker {
    /**
     * 持有命令对象
     */
    private Command command = null;

    /**
     * 设置调用者持有的命令对象
     *
     * @param command 命令对象
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 示意方法，要求命令执行请求
     */
    public void runCommand() {
        //调用命令对象的执行方法
        command.execute();
    }
}

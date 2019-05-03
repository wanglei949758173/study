/**
 * FileName: test.pattern.memento
 * Author    王磊
 * Date      2019/5/3 21:42
 * Description: 客户端，模拟备忘录模式的执行过程
 */
package test.pattern.memento;

/**
 * 客户端，模拟备忘录模式的执行过程
 *
 * @author Administrator
 * @since 1.0.0
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();

        //originator.executeOnePhase(); 执行第一阶段

        // 获取当前转态
        Memento memento = originator.createMemento();

        // 保存状态
        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);

        // 设置之前保存的状态
        originator.setMemento(memento);

        //originator.doSomething(); 干其他的事
    }
}

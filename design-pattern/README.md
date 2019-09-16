# 1. 七大设计原则
## 1.1 单一职责原则
  * 对类来说,一个类应该**只负责一项职责**。

## 1.2 接口隔离原则
  * 客户端**不应该依赖它不需要的接口**，即一个类对另一个类的依赖应该建立在最小的接口上

  * **通俗解释:** 尽量将接口的方法按照功能拆分。

## 1.3 依赖导致原则
  * **定义:**
    1. 高层模块不应该依赖低层模块，二者都应该依赖其抽象
    2. 抽象不应该依赖细节，细节应该依赖抽象
    3. 依赖倒转(倒置)的中心思想是面向接口编程


  * **通俗解释:** 面向接口编程。

## 1.4 里氏替换原则
  * 所有引用**基类**的地方必须能**透明地使用其子类**的对象。

  * **通俗解释:** **尽量不要重写父类已经实现的方法**,如果必须要使用到父类已实现的方法,
    可以使用**聚合、组合**的方式**代替继承**。

## 1.5 开闭原则
  * 对**扩展开放**,对**修改封闭**

  * **通俗解释:** 扩充功能时尽量不修改原来的代码,而是通过添加的方式来扩充功能。

  * **遵循其他的原则是做到开闭原则的基础。**

## 1.6 迪米特法则
  * 又叫**最少知道原则**,即一个类对自己依赖的类知道的越少越好。也就是说，对于被依赖的类
    不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的`public`方法，不对外泄露任
    何信息。

  * **通俗解释:** 只与直接的朋友通信。

  * **直接朋友** <br/>
    我们称出现在类A中的**成员变量**，**方法参数**， **方法返回值**为类A的直接朋友，而
    出现在**局部变量中的类不是直接的朋友**。也就是说，陌生的类最好不要以局部变量的形式
    出现在类的内部。

## 1.7 合成复用原则
  * 原则是尽量使用**合成**, **聚合**的方式，而**不是使用继承**

# 2. 类与类之间的关系
## 2.1 泛化关系(generalization)
  * 泛化关系==继承关系

  * 代码示例
    ```java
    public abstract class DaoSupport{
      public void save(Object entity){
      }
      public void delete(Object id){
      }
    }

    public class PersonServiceBean extends Daosupport{
    }
    ```

## 2.2 实现关系（Implementation）
  * 代码示例
    ```java
    public interface PersonService {
      void delete(Interger id);
    }
    public class PersonServiceBean implements PersonService {
      public void delete(Interger id){
      }
    }
    ```

## 2.3 依赖关系（Dependence）
  * 只要是**在类中用到了对方**，那么他们之间就存在依赖关系。如果
    **没有对方，连编绎都通过不了**。

  * 依赖的5种情况
    1. 类中用到了对方
    2. 如果是类的成员属性
    3. 如果是方法的返回类型
    4. 是方法接收的参数类型
    5. 方法中使用到


  * 代码示例
    ```java
    public class PersonServiceBean {
      private PersonDao personDao;
      public void save(Person person){}
      public IDCard getIDCard(Integer personid){}
      public void modify(){
        Department department = new Department();
      }
    }
    public class PersonDao{}
    public class IDCard{}
    public class Person{}
    public class Department{}
    ```

## 2.4 关联关系 (Association)
  * 关联关系实际上就是**类与类之间的联系**,**它是依赖关系的特例**

  * 关联具有**导航型**:即双向关系或单项关系

  * 关系具有多重性:如"1"(表示有且仅有一个),"0..."(表示0个或者多个),"0,1"(表示0个或者1个),
    "n...m"(表示n个到m个都可以),"m..."(表示至少m个)

  * 单项1对1关系


  * 双向1对1关系

## 2.5 聚合关系 (Aggregation)
  * 聚合关系表示的是**整体和部分**的关系,**整体与部分可以分开**。聚合关系是关联关系的特例

  * 举例说明 <br/>
    一台电脑由键盘(keyboard)、显示器(monitor)，鼠标等组成；组成电脑的各个配件是
    可以从电脑上分离出来的。

  

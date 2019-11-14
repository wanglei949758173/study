# 面向对象(Object-Oriented)
## 1. 为何要面向对象编程?
### 面向过程编程
面向过程的程序设计：核心是 **过程** 二字，过程指的是 **解决问题的步骤**，即先干什么再干什么......

面向过程的设计就好比精心设计好一条**流水线**，是一种机械式的思维方式。

* 优点
  复杂度的问题流程化，进而简单化（一个复杂的问题，分成一个个小的步骤去实现，实现小的步骤将会非常简单）
* 缺点
  一套流程就是用来解决一个问题，分析机车信号数据的系统就不能分析BTM的数据，即便是能，也得是大改，改一个组件，牵一发而动全身

### 面向对象编程
要理解对象为何物，必须把自己当成上帝，上帝眼里世间存在的万物皆为对象，不存在的也可以创造出来。面向对象的程序设计好比如来设计西游记，如来要解决的问题是把经书传给东土大唐，如来想了想解决这个问题需要四个人：唐僧，沙和尚，猪八戒，孙悟空，每个人都有各自的特征和技能（这就是对象的概念，特征和技能分别对应对象的数据属性和方法属性），然而这并不好玩，于是如来又安排了一群妖魔鬼怪，为了防止师徒四人在取经路上被搞死，又安排了一群神仙保驾护航，这些都是对象。然后取经开始，师徒四人与妖魔鬼怪神仙交互着直到最后取得真经。如来根本不会管师徒四人按照什么流程去取。

面向对象编程的核心是**对象**二字，对象是特征与技能的结合体。

比如猪八戒就是一个对象，这个对象有猪鼻子猪耳朵，并且会使用九齿钉耙，所以我们说他是猪八戒

基于面向对象编程的思想编写程序，就好比是在创造一个世界，你就是这个世界的上帝，是一种上帝式的思维方式。

比如你是个公司的老板，你想审核账目了，你该造出来一个对象（会计），让这个对象（会计）去帮你审核账目。又比如你又想喝咖啡了，你又可以造出来一个对象（秘书），让这个对象（秘书）去帮你倒咖啡。

* 优点
  1. 可扩展性强(比如原来有分析机车信号数据的系统，现在有了新的需求需要分析BTM的数据，机车信号的数据和BTM的数据如果有相似的地方，那么就可以在分析机车信号数据系统的基础上扩展一套分析BTM数据的系统，在不需要修改代码的前提下就可以做到功能的复用)
  2. 高质量&高生产效率(功能的单一可以提高质量，代码的复用可以提交生产效率)
  3. 更易维护
  4. 更适用于复杂的项目
  5. 更符合人们的认知
  6. 更安全(封装的特性可以体现出这一点)
* 缺点
  1. 编程的复杂度要高于面向过程(更考验设计的能力)

## 2. 如何使用好面向对象对象编程?
### 基本概念
#### 对象
对象是类的一个实例，有**状态**和**行为**。例如，一条狗是一个对象，它的状态有：颜色、名字、品种；行为有：摇尾巴、叫、吃等。

---
#### 类
一类事物的抽象,比如我们可以将猫和狗抽象为动物类。
```java
class Animal {
    String name;
    int age;
    void run(){
    }
}
```

---

#### 多态
多态是同一个行为具有多个不同表现形式或形态的能力。

比如：猫和狗同样都会叫，但叫声却不一样
```java
class Cat {
  void shout(){
      System.out.println("miao~~~");
  }
}

class Dog {
  void shout(){
      System.out.println("wang wang wang~~~");
  }
}
```
##### 重写(overwrite)
重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即 **外壳不变，核心重写！**

重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。

###### 重写(overwrite)示例代码
```java
class Animal{
   public void shout(){
      System.out.println("动物发出叫声");
   }
}

class Dog extends Animal{
   public void shout(){
      System.out.println("wang wang wang~~~");
   }
}

public class Cat {
  public void shout(){
      System.out.println("miao~~~");
  }
}
```
##### 重载(overload)
重载是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。

每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。

###### 重载规则
* 被重载的方法必须改变参数列表(参数个数或类型不一样)；
* 被重载的方法可以改变返回类型；
* 被重载的方法可以改变访问修饰符；
* 被重载的方法可以声明新的或更广的检查异常；
* 方法能够在同一个类中或者在一个子类中被重载。
* 无法以返回值类型作为重载函数的区分标准。

###### 重载(overload)示例代码
```java
class StudentService {
    public void study(String studentName) {
        System.out.println(studentName + "在学习...");
    }
    public void study(String studentName, String courseName) {
        System.out.println(studentName + "在学习" + courseName);
    }
    public void study(List<String> studentNames) {
        studentNames.forEach(StudentService::studentName);
    }
}
```

---

#### 继承
继承就是子类继承父类的特征和行为，使得子类对象（实例）具有父类的实例域和方法，或子类从父类继承方法，使得子类具有父类相同的行为。

##### 继承实例
![extends](/assets/extends.jpg)

兔子和羊属于食草动物类，狮子和豹属于食肉动物类。

食草动物和食肉动物又是属于动物类。

所以继承需要符合的关系是：is-a，父类更通用，子类更具体。

虽然食草动物和食肉动物都是属于动物，但是两者的属性和行为上有差别，所以子类会具有父类的一般特性也会具有自身的特性。

##### 继承代码实例
```java
class 父类 {
}

class 子类 extends 父类 {
}
```

---

#### 封装
在面向对象程式设计方法中，封装（Encapsulation）是指一种将抽象性函式接口的实现细节部份包装、隐藏起来的方法。

封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。

要访问该类的代码和数据，必须通过严格的接口控制。

封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。

适当的封装可以让程式码更容易理解与维护，也加强了程式码的安全性。

##### 封装的优点
1. 良好的封装能够减少耦合。
2. 类内部的结构可以自由修改。
3. 可以对成员变量进行更精确的控制。
4. 隐藏信息，实现细节。

##### 封装代码实例
```java
public class Person{
    private String name;
    private int age;
​
    public int getAge(){
      return age;
    }
​
    public String getName(){
      return name;
    }
​
    public void setAge(int age){
      this.age = age;
    }
​
    public void setName(String name){
      this.name = name;
    }
}
```

---

#### 抽象
在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

##### 抽象类代码实例
```java
public abstract class Animal {
    private String name;
    private int age;
    public abstract void shout();
}
```

---

### 如何用好面向对象(7大设计原则)
#### 单一职责原则
对类来说,一个类应该**只负责一项职责**。

##### 反例
```java
class DataAnalyser {
    public void analyzeData(Data data){
        if (点式数据) {
            处理点式数据...
        } else if (状态数据) {
            处理状态数据....
        } else {
            .....
        }
    }
}
```

##### 正例
```java
abstract class DataAnalyser{
    public abstract void analyzeData(Data data);
}

class PointDataAnalyser{
    public void analyzeData(Data data){
        // 处理点式数据
    };
}

class StatusDataAnalyser {
    public void analyzeData(Data data){
        // 处理状态数据
    };
}

....

```

----

#### 接口隔离原则
客户端**不应该依赖它不需要的接口**，即一个类对另一个类的依赖应该建立在最小的接口上

**通俗解释:** 尽量将接口的方法按照功能拆分。

##### 反例
```java
interface DataAnalyser {
    void analyzeData(Data data);

    void saveData(Data data);
}
```

##### 正例
```java
interface DataAnalyser {
    void analyzeData(Data data);
}

interface DataDao {
    void saveData(Data data);
}
```

---

#### 依赖倒置原则
高层模块不应该依赖低层模块，二者都应该依赖其抽象

抽象不应该依赖细节，细节应该依赖抽象

依赖倒转(倒置)的中心思想是面向接口编程

**通俗解释:** 面向接口编程。

##### 反例
```java
class PointDataAnalyser{
    public void analyzeData(Data data){
        // 处理点式数据
    };
}

class StatusDataAnalyser {
    public void analyzeData(Data data){
        // 处理状态数据
    };
}

class DataAnalyserProcessor {
    private PointDataAnalyser pointDataAnalyser = new PointDataAnalyser();
    private StatusDataAnalyser statusDataAnalyser = new StatusDataAnalyser();

    public void analyzerData(Data data) {
        if(pointDataAnalyser.analyzeData() == '成功'){
            return;
        } else {
            statusDataAnalyser.analyzeData();
        }
    }
}
```

##### 正例
```java
interface DataAnalyser {
    void analyzeData(Data data);
}
class PointDataAnalyser implements DataAnalyser{
    public void analyzeData(Data data){
        // 处理点式数据
    };
}

class StatusDataAnalyser implements DataAnalyser{
    public void analyzeData(Data data){
        // 处理状态数据
    };
}

class DataAnalyserProcessor {
    private List<DataAnalyser> dataAnalysers = new ArrayList<>();

    public void registerDataAnalyser(DataAnalyser dataAnalyser){
        ...
    }

    public void analyzerData(Data data) {
        for(DataAnalyser analyser : dataAnalysers){
            if(analyser.analyzeData() == '成功'){
                return;
            } else {
                continue;
            }
        }
    }
}
```

---

#### 里氏替换原则
所有引用**基类**的地方必须能**透明地使用其子类**的对象。

**通俗解释:** **尽量不要重写父类已经实现的方法**,如果必须要使用到父类已实现的方法,
    可以使用**聚合、组合**的方式**代替继承**。

##### 反例
```java
class PointDataAnalyser {
    public void analyzeData(Data data) {
        // 分析点式数据
    }
}

class PointDataAnalyserWarpper extends PointDataAnalyser{
    public void analyzeData(Data data) {
        // 分析点式数据
        // 保存点式数据导数据库
    }
}
```

##### 正例
```java
class PointDataAnalyser {
    public void analyzeData(Data data) {
        // 分析点式数据
    }
}

class PointDataAnalyserWarpper {
    private PointDataAnalyser pointDataAnalyser = new PointDataAnalyser();
    public void analyzeDataAndSave(Data data) {
        // 分析点式数据
        pointDataAnalyser.analyzeData();
        // 保存点式数据导数据库
        saveData();
    }
}
```

---

#### 开闭原则
对**扩展开放**,对**修改封闭**

**通俗解释:** 扩充功能时尽量不修改原来的代码,而是通过添加的方式来扩充功能。

 **遵循其他的原则是做到开闭原则的基础。**

---

#### 迪米特法则
又叫**最少知道原则**,即一个类对自己依赖的类知道的越少越好。也就是说，对于被依赖的类
    不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的`public`方法，不对外泄露任
    何信息。

**通俗解释:** 只与直接的朋友通信。

**直接朋友**
我们称出现在类A中的**成员变量**，**方法参数**， **方法返回值**为类A的直接朋友，而出现在**局部变量中的类不是直接的朋友**。也就是说，陌生的类最好不要以局部变量的形式出现在类的内部。

##### 反例
```java
class DataAnalyser {
    public void analyzeData(Data data){
        DataDao dao = new DataDao();
        dao.xxx();
    }
}
```

##### 正例
```java
class DataAnalyser {
    private DataDao dao;
    public void analyzeData(Data data){
        dao.xxx();
    }
}
```

---

#### 合成复用原则
原则是尽量使用**合成**, **聚合**的方式，而**不是使用继承**

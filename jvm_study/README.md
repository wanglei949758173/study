# 1. 类加载器
**说明:** 在JAVA代码中，类型的加载、连接与初始化过程都是在程序运行期间完成的。
提供了更大的灵活性，增加了更多的可能性。
* **java虚拟机与程序的生命周期**
    + 在以下几种情况下，java虚拟机将结束生命周期
      + 执行力`System.exit()`方法
      + 程序正常执行结束
      + 程序在执行过程中遇到了异常或错误而异常终止
      + 由于操作系统出现错误而导致java虚拟机进程终止

## 1.1 类加载、连接、初始化的过程
* **加载:** 查找并加载类的二进制数据
* **连接：**
	+ **验证：** 确保被加载的类的正确性
	+ **准备：** 为类的**静态变量**分配内存，并将其初始化为**默认值**
    	```java
    	class Test {
    		public static int a = 1;
    	}
    	// 在准备阶段会给a赋值为0
    	```
	+ **解析：** **把类中的符号引用转换为直接引用**
* **初始化：**为类的**静态变量**赋予正确的**初始值**
  ```java
	class Test {
		public static int a = 1;
	}
	// 在初始化阶段会给a赋值为1
	```
* **初始化延伸**
  + **类的初始化步骤**
    + 假如这个类还没有被加载和连接，那么就先进行加载和连接
    + 假如类存在直接父类，并且这个父类还没有被初始化，那就先初始化直接父类
    + 假如类中存在初始化语句，那么就依次执行这些初始化语句
  + **Java程序对类的使用方式分为两种：**
	  + 主动使用
  	+ 被动使用
 + 所有的Java虚拟机实现必须在每个类或接口被Java程序”**首次主动使用**“时才**初始化**他们
	+ 主动使用(7种)
		+ 创建类的实例
		+ 访问某个类或接口的静态变量，或者对该静态变量赋值 `getstatic` `putstatic`
		+ 调用类的静态方法	`invokestatic`
		+ 反射
		+ 初始化一个类的子类
		+ JAVA虚拟机启动时被标明为启动类的类 (main()方法的类)
		+ JDK1.7开始提供动态语言支持:`java.lang.invoke.MethodHandle`实例的解析结果`REF_getStatic`,`REF_putStatic`,`EF_invokeStatic`句柄对应的类没有初始化，则初始化
	+ 示例
	    + `子类.父类静态变量`不会导致子类的初始化,`子类.子类静态变量`会导致子类和父类都初始化，并且先初始化父类
    	    ```java
    	    public class MyTest1 {
                public static void main(String[] args) {
                    // System.out.println(MyChild1.str); // MyChild1不初始化静态代码块不执行 MyParent1初始化，静态代码块执行

                    System.out.println(MyChild1.str2); // MyChild初始化，所有的父类也都初始化
                }
            }

            class MyParent1 {
                public static String str = "hello world";

                static {
                    System.out.println("MyParent1 static block");
                }
            }

            class MyChild1 extends MyParent1 {
                public static String str2 = "welcome";

                static {
                    System.out.println("MyChild1 static block");
                }
            }
    	    ```
	    + 调用`类A.常量`不会导致**A类**的初始化
    	    ```java
    	    public class MyTest2 {
                public static void main(String[] args) {
                    /**
                     * 助记符：
                     *  ldc表示将int,float或是String类型的常量值从常量池中推送至栈顶
                     *  bipush表示将单字节（-128-127）的常量值推送至栈顶byte int push
                     *  sipush表示将一个短整形常量值(-32768 - 32767)推送至栈顶 short int push
                     *  iconst_1表示将int类型1推送至栈顶 (iconst_m1(-1) - iconst_5)
                     */
                    System.out.println(MyParent2.str);
                }
            }

            class MyParent2 {
                /**
                 * 常量在编译阶段会存存入到调用这个常量的方法所在的类的常量池中
                 * 本质上，调用类并没有直接引用到定义常量的类，因此并不会触发定义常量类的初始化
                 * 注意：这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与MyParent2就没有任何关系了
                 * 甚至，我们可以将MyParent2的class文件删除
                 */
                public static final String str = "hello world";

                public static final short s = 7;

                public static final int i = 128;

                public static final int m = 5;

                static {
                    System.out.println("Myparent2 static block");
                }
            }
    	    ```
    	+ 调用`A类.常量`，如果**常量**在编译期不可以确定，则会导致**A类初始化**
    	    ```java
    	    public class MyTest3 {
                public static void main(String[] args) {
                    /**
                     * 当一个常量的值并非编译期间可以确定的，那么其值就不会被放到调用类的常量池中，
                     * 这时在程序运行时，会导致主动使用这个常量所在的类，显然会导致这个类被初始化
                     */
                    System.out.println(MyParent3.str); // MyParent3静态代码块执行
                }
            }

            class MyParent3 {
                public static final String str = UUID.randomUUID().toString();

                static {
                    System.out.println("MyParent3 static block");
                }
            }
    	    ```
    	+ `new A[1]`的方式**不会导致类A的初始化**
    	    ```java
    	    public class MyTest4 {
                public static void main(String[] args) {
                    /**
                     * 对于数组实例来说，其类型是由JVM在运行期动态生成的，表示为[Lxx.xx.xx.xx这种形式。
                     * 动态生成的类型，其父类就是Object
                     *
                     * 对于数组来说，JavaDoc经常讲构成数组的元素称为Component，实际上是将数组降低一个维度后的类型。
                     *
                     * 助记符：
                     *  anewarray:表示创建一个引用类型的(如类、接口、数组)数组，并将其引用值压入栈顶
                     *  newarray:表示创建一个指定的原始类型(如int、float、char等)的数组，并将其引用值压入栈顶
                     */
                    MyParent4 myParent4 = new MyParent4(); // 静态代码执行

                    MyParent4[] myParent4s = new MyParent4[1]; // 静态代码块不执行
                    System.out.println(myParent4s.getClass());
                    System.out.println(myParent4.getClass().getSuperclass());

                    MyParent4[][] myParent4s1 = new MyParent4[1][1]; // 静态代码块不执行
                    System.out.println(myParent4s1.getClass());
                    System.out.println(myParent4s1.getClass().getSuperclass());

                    System.out.println("====================");
                    int[] ints = new int[1];
                    System.out.println(ints.getClass());
                }
            }

            class MyParent4 {
                static {
                    System.out.println("MyParent4 static block");
                }
            }
    	    ```
    	+ **子接口**或**子类**的初始化都**不会导致父接口的初始化**
    	    ```java
    	    public class MyTest5 {
                public static void main(String[] args) {
                    /*
                        当一个接口在初始化时，并不要求其父接口都完成了初始化
                        只有在真正使用到父接口的时候（如引用接口中所定义的常量时），才会初始化
                     */
                    System.out.println(MyChild5.b); // 不会导致MyParent5的初始化

                    /*
                        当一个类在初始化时，也不要求其父接口都完成初始化
                     */
                    System.out.println(MyChild5_c.c); // 不会导致MyParent5的初始化
                }
            }

            interface MyParent5 {
                public static final Thread thread = new Thread() {
                    {
                        System.out.println("MyParent5 invoked");
                    }
                };
            }

            interface MyChild5 extends MyParent5 {
                public static final int b = 5;
            }

            class MyChild5_c implements MyParent5 {
                public static int c = 10;
            }
    	    ```
    	+ 类的初始化为静态变量赋值是从上到下一行行执行的，如果静态变量定义在构造函数下，
      则构造函数会先执行，为静态变量赋值会后执行
    	    ```java
    	    public class MyTest6 {
                public static void main(String[] args) {
                    Singleton singleton = Singleton.getInstance();

                    System.out.println("counter1:" + Singleton.counter1); // 1
                    System.out.println("counter2:" + Singleton.counter2); // 0
                }
            }
            class Singleton {
                public static int counter1;

                private static Singleton singleton = new Singleton();

                private Singleton() {
                    counter1++;
                    counter2++; // 准备阶段的重要意义

                    System.out.println(counter1); // 1
                    System.out.println(counter2); // 1
                }

                public static int counter2 = 0;

                public static Singleton getInstance() {
                    return singleton;
                }
            }
    	    ```
    	+ 调用`A.静态常量`不会导致类A的初始化
    	    ```java
    	    class FinalTest {
                public static final int x = 3;

                static {
                    System.out.println("Final Test static block");
                }
            }

            public class MyTest8 {
                public static void main(String[] args) {
                    System.out.println(FinalTest.x); // 3 不会导致FinalTest类的初始化
                }
            }
    	    ```
    	+ 初始化子类时会先初始化父类
    	    ```java
    	    class Parent {
                static int a = 3;

                static {
                    System.out.println("Parent static block");
                }
            }

            class Child extends Parent {
                static int b = 4;

                static {
                    System.out.println("Child static block");
                }
            }

            public class MyTest9 {

                static {
                    System.out.println("MyTest9 static block");
                }

                public static void main(String[] args) {
                    System.out.println(Child.b);
                    /*
                        MyTest9
                        Parent
                        Child
                        4
                     */
                }
            }
    	    ```
    	+ 只声明而未实例化的类是不初始化的
    	    ```java
    	    class Parent2 {
                static int a = 3;

                static {
                    System.out.println("Parent2 static block");
                }
            }

            class Child2 extends Parent2 {
                static int b = 4;

                static {
                    System.out.println("Child2 static block");
                }
            }
            public class MyTest10 {
                static  {
                    System.out.println("MyTest10 static block");
                }

                public static void main(String[] args) {
                    Parent2 parent2;

                    System.out.println("----------------");

                    parent2 = new Parent2();

                    System.out.println("-------------");

                    System.out.println(parent2.a);

                    System.out.println("---------------");

                    System.out.println(Child2.b);

                    /*
                        MyTest10

                        Parent2
                        3

                        Child2
                        4
                     */
                }
            }
    	    ```
    	+ 子类引用父类的静态变量子类不会初始化
    	    ```java
    	    public class MyTest11 {
                public static void main(String[] args) {
                    System.out.println(Child3.a);//子类不会初始化
                    Child3.doSomething();

                    /*
                        Parent3
                        3
                        do something
                     */
                }
            }

            class Parent3 {
                static int a = 3;

                static {
                    System.out.println("Parent3 static block");
                }

                static void doSomething() {
                    System.out.println("do something");
                }
            }

            class Child3 extends Parent3 {
                static {
                    System.out.println("Child3 static block");
                }
            }
    	    ```
    	+ 类加载不会导致类初始化，只有反射才会导致类初始化
    	    ```java
    	    class CL {
                static {
                    System.out.println("CL static block");
                }
            }

            public class MyTest12 {
                public static void main(String[] args) throws Exception {
                    ClassLoader loader = ClassLoader.getSystemClassLoader();

                    Class<?> clazz = loader.loadClass("jvm.study.classloader.CL");

                    System.out.println(clazz);

                    System.out.println("---------------------");

                    clazz = Class.forName("jvm.study.classloader.CL");

                    System.out.println(clazz);

                    /*
                        clazz
                        -------------
                        CL static block
                        clazz
                     */
                }
            }
    	    ```
* **类的加载**
  + **说明:** 类的加载指的是将.class文件中的二进制数据读入到内存中，将其放进方法区中，
  然后在内存中创建一个java.lang.Class对象(**规范并未说明Class对象位于哪里，
  HotSpot虚拟机将其放在了方法区中**)用来封装类在方法区内的数据结构。
  + **加载方式**
	  + 从本地系统中直接加载
	  + 通过网络下载.class文件
	  + 从zip，jar等归档文件中加载.class文件
	  + 从专有数据库中提取.class文件
    + **将Java源文件动态编译为.class文件**
  + **类加载器分类：**
    + **Java虚拟机自带的加载器**
    + 根类加载器（Bootstrap）
    + 扩展类加载器（Extension）
    + 系统（应用）类加载器（System/App）
  + **用户自定义的类加载器**
  	+ java.lang.ClassLoader的子类
  	+ 用户可以定制类的加载方式
  + **类加载时机**
    + 类加载器并不需要等到某个类被“首次主动使用”时再加载它。
    + JVM规范允许类加载器在预料某个类将要被使用时就预先加载它，
      如果在预先加载的过程中遇到了.class文件缺失或不存在的错误，
      类加载器必须在程序首次主动使用该类时才报告错误(**LinkageError错**误)。
      如果这个类一直没有被程序主动使用，那么**类加载器就不会报告错误**
  + **获得ClassLoader的途径**
    + 获得当前类的ClassLoader<br/>
		`clazz.getClassLoader();`
    + 获得当前线程上下文的ClassLoader<br/>
    `Thread.currentThred().getContextClassLoader();`
    + 获得系统的ClassLoader<br/>
    `ClassLoader.getSystemClassLoader();`
    + 获取调用者的ClassLoader<br/>
    `DriverManager.getCallerClassLoader();`
  + **双亲委托机制**
    + **说明:** 类加载用来把类加载到java虚拟机中。从JDK1.2版本开始，类的加载过程采用双亲委托机制，这种机制能更好地保证java平台的安全。在此委托机制中，除了java虚拟机自带的根类加载器以外，其余的类加载器都有且只有一个父类加载器。当java程序请求加载器loader1加载Sample类时，loader1首先委托自己的父加载器去加载Sample类，若父加载器能加载，则由父加载器完成加载任务，否则才由加载器loader1本身加载Sample类。
    + **命名空间**
      + 每个类加载器都有自己的命名空间；**命名空间由该加载器及所有的父加载器所加载的类组成**。
      + 在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类。
      + 在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类。
      + 同一个命名空间内的类是相互可见的。
      + 子加载器的命名空间包含所有父加载器的命名空间。因此由子加载器加载的类能看见父加载器加载
        的类。例如系统类加载器加载的类能看见根类加载器加载的类。
      + 由父加载器加载的类不能看见子加载器加载的类。
      + 如果类加载器之间没有直接或间接的父子关系，那么他们各自加载的类相互不可见。
    + **示例:**
      + JDK库的类由BootStrapClassLoader加载，程序员编写的类由AppClassLoader加载
          ```java
          public class MyTest7 {
              public static void main(String[] args) throws Exception {
                  Class<?> class1 = Class.forName("java.lang.String");
                  System.out.println(class1.getClassLoader()); // null 由BootstrapClassLoader加载

                  Class<?> class2 = Class.forName("jvm.study.classloader.C");
                  System.out.println(class2.getClassLoader());// sun.misc.Launcher$AppClassLoader@18b4aac2
              }
          }

          class C {

          }
          ```
      + 类加载器的结构
          ```java
          public class MyTest13 {
              public static void main(String[] args) {
                  ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                  System.out.println(classLoader);
                  // sun.misc.Launcher$AppClassLoader@18b4aac2

                  while (classLoader != null) {
                      classLoader = classLoader.getParent();

                      System.out.println(classLoader);
                  }
                  /*
                      sun.misc.Launcher$ExtClassLoader@1b6d3586
                      null
                   */
              }
          }
          ```
      + 获取类文件所在硬盘上位置
          ```java
          public class MyTest14 {
              public static void main(String[] args) throws IOException {
                  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

                  String resourceName = "jvm/study/classloader/MyTest13.class";

                  Enumeration<URL> urls = classLoader.getResources(resourceName);
                  while (urls.hasMoreElements()) {
                      URL url = urls.nextElement();
                      System.out.println(url);
                  }

                  System.out.println("-----------------");
              }
          }
          ```
      + 加载数组的类加载器是加载对应的数组元素的类加载器
          ```java
          public class MyTest15 {
              public static void main(String[] args) {
                  String[] strings = new String[2];
                  System.out.println(strings.getClass().getClassLoader()); // null BootstrapClassLoader

                  System.out.println("--------------------");

                  MyChild5[] myChild5s = new MyChild5[2];
                  System.out.println(myChild5s.getClass().getClassLoader()); // AppClassLoader

                  System.out.println("---------------------");

                  int[] ints = new int[2];
                  System.out.println(ints.getClass().getClassLoader()); // null
              }
          }
          ```
      + 自定义类加载器
          ```java
          public class MyTest16 extends ClassLoader {

              private String classLoaderName;

              private String path;

              public void setPath(String path) {
                  this.path = path;
              }

              private static final String fileExtension = ".class";

              public MyTest16(String classLoaderName) {
                  super(); // 将系统类加载器当做该类加载的父类加载器
                  this.classLoaderName = classLoaderName;
              }

              public MyTest16(ClassLoader parent, String classLoaderName) {
                  super(parent); // 显示指定该类加载器的父类加载器
                  this.classLoaderName = classLoaderName;
              }

              public MyTest16(ClassLoader parent) {
                  super(parent);
              }

              @Override
              public String toString() {
                  return "[" + this.classLoaderName + "]";
              }

              @Override
              protected Class<?> findClass(String className) {
                  System.out.println("findClass invoked!");
                  byte[] data = loadClassData(className);
                  return defineClass(className, data, 0, data.length);

              }

              private byte[] loadClassData(String className) {
                  byte[] data = null;
                  InputStream is = null;
                  ByteArrayOutputStream baos = null;

                  className = className.replace(".", "/");
                  try {
                      is = new FileInputStream(new File(this.path + className + fileExtension));
                      baos = new ByteArrayOutputStream();

                      int ch = 0;
                      while (-1 != (ch = is.read())) {
                          baos.write(ch);
                      }

                      data = baos.toByteArray();

                  } catch (Exception e) {
                      e.printStackTrace();
                  } finally {
                      try {
                          is.close();
                          baos.close();
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }

                  return data;
              }

              public static void test(ClassLoader classLoader) throws Exception {
                  Class<?> clazz = classLoader.loadClass("jvm.study.classloader.MyTest1");
                  Object object = clazz.newInstance();
                  System.out.println(object);
              }

              public static void main(String[] args) throws Exception {
                  MyTest16 loader1 = new MyTest16("loader1");
                  loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

                  Class<?> clazz1 = loader1.loadClass("jvm.study.classloader.MyTest1");
                  Object object1 = clazz1.newInstance();
                  System.out.println(clazz1.hashCode());
                  System.out.println(object1);
                  System.out.println();

                  // 测试类的卸载
                  loader1 = null;
                  clazz1 = null;
                  object1 = null;
                  System.gc();

                  //MyTest16 loader2 = new MyTest16("loader2");
                  //loader2.setPath("C:\\Users\\Administrator\\Desktop\\");
                  //Class<?> clazz2 = loader2.loadClass("jvm.study.classloader.MyTest1");
                  //Object object2 = clazz2.newInstance();
                  //System.out.println(clazz2.hashCode());
                  //System.out.println(object2);

              }
          }
          ```
      + 如果classpath中存在类A的字节码文件，那么自定义类加载器不会加载类A，而是由AppClassLoader加载类A
          ```java
          public class MyTest17 {
              public static void main(String[] args) throws Exception {
                  MyTest16 loader1 = new MyTest16("loader1");

                  Class<?> clazz = loader1.loadClass("jvm.study.classloader.MySample");
                  System.out.println("class: " + clazz.hashCode());

                  // 如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
                  // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会初始化MyCat类
                  Object object = clazz.newInstance();
              }
          }
          public class MySample {
              public MySample() {
                  System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

                  new MyCat();
              }
          }
          public class MyCat {
              public MyCat() {
                  System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());
              }
          }
          ```
      + 当classpath中不存在类A的字节码文件，就可以使用自定义的类加载器加载类A
          ```java
          public class MyTest17_1 {
              public static void main(String[] args) throws Exception {
                  MyTest16 loader1 = new MyTest16("loader1");
                  loader1.setPath("C:\\Users\\Administrator\\Desktop\\");

                  Class<?> clazz = loader1.loadClass("jvm.study.classloader.MySample");
                  System.out.println("class: " + clazz.hashCode());

                  // 如果注释掉该行，那么并不会实例化MySample对象，即MySample构造方法不会被调用
                  // 因此不会实例化MyCat对象，即没有对MyCat进行主动使用，这里就不会初始化MyCat类
                  Object object = clazz.newInstance();
              }
          }
          ```
      + 打印JVM自带的3个类加载器加载类的路径
          ```java
          public class MyTest18 {
              public static void main(String[] args) {
                  System.out.println(System.getProperty("sun.boot.class.path"));
                  System.out.println(System.getProperty("java.ext.dirs"));
                  // 我们所写的代码会被ide自动设置到classpath中
                  System.out.println(System.getProperty("java.class.path"));
              }
          }
          ```
      + 将自定义类加载器设置为系统(应用)类加载器
          ```java
          public class MyTest23 {
              public static void main(String[] args) {
                  System.out.println(System.getProperty("sun.boot.class.path"));
                  System.out.println(System.getProperty("java.ext.dirs"));
                  System.out.println(System.getProperty("java.class.path"));

                  /*
                      内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及他的Java平台类，
                      当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器，
                      这块特殊的机器码叫做启动类加载器(Bootstrap ClassLoader)

                      启动类加载器并不是Java类，而其他的加载器则都是Java类，
                      启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。

                      所有类加载器（除了启动类加载器）都被实现为Java类。不过，总归要有一个组件来加载第一个Java类加载器，
                      从而整个加载过程才能够被顺利进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。

                      启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等。

                      要将自定义的类加载器作为系统类加载器的条件
                          1.设置系统属性java.system.class.loader=com.xx.xx.A
                          2.自定义类加载器必须有一个构造函数为A(ClassLoader parent)，这个构造函数将被系统调用
                         注意:自定义类加载器作为系统类加载器时，其父委托加载器是AppClassLoader
                   */

                  System.out.println(ClassLoader.class.getClassLoader()); // null 因为由启动类加载器加载

                  // ExtClassloader和AppClassloader也是由BootstrapClassloader所加载的
                  System.out.println(Launcher.class.getClassLoader()); // null 因为由启动类加载器加载

                  System.out.println("---------------");
                  System.out.println(System.getProperty("java.system.class.loader"));// null

                  System.out.println(MyTest23.class.getClassLoader());// AppClassLoder
                  System.out.println(MyTest16.class.getClassLoader());// AppClassLoder

                  // java -Djava.system.class.loader=jvm.study.classloader.MyTest16 jvm.study.classloader.MyTest23
                  System.out.println(ClassLoader.getSystemClassLoader()); // jvm.study.classloader.MyTest16
              }
          }
          ```
      * 线程上下文类加载器的作用
          + 当高层(SPI)提供了统一接口让低层(厂商的实现)去实现，同时又要是**在高层加载（或实例化）低层的类**时，必须通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类。因为SPI由BootStrapClassLoader加载,而BootStrapClassLoader无法加载classpath下的类
          ```java
          public class MyTest24 {

              public static void main(String[] args) {
                  /*
                      当前类加载器(Current Classloader)
                          每个类都会使用自己的类加载器(即加载自身的类加载器)去加载自己所依赖的类，
                          如果ClassX引用了ClassY,那么ClassX的类加载器就会去加载ClassY(前提是ClassY尚未被加载)
                      线程上下文类加载器(Context Classloader)
                          线程上下文类加载器是从JDK1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
                          分别用来获取和设置线程上下文类加载器

                      如果没有通过setContextClassLoader(ClassLoadr cl)进行设置的话，线程将继承其父线程的上下文类加载器
                      Java应用运行时的初始线程的上下文类加载器是系统类加载器。在线程中运行的代码可以通过该类加载器来加载类与资源。

                      线程上下文类加载器的重要性：
                          SPI(Service Provider Interface)

                          父ClassLoader可以使用当前线程上下文类加载器(Thread.currentThread().getContextClassloader())所指定的classLoader来加载自己无法加载的类。
                          这就改变了父Classloader不能使用子Classloader或是与其没有直接父子关系的ClassLoader加载的类的情况，即改变了双亲委托模型。

                          线程上下文类加载器就是当前线程的Current ClassLoader。

                          在双亲委托模型下，类加载是由上至下的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是Java核心库所提供的，
                          而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自于不同的jar包(厂商提供)，Java的启动类加载器是不会加载其他来源
                          的jar包，这样传统的双亲委托模型就无法满足SPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器来实现对于
                          接口实现类的加载。

                   */
                  System.out.println(Thread.currentThread().getContextClassLoader()); // APPClassLoader
                  System.out.println(Thread.class.getClassLoader()); // null BootstrapClassloader
              }
          }
          ```
      + 线程上下文类加载器默认是系统类加载器
          ```java
          public class MyTest25 implements Runnable {
              private Thread thread;

              public MyTest25(){
                  this.thread = new Thread(this);
                  thread.start();
              }

              @Override
              public void run() {
                  ClassLoader classLoader = this.thread.getContextClassLoader();

                  this.thread.setContextClassLoader(classLoader);

                  System.out.println("Class: " + classLoader.getClass()); // APPClassLoader
                  System.out.println("Parent: " + classLoader.getParent().getClass()); // ExtClassLoader
              }

              public static void main(String[] args) {
                  new MyTest25();
              }
          }
          ```
      + ServiceLoader使用
          ```java
          public class MyTest26 {
              /*
                  线程上下文类加载器的一般使用模式(获取 - 使用 - 还原)

                  ClassLoader targetTccl = null; // new MyClassLoader();

                  ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

                  try {
                      Thread.currentThread().setContextClassLoader(targetTccl);
                      myMethod();
                  } finally {
                      Thread.currentThread().setContextClassLoader(classLoader);
                  }

                  myMethod里面则调用了Thread.currentThread().getContextClassLoader()，获取当前线程的上下文类加载器做某些事情。

                  如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的 (如果该依赖类之前没有被加载过的话)

                  ContextClassLoader的作用是为了破坏Java的类加载委托机制。

                  当高层提供了统一的接口让低层去实现，同时又要在高层加载 (或实例化) 低层的类时，就必须要通过线程上下文类加载器来
                  帮助高层的ClassLoader找到并加载该类。
               */
              public static void main(String[] args) {

                  /*
                      ServiceLoader主要用于加载 META-INF/services/ 目录下的文件名(如:java.sql.Driver)所对应的的服务实现者
                      (实现者位于文件中,如java.sql.Driver文件中的com.mysql.jdbc.Driver)
                   */
                  ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
                  Iterator<Driver> iterator = serviceLoader.iterator();

                  while (iterator.hasNext()) {
                      Driver driver = iterator.next();
                      System.out.println("driver: " + driver.getClass() + ",loader: " + driver.getClass().getClassLoader());
                  }

                  System.out.println("当前线程上下文类加载器: " + Thread.currentThread().getContextClassLoader()); // APPClassLoader

                  System.out.println("serviceLoader的类加载器: " + ServiceLoader.class.getClassLoader()); // null BootstrapClassLoader

              }
          }
          ```
      + SPI-JDBC-MySql示例
          ```java
          public class MyTest27 {
              public static void main(String[] args) throws Exception {
                  /*
                      注册JDBC的驱动(使用ServiceLoader加载驱动)
                          Class.forName加载并实例化Driver导致Driver静态代码块执行，进而导致DriverManager静态代码块执行，最终由ServiceLoader加载驱动
                   */
                  Class.forName("com.mysql.jdbc.Driver");

                  /*
                      遍历所有加载的驱动尝试连接数据库，哪一个连接成功了就返回哪一个的连接。
                          使用Driver获取connection前，会判断加载Driver的类加载器和当前调用getConnection方法的类对应的类加载器是否为同一个类加载器(类加载器命名空间相同)，
                          如果不是一个类加载器就会产生问题，因为不同类加载器加载同一个类，jvm会认为是不同的类。

                   */
                  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
              }
          }
          ```
        + **类加载器的双亲委派模型的好处：**
    		+ 可以确保Java核心库的类型安全：所有的Java应用都至少会引用`Java.lang.Object`类，也就是说在运行期，java.lang.Object这个类会被加载到Java虚拟机中；如果这个加载过程是由Java应用自己的类加载器所完成的，那么很可能会在JVM中存在多个版本的`java.lang.Object`类，而且这些类之间还是不兼容的，相互不可见的(正是命名空间在发挥着作用)。借助于双亲委派机制，Java核心类库中的类的加载工作都是由启动类加载器来统一完成，从而确保了Java应用所使用的都是同一个版本的Java核心类库，他们之间是相互兼容的。
    		+ 可以确保Java核心类库所提供的类不会被自定义的类所替代。
    		+ 不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的类加载器来加载他们即可。不同类加载器所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个又一个相互隔离的Java类空间，这类技术在很多框架中都得到了实际应用。
* **类的卸载**
    **说明:**
        当MySample类被加载、连接和初始化后，它的生命周期就开始了。当代表MySample类的Class对象不再被引用，即不可触及时，Class对象就会结束生命周期，MySample类在方法区内的数据也会被卸载，从而结束MySample类的生命周期。
        **一个类何时结束生命周期，取决于代表它的Class对象何时结束生命周期**。
    	由Java虚拟机自带的类加载器所加载的类，在虚拟机的生命周期中，始终不会被卸载。
    	由用户自己定义的类加载器所加载的类时可以被卸载的。
* **类的生命周期**
    + **加载:** 就是把二进制形式的java类型读入到Java虚拟机中
    + **验证:**
    + **准备:** 为类变量(静态变量)分配内存，设置默认值。但是在到达初始化之前，类变量都没有初始化为真正的初始值
    + **解析:** 解析过程就是在类型的常量池中寻找类、接口、字段和方法的符号引用，把这些符号引用替换成直接引用的过程
    + **初始化:** 为类变量赋予正确的初始值
    + **类实例化:**
        + 为新的对象分配内存
        + 为实例变量赋默认值
        + 为实例变量赋正确的初始值
        + java编译器为它编译的每一个类都至少生成一个实例初始化方法，在java的class文件中，这个实例初始化方法被称为“<init>”。针对源代码中每一个类的构造方法，java编译器都产生一个<init>方法
    + **垃圾回收和对象终结**
    + **结束**
* **类的验证**
    + 类的验证的内容
        + 类文件的结构检查
        + 语义检查(abstract class 不能用final修饰等)
        + 字节码验证(魔数的验证等)
        + 二进制兼容性的验证(老版本编译器编译的字节码可以由新版本的JVM执行，反之则不行)
* **虚拟机参数**
    ```
    -XX:+TraceClassLoading
	-XX:+<option>：表示开启option选项
	-XX:-<option>：表示关闭option选项
	-XX:<option>=<value>：表示将option选项的值设置为value
    ```
    ---
# Java字节码文件结构
* 查看字节码文件内容:
    + `javap`
    + `javap -c`
    + `javap -verbose`
    使用`javap -verbose`命令分析一个字节码文件时，将会分析该字节码文件的**魔数**、**版本号**、**常量池**、**类信息**、**类的构造方法**、**类中的方法信息**、**类变量**与**成员变量**等信息。
* **字节码结构**
    ```
    ClassFile {
    	u4						magic;
    	u2						minor—version;
    	u2						major_version;
    	u2						constant_pool_count;
    	cp_info					contant_pool[constant_pool_count - 1];
    	u2						access_flags;
    	u2						this_class;
    	u2						super class;
    	u2						interfaces_count;
    	interface_info			interfaces(interfaces_count];
    	u2						fields_count;
    	field_info				fields[fields_count];
    	u2						methods_count;
    	method_info				methods[methods_count];
    	u2						attributes_count;
    	attribute_info			attributes[attributes_count];
    }
    ```
* **魔数**(4个字节)
    + 所有的.class字节码文件的前4个字节都是魔数
    + 魔数值为固定值:`0xCAFEBABE`
* **版本号**(2+2个字节)
    + 魔数之后的4个字节为版本信息
    + 前两个字节表示**minor version(次版本号)**
    + 后两个字节表示**major version(主版本号)**
        这里的版本号为`00 00 00 34`换算成十进制，表示次版本号为0，主版本号为52.所以，该文件的版本号为1.8.0。可以用`java -version`命令来验证这一点。
* **常量池(constant pool )**(2+n个字节)
    + 紧接着主版本号之后的就是常量池入口，前两个字节为常量池中的常量数量。
    **值得注意的是：**
        ```
        常量池数组中元素的个数 = 常量池数 - 1
        ```
        **其中0暂时不使用**目的是满足某些常量池索引值的数据在特定情况下需要**表达不引用任何一个常量池的含义**；根本原因在于，索引为0也是一个常量(保留常量)，只不过它不位于常量表中，这个常量就对应**null**值；所以，常量池的索引从1而非0开始。
    + 一个java类中定义的很多信息都是由常量池来维护和描述的，可以将常量池看做是**class文件的资源仓库**，比如说java类中定义的**方法**与**变量信息**，都是存储在常量池中。
    + 常量池中主要存储两类常量：
        + 字面量
            字面量如文本字符串，java中声明为final的常量值等
        + 符号引用
            符号引用如类和接口的全局限定名，字段的名称和描述符，方法的名称和描述符等等。
    + 常量池的总体结构:
        java类所对应的常量池主要由**常量池数量**与**常量池数组**(常量表)这两部分组成
        + **常量池数量：** 紧跟在主版本号后面，占据2个字节
        + **常量池数组：**    紧跟在常量池数量之后。常量池数组与一般的数组不同的是，**常量池数组中的元素类型并不相同**、结构都是不同的，长度当然也就不同；但是，每一种元素的第一个数据都是u1类型，该字节是个标志位，占据1个字节。JVM在解析常量池时，**会根据这个u1类型来获取元素的具体类型**。
    + 常量池中数据类型的结构表
        <table>
            <thead>
                <tr>
                    <th>常量</th>
                    <th>项目</th>
                    <th>类型</th>
                    <th>描述</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="3">CONSTANT_Utf8_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为1</td>
                </tr>
                <tr>
                    <td>length</td>
                    <td>u2</td>
                    <td>UTF-8编码的字符串长度</td>
                </tr>
                <tr>
                    <td>bytes</td>
                    <td>u1</td>
                    <td>长度为length的UTF-8编码的字符串</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_Integer_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为3</td>
                </tr>
                <tr>
                    <td>bytes</td>
                    <td>u4</td>
                    <td>按照高位在前存储的int值</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_Float_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为4</td>
                </tr>
                <tr>
                    <td>bytes</td>
                    <td>u4</td>
                    <td>按照高位在前存储的float值</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_Long_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为5</td>
                </tr>
                <tr>
                    <td>bytes</td>
                    <td>u8</td>
                    <td>按照高位在前存储的long值</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_Double_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为6</td>
                </tr>
                <tr>
                    <td>bytes</td>
                    <td>u8</td>
                    <td>按照高位在前存储的double值</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_Class_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为7</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向全限定名常量项的索引</td>
                </tr>
                <tr>
                    <td rowspan="2">CONSTANT_String_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为8</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向字符串字面量的索引</td>
                </tr>
                <tr>
                    <td rowspan="3">CONSTANT_Fieldref_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为9</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向字段的类或接口的描述符CONSTANT_Class_info的索引项</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向字段描述符CONSTANT_NameAndType_info的索引项</td>
                </tr>
                <tr>
                    <td rowspan="3">CONSTANT_Methodref_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为10</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向声明方法的类描述符CONSTANT_Class_info的索引项</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向名称及类型描述符CONSTANT_NameAndType_info的索引项</td>
                </tr>
                <tr>
                    <td rowspan="3">CONSTANT_InterfaceMethodref_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为11</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向声明方法的接口描述符CONSTANT_Class_info的索引项</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向名称及类型描述符CONSTANT_NameAndType_info的索引项</td>
                </tr>
                 <tr>
                    <td rowspan="3">CONSTANT_NameAndType_info</td>
                    <td>tag</td>
                    <td>u1</td>
                    <td>值为12</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向该字段或方法名称常量项的索引</td>
                </tr>
                <tr>
                    <td>index</td>
                    <td>u2</td>
                    <td>指向该字段或方法描述符常量项的索引</td>
                </tr>
            </tbody>
        </table>
    + 在JVM规范中，每个变量/字段都有描述信息，描述信息主要的作用是描述字段的数据类型、方法的参数列表(包括数量、类型与顺序)与返回值。根据描述符规则，基本数据类型和代表无返回值的void类型都用一个大写字符来表示，对象类型则使用字符L加对象的全限定名称来表示。为了压缩字节码文件的体积，对于基本数据类型，JVM都只使用一个大写字母来表示，如下所示:
        ```
        B - byte
        C - char
        D - double
        F - float
        I - int
        J - long
        S - short
        z - boolean
        V - void
        L - 对象类型，如Ljava/lang/String;
        ```
    + 对于数组类型来说，每一个维度使用一个前置的`[`来表示，如`int[]`被记录为`[I`,`String[][]`被记录为`[[Ljava/lang/String`;
用描述符描述方法时，按照先参数列表，后返回值的顺序来描述。参数列表按照参数的严格顺序放在一组()之内。具体示例如下:
        ```java
        // 描述符为:(I ,Ljava/lang/String)Ljava/lang/String;
        String getRealNameByIdAndNickname(int id,String name)

        // 描述符为:a:I
        private int a;

        // 描述符为<init>:()V
        public MyTest(){

        }
        ```
* **访问标志(Access Flags)** 2个字节
    <table>
        <thead>
            <tr>
                <th>标志名称</th>
                <th>值</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>ACC-PRIVATE</td>
                <td>0X0002</td>
            </tr>
            <tr>
                <td>ACC-PUBLIC</td>
                <td>0X0001</td>
            </tr>
            <tr>
                <td>ACC-FINAL</td>
                <td>0X0010</td>
            </tr>
            <tr>
                <td>ACC-SUPER</td>
                <td>0X0020</td>
            </tr>
            <tr>
                <td>ACC-INTERFACE</td>
                <td>0X0200</td>
            </tr>
            <tr>
                <td>ACC-ABSTRACT</td>
                <td>0X0400</td>
            </tr>
            <tr>
                <td>ACC-synthetic(合成的,源代码中没有此关键字)</td>
                <td>0X1000</td>
            </tr>
            <tr>
                <td>ACC-annotation</td>
                <td>0X2000</td>
            </tr>
            <tr>
                <td>ACC-ENUM</td>
                <td>0X4000</td>
            </tr>
        </tbody>
    </table>
```
访问标志在字节码中的值 = 对应的被修饰对象(类、方法、或属性)的所有访问控制符相加的值
```
* **当前类名字(This Class Name)** 2个字节
    指向常量池中的索引
* **父类名字(Super Class Name)** 2个字节
    指向常量池中的索引
* **实现的接口(Interfaces)** 2+n个字节
    前两个字节:实现的接口数
    n:n个接口的名字
* **成员变量(Fields)** 2+n个字节
    **包含静态变量**
    * 字段信息结构
    ```
    field_info {
    	u2 agcess_flags;
    	u2 name_index;
    	u2 descriptor_index;
    	u2 attributes_count;
    	attribute_info attributes[attributes_count];
    }
    ```
* **方法(Methods)** 2+n个字节
    常量Code代表方法执行的指令
    jclasslib
    attribute_info JVM给方法添加的附加信息
* **附加属性(Attributes)**2+n个字节
1、魔数:CAFEBABE
2、次版本号:0
3、主版本号:52 代表1.8
4、常量池数量:24 实际常量池数量24-1=23
5、#1: 7 Class_Info 指向#2
6、#2：1 UTF8_Info 长度26 jvm/study/bytecode/MyTest1
7、#3: 7 Class_Info 指向#4
8、#4: 1 UTF8_Info 长度16 java/lang/Object
9、#5: 1 UTF8_Info 长度1 a
10、#6: 1 UTF8_Info 长度1 I
11、#7: 1 UTF8_Info 长度6 <init>
12、#8: 1 UTF8_Info 长度3 ()V
13、#9：1 UTF8_Info 长度4 Code
14、#10: 10 Methodref_Info 声明方法的类的索引:#3,Name_And_Type的索引:#11
15、#11: 12 NameAndType_Info Name索引:#7,Type索引:#8
16、#12: 1 UTF8_Info 长度15 LineNumberTable
17、#13: 1 UTF8_Info 长度18 LocalVariableTable
18、#14: 1 UTF8_Info 长度4 this
19、#15: 1 UTF8_Info 长度28 Ljvm/study/bytecode/MyTest1;
20、#16: 1 UTF8_Info 长度4 getA
21、#17: 1 UTF8_Info 长度3 ()I
22、#18: 9 Fieldref_Info 类型:指向#1 NameAndType：指向19
23、#19: 12 NameAndType_Info Name索引:#5,Type索引:#6
24、#20: 1 UTF8_Info 长度4 setA
25、#21: 1 UTF8_Info 长度4 (I)V
26、#22: 1 UTF8_Info 长度10 SourceFile
27、#23: 1 UTF8_Info 长度12 MyTest1.java
28、访问控制符；0x21 ACC_Super + ACC_Public
29、当前类名字； 指向#1 jvm/study/bytecode/MyTest1
30、父类名字: 指向#3 java/lang/Object
31、实现接口数量；0
32、成员变量个数；1
33、成员变量访问控制符；0x0002 private
34、成员变量name索引: 指向#5 a
35、成员变量描述信息索引: 指向#6 I
36、成员变量附加属性个数: 0

# c#基础
## 占位符的使用
  ```csharp
  Console.WriteLine("{0}+{1}={2}",3,4,7);// 输出3+4=7
  ```
## visual studio显示行号
  工具 -> 选项 -> 文本编辑器 -> c# -> 显示 -> 行号
## 字符串
  ```csharp
  // 使用@表示默认不把\当做转义符
  string a = @"c:\users\zhangsan\hello.jpg";
  Console.WriteLine(a);
  ```
## Convert
    ```csharp
    Console.WriteLine("请输入第一个数字");
    String num1 = Console.ReadLine();
    int num1Int = Convert.ToInt32(num1);

    Console.WriteLine("请输入第二个数字");
    String num2 = Console.ReadLine();
    int num2Int = Convert.ToInt32(num2);

    Console.WriteLine("{0} + {1} = {2}", num1Int, num2Int, num1Int + num2Int);

    Console.ReadKey();
    ```
## c#函数中的局部变量在使用前必须赋值
## 属性
* 属性的作用是保护字段
## 命名空间
`ctrl+shift+f10`导入命名空间
## 继承
  * 继承演示
    ```csharp
    class Person
      {
          private String name;
          private int age;

          public int Age { get => age; set => age = value; }
          public string Name { get => name; set => name = value; }

          public void SayHello()
          {
              Console.WriteLine("hello");
          }
      }

      class Student : Person
      {
          private String school;

          public string School { get => school; set => school = value; }

          public void SayHello(String teacher)
          {
              if ("校长".Equals(teacher))
              {
                  Console.WriteLine("hello 校长");
              } else
              {
                  base.SayHello();
              }
          }
      }
    ```
  * base关键字
    ```csharp
    // base相当于java中的super
    class Student : Person
      {
          private String school;

          public string School { get => school; set => school = value; }

          public void SayHello(String teacher)
          {
              if ("校长".Equals(teacher))
              {
                  Console.WriteLine("hello 校长");
              } else
              {
                  // base关键字
                  base.SayHello();
              }
          }
      }
    ```
  * 方法重写
    ```csharp
    public new void SayHello()
    {
        base.SayHello();
        Console.WriteLine("子类的SayHello()");
    }
    ```
  * 访问控制符
    + internal:表示只能在当前项目中访问,类的默认访问修饰符就是internal
  * 强制转换
    ```csharp
    Person person = new Student();
    // is 判断一个对象是否是某个类型，和java中的instanceof类似
    if (person is Student)
    {
        Student s = (Student)person;
        s.SayHello();
        Console.WriteLine("person is student");
    }
    // as 将一个对象强制转换为另一个类型，转换失败返回null，转换成功则返回转换后的对象
    Student s2 = person as Student;
    if (s2 == null)
    {

    }
    else
    {
        s2.SayHello();
    }
    ```

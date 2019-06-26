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

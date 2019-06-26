using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class HelloWorld
    {
        static void Main(string[] args)
        {
            Console.WriteLine("HelloWorld");

            String boy = Console.ReadLine();
            String girl = Console.ReadLine();
            // 占位符 0 和 1 对应参数的位置
            Console.WriteLine("{0} Love {1}", boy, girl);

            Console.ReadKey();
        }
    }
}

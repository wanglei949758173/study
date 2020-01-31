using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestString
{
    class Program
    {
        static void Main(string[] args)
        {
            // 使用@表示默认不把\当做转义符
            string a = @"c:\users\zhangsan\hello.jpg";
            Console.WriteLine(a);

            Console.ReadKey();
        }
    }
}

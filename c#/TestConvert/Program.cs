using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestConvert
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("请输入第一个数字");
            String num1 = Console.ReadLine();
            int num1Int = Convert.ToInt32(num1);

            Console.WriteLine("请输入第二个数字");
            String num2 = Console.ReadLine();
            int num2Int = Convert.ToInt32(num2);

            Console.WriteLine("{0} + {1} = {2}", num1Int, num2Int, num1Int + num2Int);

            Console.ReadKey();
        }
    }
}

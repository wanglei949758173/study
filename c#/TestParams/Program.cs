using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestParams
{
    /// <summary>
    /// 测试可变参数
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            printNickNames("zhangsan", "狗蛋", "老张", "小三");
            Console.ReadKey();
        }

        static void printNickNames(String realName, params String[] nickNames)
        {
            Console.WriteLine("{0}的昵称有:", realName);
            foreach (String nickName in nickNames)
            {
                Console.WriteLine("     {0}", nickName);
            }
        }
    }
}

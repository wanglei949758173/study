using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestEnum
{
    enum Gender
    {
        Male, Female
    }
    class Program
    {
        static void Main(string[] args)
        {
            Gender zhangsan = Gender.Male;
            Gender xiaohong = Gender.Female;

            String[] names = {"zhangsan", "lisi", "wangwu"};
            foreach(String name in names)
            {
                Console.WriteLine(name);
            }

            Console.ReadKey();
        }
    }
}

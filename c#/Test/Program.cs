using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Test
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
            int j = 0;
            Console.WriteLine(++i == 1);
            Console.WriteLine(j++ == 1);
            Console.ReadKey();
        }
    }
}

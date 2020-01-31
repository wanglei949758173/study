using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 售货程序
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            SuperMarket superMarket = new SuperMarket();
            superMarket.AskBuying();

            Console.ReadKey();
        }
    }

}

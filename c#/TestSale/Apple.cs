using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 啤酒
    /// </summary>
    class Apple : ProductFather
    {
        public Apple(string id, string name, double price) : base(id, name, price)
        {
        }
    }
}

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
    class Beer : ProductFather
    {
        public Beer(string id, string name, double price) : base(id, name, price)
        {
        }
    }
}

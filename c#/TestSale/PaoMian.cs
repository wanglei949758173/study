using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 泡面
    /// </summary>
    class PaoMian : ProductFather
    {
        public PaoMian(string id, string name, double price) : base(id, name, price)
        {
        }
    }
}

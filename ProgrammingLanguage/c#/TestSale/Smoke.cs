using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 香烟
    /// </summary>
    class Smoke : ProductFather
    {
        public Smoke(string id, string name, double price) : base(id, name, price)
        {
        }
    }
}

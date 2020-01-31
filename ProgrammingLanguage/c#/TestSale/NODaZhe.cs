using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 不打折类
    /// </summary>
    class NODaZhe : DaZheFather
    {
        public override double GetMoney(double totalMoney)
        {
            return totalMoney;
        }
    }
}

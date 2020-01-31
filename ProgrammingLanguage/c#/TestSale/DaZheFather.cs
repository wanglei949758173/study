using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 打折父类
    /// </summary>
    abstract class DaZheFather
    {
        /// <summary>
        /// 打折
        /// </summary>
        /// <param name="totalMoney">总价格</param>
        /// <returns>打折后的价格</returns>
        public abstract double GetMoney(double totalMoney);
    }
}

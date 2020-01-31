using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 按照比率打折
    /// </summary>
    class DaZheRate : DaZheFather
    {
        private double rate;
        /// <summary>
        /// 折扣率
        /// </summary>
        public double Rate { get => rate; set => rate = value; }

        public override double GetMoney(double totalMoney)
        {
            return totalMoney * rate;
        }

        public DaZheRate(double rate)
        {
            this.rate = rate;
        }
    }
}

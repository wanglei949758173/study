using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 打折满减类
    /// </summary>
    class DaZheManJian : DaZheFather
    {
        private double man;

        private double jian;

        public double Jian { get => jian; set => jian = value; }
        public double Man { get => man; set => man = value; }

        public DaZheManJian(double man, double jian)
        {
            this.man = man;
            this.jian = jian;
        }

        public override double GetMoney(double totalMoney)
        {
            if (totalMoney >= this.man)
            {
                // 有多少个满送多少个减
                return totalMoney - (int)(totalMoney / this.man) * this.jian;
            }
            else
            {
                return totalMoney;
            }
        }
    }
}

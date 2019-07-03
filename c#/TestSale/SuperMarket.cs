using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 超市类
    /// </summary>
    class SuperMarket
    {
        Cangku ck = new Cangku();

        /// <summary>
        /// 在构造函数中给仓库添加货物
        /// </summary>
        public SuperMarket()
        {
            ck.JinHuo("Apple", 500);
            ck.JinHuo("Smoke", 300);
            ck.JinHuo("Beer", 200);
            ck.JinHuo("PaoMian", 2000);
        }

        public void AskBuying()
        {
            Console.WriteLine("欢迎光临xxx超市,请问您需要些什么?");

            Console.WriteLine("我们有 Apple Smoke Beer PaoMian");
            string input = Console.ReadLine();

            Console.WriteLine("请问您需要多少个?");
            int count = Convert.ToInt32(Console.ReadLine());

            // 取货
            ProductFather[] products = ck.QuHuo(input, count);

            // 开始算账
            double totalMoney = GetPrice(products);

            Console.WriteLine("请选择打折方式 1--不打折 2--打95折 3--打85折" +
                "  4--买300送50  5--买500送100");

            string s = Console.ReadLine();
            DaZheFather dz = GetDaZhe(s);
            if (dz != null)
            {
                double realMoney = dz.GetMoney(totalMoney);
                Console.WriteLine("您打折前应付{0}，打折后应付{1}", totalMoney, realMoney);

                // 打印小票信息
                Console.WriteLine("==================小票======================");
                foreach (ProductFather product in products)
                {
                    Console.WriteLine("商品名称:{0}----商品单价:{1}-----商品编号:{2}",
                        product.Name, product.Price, product.Id);
                }
            }

        }

        /// <summary>
        /// 根据用户的输入返回打折的父类
        /// </summary>
        /// <param name="s"></param>
        /// <returns></returns>
        static DaZheFather GetDaZhe(string s)
        {
            DaZheFather dz = null;
            switch (s)
            {
                case "1":
                    dz = new NODaZhe();
                    break;
                case "2":
                    dz = new DaZheRate(0.95);
                    break;
                case "3":
                    dz = new DaZheRate(0.85);
                    break;
                case "4":
                    dz = new DaZheManJian(300, 50);
                    break;
                case "5":
                    dz = new DaZheManJian(500, 100);
                    break;
            }
            return dz;
        }

        /// <summary>
        /// 算账
        /// </summary>
        /// <param name="products"></param>
        /// <returns></returns>
        private double GetPrice(ProductFather[] products)
        {
            double price = 0;
            foreach (ProductFather product in products)
            {
                price += product.Price;
            }
            return price;
        }
    }
}

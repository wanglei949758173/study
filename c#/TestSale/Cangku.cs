using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 仓库类
    /// </summary>
    class Cangku
    {
        // 仓库是货架的集合
        // 货架是商品的集合
        List<List<ProductFather>> list = new List<List<ProductFather>>();

        public Cangku()
        {
            // 添加4个货架
            list.Add(new List<ProductFather>()); // 存储Apple
            list.Add(new List<ProductFather>()); // 存储Smoke
            list.Add(new List<ProductFather>()); // 存储PaoMian
            list.Add(new List<ProductFather>()); // 存储Beer
        }
        /// <summary>
        /// 给仓库进货
        /// </summary>
        /// <param name="strType">货物的类型</param>
        /// <param name="count">货物的数量</param>
        public void JinHuo(string strType, int count)
        {
            for (int i = 0; i < count; i++)
            {
                switch (strType)
                {
                    case "Apple":
                        list[0].Add(new Apple(Guid.NewGuid().ToString(), "Apple", 1000));
                        break;
                    case "Smoke":
                        list[1].Add(new Smoke(Guid.NewGuid().ToString(), "Smoke", 10));
                        break;
                    case "PaoMian":
                        list[2].Add(new PaoMian(Guid.NewGuid().ToString(), "PaoMian", 50));
                        break;
                    case "Beer":
                        list[3].Add(new Beer(Guid.NewGuid().ToString(), "Beer", 4.5));
                        break;
                }

            }
        }
        /// <summary>
        /// 取货
        /// </summary>
        /// <param name="strType">取的货物类型</param>
        /// <param name="count">取的货物数量</param>
        /// <returns>返回取出的货物</returns>
        public ProductFather[] QuHuo(string strType,int count)
        {
            ProductFather[] products = new ProductFather[count];
            for (int i = 0; i < count; i++)
            {
                switch (strType)
                {
                    case "Apple":
                        products[i] = list[0][0];
                        list[0].RemoveAt(0);
                        break;
                    case "Smoke":
                        products[i] = list[1][0];
                        list[1].RemoveAt(0);
                        break;
                    case "PaoMian":
                        products[i] = list[2][0];
                        list[2].RemoveAt(0);
                        break;
                    case "Beer":
                        products[i] = list[3][0];
                        list[3].RemoveAt(0);
                        break;
                }
            }
            return products;
        }

    }
}

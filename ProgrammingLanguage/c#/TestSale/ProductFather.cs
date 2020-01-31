using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSale
{
    /// <summary>
    /// 商品父类
    /// </summary>
    class ProductFather
    {
        private string id;

        private string name;

        private double price;

        public string Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public double Price { get => price; set => price = value; }

        public ProductFather(string id, string name, double price)
        {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }
}

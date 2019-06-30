using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestCollection
{
    class Program
    {
        static void Main(string[] args)
        {
            #region 测试list
            // 测试List
            List<int> list = new List<int>();
            list.Add(3);
            list.Add(2);
            list.Add(6);
            list.Add(7);
            list.Add(5);
            int sum = 0;
            foreach (int i in list)
            {
                sum = i + sum;
            }
            float avg = sum / list.Count;
            Console.WriteLine("总和:{0}", sum);
            Console.WriteLine("平均值:{0}", avg);
            Console.WriteLine("----------------------");

            // 测试List.Insert()
            list.Insert(1, 99);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("----------------------");

            // 测试remove
            list.Remove(3);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("----------------------");

            // 测试removeAt()
            list.RemoveAt(2);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }
            Console.WriteLine("----------------------");

            // 测试clear()
            list.Clear();
            Console.WriteLine("list的元素个数:{0}", list.Count);
            Console.WriteLine("----------------------");
            #endregion

            #region 测试HashTable
            Hashtable table = new Hashtable();
            table.Add("name", "zhangsan");
            table.Add("age", 20);
            Console.WriteLine(table["name"]);
            Console.WriteLine(table["age"]);
            Console.WriteLine("----------------------");

            // 遍历Hashtable
            foreach (var item in table.Keys)
            {
                Console.WriteLine("key:{0},value:{1}", item, table[item]);
            }
            Console.WriteLine("----------------------");
            #endregion

            #region 测试Dictionary
            Dictionary<string, int> dictionary = new Dictionary<string, int>();
            dictionary.Add("zhangsan", 20);
            dictionary.Add("lisi", 18);
            dictionary.Add("wangwu", 26);
            foreach(KeyValuePair<string,int> keyValue in dictionary)
            {
                Console.WriteLine("{0}的年龄是{1}",keyValue.Key,keyValue.Value);
            }
            #endregion
            Console.ReadKey();
        }
    }
}

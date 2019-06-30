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
            // 测试ArrayList
            IList list = new ArrayList();
            list.Add(3);
            list.Add(2);
            list.Add(6);
            list.Add(7);
            list.Add(5);
            int sum = 0;
            foreach(int i in list)
            {
                sum = i + sum;
            }
            float avg = sum / list.Count;
            Console.WriteLine("总和:" + sum);
            Console.WriteLine("平均值:" + avg);

            Console.WriteLine("----------------------");


            list.Insert(1,99);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }

            Console.WriteLine("----------------------");
            list.Remove(3);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }

            Console.WriteLine("----------------------");
            list.RemoveAt(2);
            foreach (int i in list)
            {
                Console.WriteLine(i);
            }

            Console.WriteLine("----------------------");
            list.Clear();
            Console.WriteLine(list.Count);

            Console.WriteLine("----------------------");
            Hashtable table = new Hashtable();

            Console.ReadKey();
        }
    }
}

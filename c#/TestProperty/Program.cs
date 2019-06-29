using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestProperty
{
    class Program
    {
        static void Main(string[] args)
        {
            Student zhangsan = new Student();
            zhangsan.Name = "zhangsan";
            zhangsan.Age = 130;
            Console.WriteLine("{0}的年龄是{1}", zhangsan.Name, zhangsan.Age);
            Console.ReadKey();
        }
    }

    class Student
    {
        /// <summary>
        /// 名字
        /// </summary>
        private string name;

        /// <summary>
        /// 年龄
        /// </summary>
        private int age;

        public int Age
        {
            get { return age; }
            // value是隐式变量
            set
            {
                if (value <= 0 || value >= 120)
                {
                    this.age = 0;
                }
                else
                {
                    this.age = value;
                }

            }
        }

        public string Name
        {
            get { return this.name; }
            set { this.name = value; }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestInterface
{
    /// <summary>
    /// 测试接口
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student();
            student.F1();

            Console.WriteLine("---------------------");

            I2 i2 = new Student();
            i2.F1();

            Console.ReadKey();
        }
    }

    interface I1
    {
        void F1();
    }

    interface I2
    {
        void F1();
    }

    class Student : I1, I2
    {
        public void F1()
        {
            Console.WriteLine("I1的F1");
        }

        void I2.F1()
        {
            Console.WriteLine("I2的F1");
        }
    }
}

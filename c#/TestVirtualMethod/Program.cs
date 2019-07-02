using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestVirtualMethod
{
    /// <summary>
    /// 测试虚方法
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Student();
            person.SayHello();

            Console.ReadKey();
        }
    }
}

class Person
{
    public virtual void SayHello()
    {
        Console.WriteLine("I am Person");
    }
}

class Student : Person
{
    public override void SayHello()
    {
        Console.WriteLine("I am Student");
    }
}

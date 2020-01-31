using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestAbstract
{
    class Program
    {
        static void Main(string[] args)
        {
            Person person = new Student();
            person.Run();
            Console.ReadKey();
        }
    }
}

abstract class Person
{
    public abstract void Run();
    public void SayHello()
    {
        Console.WriteLine("Hello");
    }
}

class Student : Person
{
    public override void Run()
    {
        Console.WriteLine("student run.....");
    }
}

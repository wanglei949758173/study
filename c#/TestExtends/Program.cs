using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestExtends
{
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student();
            student.Name = "张三";
            student.Age = 26;
            student.School = "蓝翔";
            student.SayHello("校长");
            student.SayHello("张老师");
            Console.WriteLine("------------------------------");

            Person person = new Student();
            // is 判断一个对象是否是某个类型，和java中的instanceof类似
            if (person is Student)
            {
                Student s = (Student)person;
                s.SayHello();
                Console.WriteLine("person is student");
            }
            // as 将一个对象强制转换为另一个类型，转换失败返回null，转换成功则返回转换后的对象
            Student s2 = person as Student;
            if (s2 == null)
            {

            }
            else
            {
                s2.SayHello();
            }

            Console.ReadKey();
        }
    }

    /// <summary>
    /// Person类
    /// </summary>
    class Person
    {
        private String name;
        private int age;

        public int Age { get => age; set => age = value; }
        public string Name { get => name; set => name = value; }

        public void SayHello()
        {
            Console.WriteLine("hello");
        }
    }

    class Student : Person
    {
        private String school;

        public string School { get => school; set => school = value; }

        public void SayHello(String teacher)
        {
            if ("校长".Equals(teacher))
            {
                Console.WriteLine("hello 校长");
            }
            else
            {
                base.SayHello();
            }
        }

        public new void SayHello()
        {
            base.SayHello();
            Console.WriteLine("子类的SayHello()");
        }


    }
}

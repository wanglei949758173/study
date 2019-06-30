using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestDirectory
{
    /// <summary>
    /// 测试Directory类
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            // 创建hello目录和world目录
            Console.WriteLine("创建hello目录和world目录");
            Console.ReadKey();
            if (Directory.Exists("hello"))
            {
                Console.WriteLine("hello文件夹已存在");
            }
            else
            {
                Directory.CreateDirectory("hello");
                Console.WriteLine("hello文件夹创建成功");
            }
            if (Directory.Exists("world"))
            {
                Console.WriteLine("world文件夹已存在");
            }
            else
            {
                Directory.CreateDirectory("world");
                Console.WriteLine("world文件夹创建成功");
            }

            // 移动world目录到hello目录下
            Console.WriteLine("移动world目录到hello目录下");
            Console.ReadKey();
            if (Directory.Exists("world") && !Directory.Exists("hello/world"))
            {
                Directory.Move("world", "hello/world");
                Console.WriteLine("移动完成");
            }
            else
            {
                Console.WriteLine("移动错误");
            }

            // 在world目录下创建a.txt
            Console.WriteLine("在world目录下创建a.txt");
            Console.ReadKey();
            if (!File.Exists("hello/world/a.txt"))
            {
                File.Create("hello/world/a.txt");
                Console.WriteLine("a.txt创建成功");
            }
            else
            {
                Console.WriteLine("a.txt已存在");
            }

            // 查找所有文件名
            Console.WriteLine("-------------------------");
            Console.WriteLine("文件名如下");
            string[] fileNames = Directory.GetFiles("hello", ".txt");
            foreach (string fileName in fileNames)
            {
                Console.WriteLine(fileName); // 无文件
            }

            // 获取hello文件夹下的所有文件
            Console.WriteLine("-------------------------");
            Console.WriteLine("hello文件夹下的文件");
            string[] files = Directory.GetDirectories("hello");
            foreach (string file in files)
            {
                Console.WriteLine(file); // world
            }

            // 获取world文件夹下的所有文件
            Console.WriteLine("-------------------------");
            Console.WriteLine("world文件夹下的文件");
            string[] worldFiles = Directory.GetDirectories("hello/world");
            foreach (string file in worldFiles)
            {
                Console.WriteLine(file); // 无
            }


            // 删除hello目录
            Console.WriteLine("-------------------------");
            Console.WriteLine("删除hello目录?");
            Console.ReadKey();
            Directory.Delete("hello",true);

            // File的读写，只适用于小文件
            string fileContent = File.ReadAllText(@"C:\Users\Administrator\Desktop\hello.txt",Encoding.Default);
            Console.WriteLine(fileContent);

            // 将hello.txt中的文件写入world.txt，使用utf-8编码
            //File.Create(@"C:\Users\Administrator\Desktop\world.txt");
            File.WriteAllText(@"C:\Users\Administrator\Desktop\world.txt", fileContent, Encoding.UTF8);

            Console.ReadKey();
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestFile
{
    /// <summary>
    /// 测试File类
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            // 创建文件
            if (File.Exists("hello.txt"))
            {

            }
            else
            {
                File.Create("hello.txt");
            }

            // 复制文件
            if (File.Exists(@"C:\Users\Administrator\Desktop\hello.txt"))
            {

            }
            else
            {
                File.Copy("hello.txt", @"C:\Users\Administrator\Desktop\hello.txt");
            }

            // 移动文件
            if (File.Exists(@"C:\Users\Administrator\Desktop\world.txt")){
            }
            else
            {
                File.Move(@"C:\Users\Administrator\Desktop\hello.txt", @"C:\Users\Administrator\Desktop\world.txt");
            }

            // 删除文件
            File.Delete(@"C:\Users\Administrator\Desktop\hello.txt");
            File.Delete(@"C:\Users\Administrator\Desktop\world.txt");
        }
    }
}

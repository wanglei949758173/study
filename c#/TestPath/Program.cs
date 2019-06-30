using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestPath
{
    /// <summary>
    /// 测试Path类
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            // 获取文件名
            string fileName = Path.GetFileName("C:/WiredTiger.wt");
            Console.WriteLine(fileName); // WiredTiger.wt

            // 获取文件名不包含扩展名
            string realFileName = Path.GetFileNameWithoutExtension("C:/WiredTiger.wt");
            Console.WriteLine(realFileName); // WiredTiger

            // 获取文件所在文件夹的名称
            string dicName = Path.GetDirectoryName("C:/WiredTiger.wt");
            Console.WriteLine(dicName); // C:/

            // 获取文件的全路径名
            string fullName = Path.GetFullPath("C:/WiredTiger.wt");
            Console.WriteLine(fullName); // C:/WiredTiger.wt

            // 连接两个路径
            string combinePath = Path.Combine("c:/a/b", "c");
            Console.WriteLine(combinePath); // c:/a/b\c

            Console.ReadKey();
        }
    }
}

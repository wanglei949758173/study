using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestStream
{
    /// <summary>
    /// 流
    /// </summary>
    class Program
    {
        static void Main(string[] args)
        {
            /*
                FileStream:读取字节
                StreamReader:读取字符
                StreamWriter:写字符
             */

            #region FileStream
            // 将创建资源的操作放入using代码块中，可以由GC自动回收资源
            using (FileStream fileStream = new FileStream(@"C:\Users\Administrator\Desktop\hello.txt", FileMode.OpenOrCreate, FileAccess.Read))
            {
                byte[] buffer = new byte[1024 * 1024 * 5];
                while (true)
                {
                    int r = fileStream.Read(buffer, 0, buffer.Length);
                    if(r <= 0)
                    {
                        break;
                    } else
                    {
                        // 转换为字符串
                        string content = Encoding.Default.GetString(buffer, 0, r);
                        Console.WriteLine(content);
                    }
                    Console.WriteLine(r);
                }
            }
            #endregion

            #region StreamReader和StreamWriter
            // Reader
            using (StreamReader streamReader = new StreamReader(@"C:\Users\Administrator\Desktop\hello.txt", Encoding.Default))
            {
                Console.WriteLine("----------------------------------------");
                while(!streamReader.EndOfStream)
                {
                    string readerStr = streamReader.ReadLine();
                    Console.WriteLine(readerStr);
                }
            }

            // Writer
            using(StreamWriter streamWriter = new StreamWriter(@"C:\Users\Administrator\Desktop\hello.txt",true, Encoding.Default))
            {
                streamWriter.WriteLine("插入第一行");
                streamWriter.WriteLine("插入第二行");
            }
            #endregion
            Console.ReadKey();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace ApplicationEvent
{
    /// <summary>
    /// App.xaml 的交互逻辑
    /// </summary>
    public partial class App : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            // 通过回调事件OnXXX来干自己想干的事
            base.OnStartup(e);
            MainWindow window = new MainWindow();
            
            if(e.Args.Length > 0)
            {
                string file = e.Args[0];
                if (File.Exists(file))
                {
                    window.LoadFile(file);
                } 
            }
            window.Show();
        }
    }
}

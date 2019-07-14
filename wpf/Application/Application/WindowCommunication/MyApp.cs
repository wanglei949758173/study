using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace WindowCommunication
{

    /// <summary>
    /// 测试窗口之间的通信
    /// </summary>
    class MyApp : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            MainWindow mainWindow = new MainWindow();
            mainWindow.Show();
        }

        private List<MyWindow> myWindows = new List<MyWindow>();
        public List<MyWindow> MyWindows { get => myWindows; set => myWindows = value; }

        [STAThread]
        static void Main()
        {
            MyApp myApp = new MyApp();
            myApp.Run();
        }


    }
}

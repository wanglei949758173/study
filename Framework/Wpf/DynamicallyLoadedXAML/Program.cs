using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace DynamicallyLoadedXAML
{
    class Program : Application
    {
        [STAThread]
        static void Main()
        {
            Program program = new Program();
            program.MainWindow = new MainWindow("window1.xaml");
            program.MainWindow.ShowDialog();
        }
    }
}

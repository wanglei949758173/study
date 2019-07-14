using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace TestSingleInstanceApplicationWrapper
{
    class WpfApp : Application
    {
        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            ShowWindow();
        }

        public void ShowWindow()
        {
            MainWindow window = new MainWindow();
            window.Show();
        }
    }
}

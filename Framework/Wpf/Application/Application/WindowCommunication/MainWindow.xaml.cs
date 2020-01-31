using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WindowCommunication
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            MyWindow myWindow = new MyWindow();
            myWindow.Owner = this;
            myWindow.Show();
            ((MyApp)Application.Current).MyWindows.Add(myWindow);
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            foreach (MyWindow window in ((MyApp)Application.Current).MyWindows)
            {
                window.Content = "当前时间:" + DateTime.Now.ToLongTimeString();
            }
        }
    }
}

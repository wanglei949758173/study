using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DynamicallyLoadedXAML
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        private Button button;
        public MainWindow()
        {
            InitializeComponent();
        }

        public MainWindow(string xamlFile)
        {
            // 设置窗体
            this.Width = this.Height = 285;
            this.Left = this.Top = 100;
            this.Title = "动态加载XAML";

            // 从一个XAML文件里获取内容
            DependencyObject rootElement;
            using (FileStream fs = new FileStream(xamlFile, FileMode.Open))
            {
                rootElement = (DependencyObject)XamlReader.Load(fs);
            }

            this.Content = rootElement;

            button = (Button)LogicalTreeHelper.FindLogicalNode(rootElement, "button1");
            button.Click += ButtonClick;
        }

        public void ButtonClick(object sender, RoutedEventArgs e)
        {
            button.Content = "点我啦";
        }
    }
}

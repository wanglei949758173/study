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

namespace TestCodeBinding
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

        /// <summary>
        /// 使用写代码的方式绑定
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            Binding binding = new Binding();
            // 设置绑定的源对象为slider1
            binding.Source = this.Slider1;
            binding.Path = new PropertyPath("Value");
            binding.Mode = BindingMode.TwoWay;

            // 设置目标对象textblock1的FontSize属性绑定到独享binding上
            this.textblock1.SetBinding(TextBlock.FontSizeProperty, binding);
        }
    }
}

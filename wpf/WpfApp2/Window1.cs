using System.Windows;
using System.Windows.Controls;
using System.Windows.Markup;

namespace WpfApp2
{
    /// <summary>
    /// 只使用代码创建WPF窗口
    /// </summary>
    class Window1 : Window
    {
        private Button button1;

        public Window1()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            // 设置窗体
            this.Width = 285;
            this.Height = 250;
            this.Left = this.Top = 100;
            this.Title = "只使用编码的窗口";

            // 创建停靠面板对象
            DockPanel panel = new DockPanel();

            // 创建按钮对象
            button1 = new Button();
            button1.Content = "点击我";
            button1.Margin = new Thickness(30);

            button1.Click += Button1Click;

            // 将button添加到panel中
            IAddChild container = panel;
            container.AddChild(button1);
            
            // 将panel添加到window中
            container = this;
            this.AddChild(panel);
        }

        private void Button1Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("谢谢");
        }
    }
}

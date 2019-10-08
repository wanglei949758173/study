using jdsn.wpf.runner.conf;
using jdsn.wpf.runner.core;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;

namespace WpfRunner_Main_Project1
{
    /// <summary>
    /// App.xaml 的交互逻辑
    /// </summary>
    public partial class App : Application
    {
        /// <summary>
        /// 构造函数
        /// </summary>
        public App()
        {
            //设置应用程序名称
            WpfRunner.ApplicationName = "WpfRunner_Main_Project1";

            //取得配置信息
            WpfRunnerConfiguration config = ConfigurationManager.GetSection("wpfRunner") as WpfRunnerConfiguration;

            //初始化WpfRunner并显示第一个窗口
            // TODO: 请将第三个参数替换为实际的窗口类路径
            WpfRunner.Initialize(config.Parameters, config.Assemblys, "UserManager.MainWindow");
        }
    }
}

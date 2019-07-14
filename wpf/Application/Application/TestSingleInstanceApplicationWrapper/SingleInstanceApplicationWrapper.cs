using Microsoft.VisualBasic.ApplicationServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestSingleInstanceApplicationWrapper
{
    /// <summary>
    /// 单实例应用包装器
    /// </summary>
    class SingleInstanceApplicationWrapper : WindowsFormsApplicationBase
    {
        public SingleInstanceApplicationWrapper()
        {
            // 设置单实例属性为true
            this.IsSingleInstance = true;
        }

        private WpfApp app;

        protected override bool OnStartup(StartupEventArgs eventArgs)
        {
            base.OnStartup(eventArgs);
            app = new WpfApp();
            app.Run();
            return false;
        }

        protected override void OnStartupNextInstance(StartupNextInstanceEventArgs eventArgs)
        {
            base.OnStartupNextInstance(eventArgs);
            app.ShowWindow();
        }
    }
}

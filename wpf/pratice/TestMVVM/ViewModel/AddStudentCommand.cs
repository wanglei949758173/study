using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Input;

namespace TestMVVM.ViewModel
{
    /// <summary>
    /// 添加学生的命令
    /// </summary>
    class UpdateStudentsCommand : ICommand
    {
        /// <summary>
        /// 执行方法
        /// </summary>
        public Action ExecuteAction;

        public UpdateStudentsCommand(Action executeAction)
        {
            ExecuteAction = executeAction;
        }

        public event EventHandler CanExecuteChanged;

        public bool CanExecute(object parameter)
        {
            return ExecuteAction != null;
        }

        public void Execute(object parameter)
        {
            if (ExecuteAction != null)
            {
                ExecuteAction();
            }
            else
            {
                // Nothing TO DO
            }
        }
    }
}

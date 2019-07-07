using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;
using System.Collections.ObjectModel;
using System.Windows.Input;

namespace TestMVVM.ViewModel
{
    class MainWindowViewModel
    {

        public MainWindowViewModel()
        {
            Student sutdent1 = new Student("张三", 9, 3, 90.2F);
            Student sutdent2 = new Student("李四", 10, 3, 100.0F);
            Student sutdent3 = new Student("王五", 8, 2, 86F);
            Student sutdent4 = new Student("赵刘", 9, 2, 91.2F);
            Student sutdent5 = new Student("李明", 11, 4, 92.2F);
            this._students.Add(sutdent1);
            this._students.Add(sutdent2);
            this._students.Add(sutdent3);
            this._students.Add(sutdent4);
            this._students.Add(sutdent5);

            // 初始化添加学生命令
            BtnAddStudent = new UpdateStudentsCommand(AddStudent);

            // 初始化删除学生命令
            BtnRemoveStudent = new UpdateStudentsCommand(RemoveStudent);

            // 初始化修改学生成绩命令
            BtnUpdateStudentScore = new UpdateStudentsCommand(UpdateStudentScore);
        }

        #region 字段

        /// <summary>
        /// 学生列表
        /// </summary>
        private ObservableCollection<Student> _students = new ObservableCollection<Student>();

        #endregion

        #region 属性

        /// <summary>
        /// 学生属性
        /// </summary>
        public ObservableCollection<Student> Students
        {
            get => _students;
            set
            {
                this._students = value;
            }
        }

        /// <summary>
        /// 添加学生命令
        /// </summary>
        public ICommand BtnAddStudent { get; set; }

        /// <summary>
        /// 删除学生命令
        /// </summary>
        public ICommand BtnRemoveStudent { get; set; }

        public ICommand BtnUpdateStudentScore { get; set; }

        #endregion

        #region 方法
        /// <summary>
        /// 添加学生
        /// </summary>
        public void AddStudent()
        {
            this.Students.Add(new Student("学生x", 20, 16, 64.2F));
        }

        /// <summary>
        /// 删除学生
        /// </summary>
        public void RemoveStudent()
        {
            if (Students.Count != 0)
            {
                this.Students.RemoveAt(0);
            }
        }

        /// <summary>
        /// 修改第2个学生的分数为90
        /// </summary>
        public void UpdateStudentScore()
        {
            if (this.Students.Count < 2)
            {
                return;
            }
            else
            {
                Student s1 = this.Students[1];
                s1.Score = 90.0F;
            }
        }
        #endregion

    }
}

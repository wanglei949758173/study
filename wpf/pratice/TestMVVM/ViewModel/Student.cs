using System.ComponentModel;

namespace TestMVVM.ViewModel
{
    /// <summary>
    /// 学生类
    /// </summary>
    class Student : INotifyPropertyChanged
    {
        public Student(string name, int age, int grade, float score)
        {
            Name = name;
            Age = age;
            Grade = grade;
            Score = score;
        }

        private float score;

        /// <summary>
        /// 姓名
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// 年龄
        /// </summary>
        public int Age { get; set; }

        /// <summary>
        /// 年级
        /// </summary>
        public int Grade { get; set; }

        /// <summary>
        /// 成绩
        /// </summary>
        public float Score
        {
            get
            {
                return score;
            }
            set
            {
                score = value;
                // 通知属性改变
                if (PropertyChanged != null)
                {
                    PropertyChanged(this, new PropertyChangedEventArgs("Score"));
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
    }
}

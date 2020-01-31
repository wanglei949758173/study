using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace ResourceLib
{
    public class CustomControl1
    {
        public static ComponentResourceKey test
        {
            get
            {
                return new ComponentResourceKey(typeof(CustomControl1), "test");
            }
        }
    }
}

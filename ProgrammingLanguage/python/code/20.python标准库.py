# python标准库
# sys模块
import sys

# pprint 模块它给我们提供了一个方法 pprint() 该方法可以用来对打印的数据做简单的格式化
import pprint

# 获取执行代码时，命令行中所包含的参数
# 该属性是一个列表，列表中保存了当前命令的所有参数
print(sys.argv)

# 获取当前程序中引入的所有模块
# modules是一个字典，字典的key是模块的名字，字典的value是模块对象
pprint.pprint(sys.modules)

# sys.path
# 他是一个列表，列表中保存的是模块的搜索路径
pprint.pprint(sys.path)

# sys.platform
# 表示当前Python运行的平台
print(sys.platform)

# sys.exit()
# 函数用来退出程序
# sys.exit('程序出现异常，结束！')

# os 模块让我们可以对操作系统进行访问
import os

# os.environ
# 通过这个属性可以获取到系统的环境变量
pprint.pprint(os.environ['path'])

# os.system()
# 可以用来执行操作系统的名字
os.system('dir')
os.system('notepad')

# 模块化
# 引入test_moudle模块
import test_moudle as test

print(test.__name__) # test_moudle
print(__name__) # __main__

# 访问模块中的变量、函数、类
print('testA:', test.testA)
print('testB:', test.testB)
test.testFun();
p = test.Person();
print(p)

# 导入模块的几种方式
# import xxx
# import xxx as yyy
# from xxx import yyy , zzz , fff
# from xxx import * # 这种方式一般不用
# from xxx import yyy as zz

# 添加了_的变量，只能在模块内部访问，在通过import * 引入时，不会引入_开头的变量
from test_moudle import *
# print(_c) # name '_c' is not defined
print(test._c) # 可以正常访问

# 包
print('===包===')
from testPack import a,b
print(a.a)
print(b.b)

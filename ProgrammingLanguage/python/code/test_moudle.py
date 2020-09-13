# print('我是test moudle')
testA = 10
testB = 20

def testFun() :
    print('testFun()')

class Person :
    pass

# 添加了_的变量，只能在模块内部访问，在通过import * 引入时，不会引入_开头的变量
_c = 30

# 编写测试代码，这部分代码，只要当当前文件作为主模块的时候才需要执行
#   而当模块被其他模块引入时，不需要执行的，此时我们就必须要检查当前模块是否是主模块  
if __name__ == '__main__':
    testFun()

# 异常
print('hello')
try:
    print(10 / 0) # ZeroDivisionError: division by zero
except:
    print('出错了')
else:
    print('未出错')

# 异常类型
try:
    print(c)
    print(10 / 0)
except NameError:
    print('出现 NameError')
except ZeroDivisionError:
    print('出现 ZeroDivisionError 异常')
# 可以在异常类后边跟着一个 as xx 此时xx就是异常对象
except Exception as e :
    print(e, type(e))
finally:
    print('finally 代码块')

# 抛出异常
# 自定义异常
class IllegalArgumentException(Exception):
    pass;

# 参数为None时，抛出异常
def getName(obj):
    if(obj == None):
        raise IllegalArgumentException('参数Obj不能')
getName(None)

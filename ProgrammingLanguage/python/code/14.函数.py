# 函数的定义
def fn() :
    print('first function')
    print('hello')

fn();
print(type(fn)); # <class 'function'>

def sum(a, b) :
    print(f'a+b={a+b}')
sum(1,2)

# 函数的参数
# 参数默认值
# 指定了默认值以后，如果用户传递了参数则默认值没有任何作用
# 如果用户没有传递，则默认值就会生效
def defaultParm(a = 5, b = 3, c = 20) :
    print('a=', a);
    print('b=', b);
    print('c=', c);
defaultParm(1, 2, 3);
defaultParm(1, 2);
defaultParm();

# 参数的传递方式
# 位置参数
# 位置参数就是将对应位置的实参复制给对应位置的形参
# 第一个实参赋值给第一个形参，第二个实参赋值给第二个形参...
defaultParm(1, 2, 3);

# 关键字参数
# 关键字参数，可以不按照形参定义的顺序去传递，而直接根据参数名去传递参数
defaultParm(b=1 , c=2 , a=3)

# 位置参数和关键字参数可以混合使用
print('hello' , end='')
# 混合使用关键字和位置参数时，必须将位置参数写到前面
defaultParm(1, c=30)

# 不定长的参数
# in
def sum(*nums):
    # 定义一个变量，来保存结果
    result = 0
    # 遍历元组，并将元组中的数进行累加
    for n in nums :
        result += n
    print(result)
sum(123,456,789,10,20,30,40)

# 在定义函数时，可以在形参前边加上一个*，这样这个形参将会获取到所有的实参
# 它将会将所有的实参保存到一个元组中
a,b,*c = (1,2,3,4,5,6)
print('c=', c)# [3,4,5,6]

# *a会接受所有的位置实参，并且会将这些实参统一保存到一个元组中（装包）
def fn(*a):
    print("a =",a,type(a))# <class 'tuple'>
fn(1,2,3,4,5)

# 带星号的形参只能有一个
# 带星号的参数，可以和其他参数配合使用
# 第一个参数给a，第二个参数给b，剩下的都保存到c的元组中
def fn2(a,b,*c):
     print('a =',a)
     print('b =',b)
     print('c =',c)

# 可变参数不是必须写在最后，但是注意，带*的参数后的所有参数，必须以关键字参数的形式传递
# 第一个参数给a，剩下的位置参数给b的元组，c必须使用关键字参数
def fn2(a,*b,c):
    print('a =',a)
    print('b =',b)
    print('c =',c)
fn2(1, 3, 4, c=5)

# 所有的位置参数都给a，b和c必须使用关键字参数
def fn2(*a,b,c):
     print('a =',a)
     print('b =',b)
     print('c =',c)
fn2(1,2,3, b=2, c=4)

# 如果在形参的开头直接写一个*,则要求我们的所有的参数必须以关键字参数的形式传递
def fn2(*,a,b,c):
    print('a =',a)
    print('b =',b)
    print('c =',c)
fn2(a=3,b=4,c=5)

# *形参只能接收位置参数，而不能接收关键字参数
def fn3(*a) :
     print('a =',a)

# **形参可以接收其他的关键字参数，它会将这些参数统一保存到一个字典中
#   字典的key就是参数的名字，字典的value就是参数的值
# **形参只能有一个，并且必须写在所有参数的最后
def fn3(b,c,**a) :
    print('a =',a,type(a)) # a = {'d': 2, 'e': 10, 'f': 20} <class 'dict'>
    print('b =',b) # 1
    print('c =',c) # 3
fn3(b=1,d=2,c=3,e=10,f=20)

# 参数的解包（拆包）
def fn4(a,b,c):
    print('a =',a)
    print('b =',b)
    print('c =',c)
# 创建一个元组
t = (10,20,30)
# 传递实参时，也可以在序列类型的参数前添加星号，这样他会自动将序列中的元素依次作为参数传递
# 这里要求序列中元素的个数必须和形参的个数的一致
fn4(*t)    

# 创建一个字典
d = {'a':100,'b':200,'c':300}
# 通过 **来对一个字典进行解包操作
fn4(**d)

# 文档字符串
print('文档字符串')
help(print)

def sum(value1:int, value2:int) -> int :
    '''
    对两个整形值求和

     函数的参数：
        value1，作用，类型，默认值。。。。
        value2，作用，类型，默认值。。。。
    '''
    return value1 + value2;
help(sum)

# 命名空间
print('命名空间')
# 获取当前命名空间
scope = locals() # 当前命名空间
print(scope,type(scope)) # <class 'dict'>

print(a)
print(scope['a'])
# 向scope中添加一个key-value
scope['c'] = 1000 # 向字典中添加key-value就相当于在全局中创建了一个变量（一般不建议这么做）
print(c)

# 函数命名空间
def fn4():
    a = 10
    scope = locals() # 在函数内部调用locals()会获取到函数的命名空间
    scope['b'] = 20 # 可以通过scope来操作函数的命名空间，但是也是不建议这么做

    # globals() 函数可以用来在任意位置获取全局命名空间
    global_scope = globals()
    print(global_scope['a'])
    global_scope['a'] = 30
    print(scope)

fn4() 

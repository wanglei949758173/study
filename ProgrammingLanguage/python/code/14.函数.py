# 函数的定义
def fn() :
    print('first function')
    print('hello')

fn();
print(type(fn)); # <class 'function'>

def mySum(a, b) :
    print(f'a+b={a+b}')
mySum(1,2)

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
def mySum(*nums):
    # 定义一个变量，来保存结果
    result = 0
    # 遍历元组，并将元组中的数进行累加
    for n in nums :
        result += n
    print(result)
mySum(123,456,789,10,20,30,40)

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

def mySum(value1:int, value2:int) -> int :
    '''
    对两个整形值求和

     函数的参数：
        value1，作用，类型，默认值。。。。
        value2，作用，类型，默认值。。。。
    '''
    return value1 + value2;
help(mySum)

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

# 高阶函数
print("====高阶函数====")
# 将指定列表中的所有的偶数，保存到一个新的列表中返回
def isEven(number) :
    if number % 2 == 0 :
        return True
    else :
        return False
def getEvenNumbers(filterFun, lst) :
    newList = []
    for number in lst :
        if filterFun(number) :
            newList.append(number)

    return newList;
lst = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
evenList = getEvenNumbers(isEven, lst);
print(evenList);

# 使用lambda表达式进行过滤
l = filter(lambda number : number % 3 == 0, lst)
print(list(l))

# 对列表进行排序
lst = ['bb','aaaa','c','ddddddddd','fff'];
lst.sort(key=len)
print(lst) # ['c', 'bb', 'fff', 'aaaa', 'ddddddddd']

lst = [2,5,'1',3,'6','4']
lst.sort(key=int)
print(lst)# ['1', 2, 3, '4', 5, '6']

# 闭包
print("====闭包====")
help(sum)
# 形成闭包的要件
#   ① 函数嵌套
#   ② 将内部函数作为返回值返回
#   ③ 内部函数必须要使用到外部函数的变量
def makeAverager() :
    nums = [];

    # 创建一个函数,计算平均值
    def averager(number) :
        nums.append(number);
        # 返回平均值
        return sum(nums)/len(nums);
    return averager;
averager = makeAverager();
print(averager(10)) # 10
print(averager(20)) # 15
print(averager(30)) # 20
print(averager(40)) # 25

# 装饰器
print("====装饰器====")
def add(a , b):
    '''
        求任意两个数的和
    '''
    r = a + b
    return r
def mul(a , b):
    '''
        求任意两个数的积
    '''
    r = a * b
    return r
# 希望函数可以在计算前，打印开始计算，计算结束后打印计算完毕
#  我们可以直接通过修改函数中的代码来完成这个需求，但是会产生以下一些问题
#   ① 如果要修改的函数过多，修改起来会比较麻烦
#   ② 并且不方便后期的维护
#   ③ 并且这样做会违反开闭原则（OCP）

# 方式一
def fn():
    print('我是fn函数....')
def fn2():
    print('函数开始执行~~~')
    fn()
    print('函数执行结束~~~')
fn2();
# 方式一的问题
# 这种方式要求每扩展一个函数就要手动创建一个新的函数，太麻烦了

# 方式二
def begin_end(old):
    '''
        用来对其他函数进行扩展，使其他函数可以在执行前打印开始执行，执行后打印执行结束

        参数：
            old 要扩展的函数对象
    '''
    # 创建一个新函数
    def new_function(*args , **kwargs):
        print('开始执行~~~~')
        # 调用被扩展的函数
        result = old(*args , **kwargs)
        print('执行结束~~~~')
        # 返回函数的执行结果
        return result

    # 返回新函数        
    return new_function
newAdd = begin_end(add);
newAdd(1,2);
# 像begin_end()这种函数我们就称它为装饰器
#   通过装饰器，可以在不修改原来函数的情况下来对函数进行扩展
#   在开发中，我们都是通过装饰器来扩展函数的功能的

# 方式三
# 在定义函数时，可以通过@装饰器，来使用指定的装饰器，来装饰当前的函数
#   可以同时为一个函数指定多个装饰器，这样函数将会按照从内向外的顺序被装饰
def fn3(old):
    '''
        用来对其他函数进行扩展，使其他函数可以在执行前打印开始执行，执行后打印执行结束

        参数：
            old 要扩展的函数对象
    '''
    # 创建一个新函数
    def new_function(*args , **kwargs):
        print('fn3装饰~开始执行~~~~')
        # 调用被扩展的函数
        result = old(*args , **kwargs)
        print('fn3装饰~执行结束~~~~')
        # 返回函数的执行结果
        return result

    # 返回新函数        
    return new_function

@fn3
@begin_end
def test() :
    print('test');
test();

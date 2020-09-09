# 面向对象
# 类的定义
print("===类的定义===")
class Person :
    name = 'person';

    def sayHello(self) :
        print(f'你好!我是{self.name}')

p1 = Person();
p2 = Person();
p1.name = 'p1';
p2.name = 'p2';
p1.sayHello(); # 你好!我是p1
p2.sayHello(); # 你好!我是p2

# 对象的初始化
class TestInit :
    # 在类中可以定义一些特殊方法（魔术方法）
    # 特殊方法都是以__开头，__结尾的方法
    # 特殊方法不需要我们自己调用，不要尝试去调用特殊方法
    # 特殊方法将会在特殊的时刻自动调用
    # 学习特殊方法：
    #   1.特殊方法什么时候调用
    #   2.特殊方法有什么作用
    # 创建对象的流程
    # p1 = Person()的运行流程
    #   1.创建一个变量
    #   2.在内存中创建一个新对象
    #   3.__init__(self)方法执行
    #   4.将对象的id赋值给变量

    # init会在对象创建以后离开执行
    # init可以用来向新创建的对象中初始化属性
    # 调用类创建对象时，类后边的所有参数都会依次传递到init()中
    # 双下划线
    def __init__(self,name) :
        self.name = name;

    def sayHello(self) :
        print(f'你好!我是{self.name}')

ti1 = TestInit('ti1');
ti2 = TestInit('ti2');
ti1.sayHello();
ti2.sayHello();

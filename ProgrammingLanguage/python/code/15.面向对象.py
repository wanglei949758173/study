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

# 封装
# 封装是面向对象的三大特性之一
# 封装指的是隐藏对象中一些不希望被外部所访问到的属性或方法
# 如何隐藏一个对象中的属性？
#   将对象的属性名，修改为一个外部不知道的名字
# 如何获取（修改）对象中的属性？
#   需要提供一个getter和setter方法使外部可以访问到属性
#       getter 获取对象中的指定属性（get_属性名）
#       setter 用来设置对象的指定属性（set_属性名）
# 使用封装，确实增加了类的定义的复杂程度，但是它也确保了数据的安全性
#   1.隐藏了属性名，使调用者无法随意的修改对象中的属性
#   2.增加了getter和setter方法，很好的控制的属性是否是只读的
#   3.使用setter方法设置属性，可以增加数据的验证，确保数据的值是正确的
#   4.使用getter方法获取属性，使用setter方法设置属性
#       可以在读取属性和修改属性的同时做一些其他的处理
#   5.使用getter方法可以表示一些计算的属性
print("===封装===")
# 第一种方式(重命名属性名)
class Rectangle:
    '''
        表示矩形的类
    '''
    def __init__(self,width,height):
        self.hidden_width = width
        self.hidden_height = height

    def get_width(self):
        return self.hidden_width

    def get_height(self):
        return self.hidden_height   

    def set_width(self , width):
        self.hidden_width = width 

    def set_height(self , height):
        self.hidden_height = height 

    def get_area(self):
        return self.hidden_width * self.hidden_height   
r = Rectangle(5,2)
print(r.get_width());
print(r.hidden_width);# 仍然可以直接访问

# 第二种方式(使用双下划线开头命名私有属性)
# 双下划线开头的属性，是对象的隐藏属性，隐藏属性只能在类的内部访问，无法通过对象访问
# 其实隐藏属性只不过是Python自动为属性改了一个名字
#   实际上是将名字修改为了，_类名__属性名 比如 __name -> _Person__name
class Person :
    def __init__(self, name) :
        self.__name = name

    def get_name(self) :
        return self.__name;

    def set_name(self, name) :
        self.__name = name;
sunwukong = Person('孙悟空');
print(sunwukong.get_name())
sunwukong.__name = '猪八戒' # 不会修改sunwukong实例的名字
print(sunwukong.get_name()) # 孙悟空
sunwukong._Person__name = '猪悟能'; # 会修改sunwukong实例的名字
print(sunwukong.get_name()) # 猪悟能

# 方式三(使用_开头命名私有属性,约定俗成)
# 使用__开头的属性，实际上依然可以在外部访问，所以这种方式我们一般不用
#   一般我们会将一些私有属性（不希望被外部访问的属性）以_开头
#   一般情况下，使用_开头的属性都是私有属性，没有特殊需要不要修改私有属性
class Person:
    def __init__(self,name):
        self._name = name

    def get_name(self):
        return self._name

    def set_name(self , name):
        self._name = name   

p = Person('孙悟空')
print(p._name)

# 使用装饰器优化getter和setter
class Person:
    def __init__(self, name, age):
        self._name = name
        self._age = age

    @property    
    def name(self):
        print('name getter invoke')
        return self._name;
    @name.setter
    def name(self, name):
        print('name setter invoke')
        self._name = name

    @property    
    def age(self):
        print('age getter invoke')
        return self._age;
    @age.setter
    def age(self, age):
        print('age setter invoke')
        self._age = age
p = Person('猪八戒', 18);
p.name = '大师兄'
p.age = 19;
print(p.name, p.age)

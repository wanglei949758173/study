# 继承
print('===继承===')
class Animal :
    def run(self) :
        print('动物会跑')

    def sleep(self) :
        print('动物睡觉')

# 狗继承自动物
class Dog(Animal) :
    def bark(self):
        print("汪汪汪")
    # run重写了父类的run方法
    def run(self) :
        print("狗子撒腿就跑")

#哈士奇继承自狗
class Hashiqi(Dog) :
    def mai_meng(self) :
        print("二哈");

d = Dog();

d.sleep();
d.bark();

h = Hashiqi();
h.mai_meng();
h.bark();

# 在创建类时，如果省略了父类，则默认父类为object
# object是所有类的父类，所有类都继承自object
class Person():
    pass
print(isinstance(Person,object)) # True
print(isinstance(print,object)) # True

class Animal:
    def __init__(self,name):
        self._name = name

    def run(self):
        print('动物会跑~~~')

    def sleep(self):
        print('动物睡觉~~~')

    @property
    def name(self):
        return self._name

    @name.setter    
    def name(self,name):
        self._name = name

# 父类中的所有方法都会被子类继承，包括特殊方法，也可以重写特殊方法
class Dog(Animal):

    def __init__(self,name,age):
        # 希望可以直接调用父类的__init__来初始化父类中定义的属性
        # super() 可以用来获取当前类的父类，
        #   并且通过super()返回对象调用父类方法时，不需要传递self
        super().__init__(name)
        self._age = age

    def bark(self):
        print('汪汪汪~~~') 

    def run(self):
        print('狗跑~~~~')   

    @property
    def age(self):
        return self._age

    @age.setter    
    def age(self,age):
        self._age = name        

d = Dog('旺财',18) 

print(d.name)       
print(d.age)       

# 多重继承
class A(object):
    def test(self):
        print('AAA')

class B(object):
    def test(self):
        print('B中的test()方法~~')

    def test2(self):
        print('BBB') 

# 在Python中是支持多重继承的，也就是我们可以为一个类同时指定多个父类
#   可以在类名的()后边添加多个类，来实现多重继承
#   多重继承，会使子类同时拥有多个父类，并且会获取到所有父类中的方法
# 在开发中没有特殊的情况，应该尽量避免使用多重继承，因为多重继承会让我们的代码过于复杂
# 如果多个父类中有同名的方法，则会现在第一个父类中寻找，然后找第二个，然后找第三个。。。
#   前边父类的方法会覆盖后边父类的方法
class C(A,B):
    pass

# 类名.__bases__ 这个属性可以用来获取当前类的所有父类    
print(B.__bases__) #(<class 'object'>,)
print(C.__bases__) # (<class '__main__.A'>, <class '__main__.B'>)

c = C()
c.test() # AAA

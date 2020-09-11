# 类中的属性和方法
class Test :
    # 类属性,可以通过类或实例访问到，但只能通过类来修改
    count = 0;

    # 实例属性,只能通过实例属性访问和修改
    def __init__(self) :
        self.name = '齐天大圣'

    # 类方法,可以通过实例和类访问,第一个参数会传入类型
    @classmethod
    def classMethod(clazz) :
        print(clazz)
        print('我是类方法')

    # 实例方法,可以通过类或实例取访问，但通过类访问时，不会传入第一个参数self
    def instanceMethod(self) :
        print(self.name)

    # 静态方法，静态方法一般为工具方法,可以通过类或实例访问
    @staticmethod
    def static_method() :
        print('我是静态方法')

# 类属性,可以通过类或实例访问到，但只能通过类来修改
t = Test();
print(Test.count) # 0
print(t.count) # 0
Test.count = 10;
print(t.count) # 10
t.count = 20;
print(t.count, Test.count) # 20 10

# 实例属性,只能通过实例属性访问和修改
t = Test();
# print(Test.name) # type object 'Test' has no attribute 'name'
print(t.name)

# 类方法,可以通过实例和类访问,第一个参数会传入类型
Test.classMethod(); # <class '__main__.Test'>
t = Test();
t.classMethod(); # <class '__main__.Test'>

# 实例方法,可以通过类或实例取访问，但通过类访问时，不会传入第一个参数self
t = Test();
t.instanceMethod()
# Test.instanceMethod() # instanceMethod() missing 1 required positional argument: 'self'

# 静态方法，静态方法一般为工具方法,可以通过类或实例访问
t = Test();
t.static_method()
Test.static_method()

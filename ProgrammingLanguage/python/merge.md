# 字符串

## 换行

一行语句换行时使用“\”进行分割

```python
print('he\
lleo \
world')
```

## 使用_让数字变得易读

```python
a = 1234_4321
print(a)
```

## 引号嵌套

单引号中间可以嵌套双引号

```python
s = '子曰:"学而时习之，不亦说乎"'
print(s)
```

## 三重引号

三重引号,可以换行,类似于ES6的模板字符串

```python
s = '''锄禾日当午，
汗滴禾下土，
谁知盘中餐，
粒粒皆辛苦。'''
print(s)
```

## 字符串格式化

### 使用占位符

```python
str = 'hello %s'%'小明'
str = 'hello %s和%s'%('小明','小红')
str = 'hello %3.5s'%'abcdefg' # %3.5s字符串的长度限制在3-5之间
# hello abcde
str = 'hello %s'%123.456
str = 'hello %.2f'%123.456
# hello 123.46
str = 'hello %d'%123.456
# hello 123
```

### 使用f格式化

```python
name='张三'
age=40
str = f'你好，小明! 我是{name},今年{age}岁了。'
print(str)
```

## 复制字符串

`*`  在语言中表示乘法，如果将字符串和数字相乘，则解释器会将字符串重复指定的次数并返回

```python
# 复制字符串10次
str = 'wanglei';
str = str * 20;
print(str);
```

# python类型

## 类型检查

```python
a = 10;
print(type(a));# <class 'int'>
a = 1.5; 
print(type(a));# <class 'float'>
a = 'haha';
print(type(a));# <class 'str'>
a = True;
print(type(a));# <class 'bool'>
a = None;
print(type(a));# <class 'NoneType'>
```

## 类型转换

`int()`

* 布尔值：True -> 1   False -> 0
* 浮点数：直接取整，省略小数点后的内容
* 字符串：合法的整数字符串，直接转换为对应的数字。如果不是一个合法的整数字符串，则报错 ValueError: invalid literal for int() with base 10: '11.5'

`float()`

* 与`int()`基本相似

`str()`

* True -> 'True'
* False -> 'False'
* 123 -> '123'

`bool()`

* 可以将对象转换为布尔值，任何对象都可以转换为布尔值
* 规则：对于所有表示空性的对象都会转换为False，其余的转换为True，例如：`0 、 None 、 ''`

```python
# int()
a = 1.5;
a = int(a);
print(a);# 1
a = '1';
a = int(a);
print(a); # 1,如果为a=`1.5`则报错

# float()
a = 1;
a = float(a);
print(a);# 1.0
a = '1';
a = float(a);
print(a);# 1.0
```

# 运算符

## 逻辑运算符

python中逻辑与用`and`，逻辑或用`or`，逻辑非用`not`。

```python
a = True and False;
print(a);# False
a = not False;
print(a);# True
a = True or False;
print(a);# True
```

## 条件运算符

> Python 的代码块不使用大括号 **{}** 来控制类，函数以及其他逻辑判断，而是使用缩进来写模块。

```python
# 条件运算符
a = -1;
result = '';
if (a <= 0):
    result = '小于等于0';
else:
    result = '大于0';

print(result);

# if-elif-else
age = 200;
if (age > 199):
    print('老妖怪');
elif (age > 100):
    print('长寿秘诀能告诉我吗?');
elif (age > 50):
    print('祝您活过百岁');
else:
    print('努力生活吧');

# input练习
age = int(input('请输入您的年龄'));
if (age > 199):
    print('老妖怪');
elif (age > 100):
    print('长寿秘诀能告诉我吗?');
elif (age > 50):
    print('祝您活过百岁');
else:
    print('努力生活吧');
```

## 使用pass占位

```python
# 使用pass站位
i = 10;
if(i == 10):
    pass;# 写代码调试时可以使用pass占位,让程序可以通过编译
```

# 循环语句

## while循环

```python
# while循环
i = 0;
sum = 0;
while (i < 10) :
    i += 1;
    print(i);
    sum += i;
else :
    print(f'else代码块,总和={sum}');
```

## for循环

```python
for letter in 'Python':     
   print '当前字母 :', letter
```

# 列表

## 初始化列表

```python
# 初始化列表
myList = []; # 创建空列表
myList = [10];
myList = [10, 20, 'hello', True, False];
```

## 获取列表长度

```python
print(len(myList));
```

## 切片

```python
# 切片
print(myList[-2]);# True,倒数第二个
print();

# 取下标为1及其之后的元素
print(myList[1:]);# 20, 'hello', True, False
print();

#取下标为3之前的元素,不包括下标为3的元素
print(myList[:3]);# 10, 20, 'hello', True
print();

# 创建一个列表的副本
print(myList[:]);

# 列表[起始下标:结束下标:步长]
print(myList[0:5:2]); # 10, Hello, False

# 当步长为负数时,则从后往前取
print(myList[::-2]); # False, 'Hello', 10
```

## 通用操作

`合并列表`

```python
# 列表合并
myList = [1,2,3] + [4,5,6];
print(myList);# 1,2,3,4,5,6
```

`重复列表(*)`

```python
# * 可以将列表重复指定的次数
myList = [1,2,3] * 6;
print(myList); # 1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3
```

`in & not in`

```python
# in & not in
myList = ['张三', '李四', '王五', '赵六'];
zhangsanIsIn = '张三' in myList;
print(zhangsanIsIn);# True
print('张三' not in myList);# False
```

`len(myList)`

```python
print(len(myList)); # 4
```

`min & max`

```python
# 求最小值最大值
myList = [2,1,3,4,5]
print(min(myList));# 1
print(max(myList));# 5
```

`myList.index(obj)`

```python
# 获取元素索引
print(myList.index(3));# 2
```

`myList.count(obj)`

```python
# 求元素出现的个数
myList = ['张三', '李四', '张三', '王五'];
print(myList.count('张三'));# 2
```

## 修改元素

```python
#修改元素
myList = ['孙悟空','猪八戒','沙和尚','唐僧','蜘蛛精','白骨精'];
myList[0] = 'sunwukong';
print(myList);
del myList[1];
print(myList);

myList = ['孙悟空','猪八戒','沙和尚','唐僧','蜘蛛精','白骨精'];
myList[0:2] = ['牛魔王', '红孩儿'];# 替换index为从0到2的元素,不包括2
print(myList);
myList[0:2] = ['牛魔王', '红孩儿', 'zhangsna', 'lisi']; # 多余的元素会被插入列表
print(myList);


del myList[0:2];
print(myList);
```

## 列表的方法

```python
# 列表的方法
stus = ['孙悟空','猪八戒','沙和尚','唐僧']
print('原列表：',stus)

# append() 
# 向列表的最后添加一个元素
stus.append('唐僧')

# insert()
# 向列表的指定位置插入一个元素
# 参数：
#   1.要插入的位置
#   2.要插入的元素
stus.insert(2,'唐僧')

# extend()
# 使用新的序列来扩展当前序列
# 需要一个序列作为参数，它会将该序列中的元素添加到当前列表中
stus.extend(['唐僧','白骨精'])
stus += ['唐僧','白骨精']

# clear()
# 清空序列
stus.clear()

# pop()
# 根据索引删除并返回被删除的元素

result = stus.pop(2) # 删除索引为2的元素
result = stus.pop() # 删除最后一个
print('result =',result)

# remove()
# 删除指定值得元素，如果相同值得元素有多个，只会删除第一个
stus.remove('猪八戒')

# reverse()
# 用来反转列表
stus.reverse()

# sort()
# 用来对列表中的元素进行排序，默认是升序排列
# 如果需要降序排列，则需要传递一个reverse=True作为参数
my_list = list('asnbdnbasdabd')
my_list = [10,1,20,3,4,5,0,-2]

print('修改前',my_list)

my_list.sort(reverse=True)
print('修改后',my_list)
# print('修改后：',stus)
```

## 遍历列表

```python
# 遍历列表
myList = ['张三', '李四', '王麻子', '赵六'];
for name in myList :
    print(name);
```

# 元组

元组是一个 `不可变` 的序列；

操作方式与列表基本一致；

一般希望数据不可变时，使用元组，其余情况使用列表。

## 创建元组

```python
# 元组
# 使用()来创建元组
my_tuple = () # 创建了一个空元组
print(my_tuple,type(my_tuple)) # <class 'tuple'>

my_tuple = (1,2,3,4,5) # 创建了一个5个元素的元组
# my_tuple[3] = 10 #TypeError: 'tuple' object does not support item assignment
print(my_tuple[3]);

# 当元组不是空元组时，括号可以省略
# 如果元组不是空元组，它里边至少要有一个,
my_tuple = 10,20,30,40
my_tuple = 40,
print(my_tuple , type(my_tuple)) # (40,) <class 'tuple'>
```

## 解构赋值

```python
my_tuple = 10 , 20 , 30 , 40
# 元组的解包（解构）
# 解包指就是将元组当中每一个元素都赋值给一个变量
a,b,c,d = my_tuple
print(a,b,c,d);

# 在对一个元组进行解包时，变量的数量必须和元组中的元素的数量一致
# 也可以在变量前边添加一个*，这样变量将会获取元组中所有剩余的元素
a , b , *c = my_tuple
a , *b , c = my_tuple
*a , b , c = my_tuple
a , b , *c = [1,2,3,4,5,6,7]
a , b , *c = 'hello world'
# 不能同时出现两个或以上的*变量
# *a , *b , c = my_tuple SyntaxError: two starred expressions in assignment
print('a =',a)
print('b =',b)
print('c =',c)
```

## 交换两个变量的值

```python
# 交换a 和 b的值，这时我们就可以利用元组的解构赋值
a = 100
b = 300
print(a , b)
a , b = b , a
print(a , b)
```

# 可变对象

修改对象的 `值`，对象 `id` 不变，`id` 相当于java中的 `hashcode`

```python
# 可变对象
a = [1,2,3]
print('修改前：', a , id(a))

# 通过索引修改列表
a[0] = 10
print('修改后：', a , id(a))
# 修改对象的值不会改变对象的id

# 为变量重新赋值
a = [4,5,6]
print('修改后：', a , id(a))
# 修改对象的引用对象的id会改变

a = [1,2,3]
b = a
b[0] = 10
b = [10,2,3]
print("a",a,id(a)) # a [10,2,3] 58740776
print("b",b,id(b)) # b [10,2,3] 49954792
```

`==` 和 `!=` 比较的是对象的值 `value` 是否相等，而 `is` 和 `is not` 比较的是对象的 `id` 是否相等。

```python
# == !=  is is not
# == != 比较的是对象的值是否相等 
# is is not 比较的是对象的id是否相等（比较两个对象是否是同一个对象）
a = [1,2,3]
b = [1,2,3]
print(a,b)
print(id(a),id(b))
print(a == b) # a和b的值相等，使用==会返回True
print(a is b) # a和b不是同一个对象，内存地址不同，使用is会返回False
```

# 字典

## 字典的创建

```python
# 字典
# 使用 {} 来创建字典
d = {} # 创建了一个空字典

# 创建一个保护有数据的字典
# 语法：
#   {key:value,key:value,key:value}
#   字典的值可以是任意对象
#   字典的键可以是任意的不可变对象（int、str、bool、tuple ...），但是一般我们都会使用str
#       字典的键是不能重复的，如果出现重复的后边的会替换到前边的
# d = {'name':'孙悟空' , 'age':18 , 'gender':'男' , 'name':'sunwukong'}
d = {
'name':'孙悟空' , 
'age':18 , 
'gender':'男' , 
'name':'sunwukong'
}

print(d , type(d)) # <class 'dict'>

# 需要根据键来获取值
print(d['name'],d['age'],d['gender']) # sunwukong 18 nan

# 如果使用了字典中不存在的键，会报错
# print(d['hello']) KeyError: 'hello' 
```

使用  `dict()` 函数来创建字典

```python
# 每一个参数都是一个键值对，参数名就是键，参数名就是值（这种方式创建的字典，key都是字符串）
d = dict(name='孙悟空',age=18,gender='男') 
```

将一个包含有双值子序列的序列转换为字典

```python
# 也可以将一个包含有双值子序列的序列转换为字典
# 双值序列，序列中只有两个值，[1,2] ('a',3) 'ab'
# 子序列，如果序列中的元素也是序列，那么我们就称这个元素为子序列
# [(1,2),(3,5)]
d = dict([('name','孙悟饭'),('age',18)])
# print(d , type(d))
d = dict(name='孙悟空',age=18,gender='男') 
```


## 字典的基本API

获取字典中键值对的个数

```python
# len() 获取字典中键值对的个数
print(len(d))
```

检查字典中是否包含指定的键

```python
# in 检查字典中是否包含指定的键
# not in 检查字典中是否不包含指定的键
print('hello' in d)
```

获取字典中的值，根据键来获取值

```python
# 获取字典中的值，根据键来获取值
# 语法：d[key]
print(d['age'])
n = 'name'
print(d[n])
```

通过 `get(key,defaultValue)` 来获取字典中的值

```python
print(d.get('name'))
print(d.get('hello','默认值'))
```

修改字典

```python
# 修改字典
# d[key] = value 如果key存在则覆盖，不存在则添加
d['name'] = 'sunwukong' # 修改字典的key-value
d['address'] = '花果山' # 向字典中添加key-value
print(d)
```

通过 `setdefault(key,defaultValue)` 向字典中添加 `key-value` 

```python
# setdefault(key[, default]) 可以用来向字典中添加key-value
#   如果key已经存在于字典中，则返回key的值，不会对字典做任何操作
#   如果key不存在，则向字典中添加这个key，并设置value
result = d.setdefault('name','猪八戒')
result = d.setdefault('hello','猪八戒')
print('result =',result)
```

将其他的字典中的key-value添加到当前字典中

```python
d = {'a':1,'b':2,'c':3}
d2 = {'d':4,'e':5,'f':6, 'a':7}
d.update(d2)
print(d) # {'a': 7, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6}
```

删除键值

```python
# 删除，可以使用 del 来删除字典中的 key-value
del d['a']
del d['b']
print(d)
```

删除一个键值对

```python
# popitem()
# 随机删除字典中的一个键值对，一般都会删除最后一个键值对
#   删除之后，它会将删除的key-value作为返回值返回
#   返回的是一个元组，元组中有两个元素，第一个元素是删除的key，第二个是删除的value
# 当使用popitem()删除一个空字典时，会抛出异常 KeyError: 'popitem(): dictionary is empty'
d.popitem()
result = d.popitem()
print(result)
```

根据key删除键值对

```python
# pop(key[, default])
# 根据key删除字典中的key-value
# 会将被删除的value返回！
# 如果删除不存在的key，会抛出异常
#   如果指定了默认值，再删除不存在的key时，不会报错，而是直接返回默认值
result = d.pop('d')
result = d.pop('z','这是默认值')
print(result)
```

清空字典

```python
# clear()用来清空字典
d.clear()
print(d)
```

`copy()`

```python
# copy()
# 该方法用于对字典进行浅复制
# 复制以后的对象，和原对象是独立，修改一个不会影响另一个
# 注意，浅复制会简单复制对象内部的值，如果值也是一个可变对象，这个可变对象不会被复制
d = {'a':1,'b':2,'c':{'v':'我是c'}}
d2 = d.copy()
d['a'] = 100
d['c']['v']='我是d中的c'
print(d2) # a对应的值未变,c对应的值改变
```

## 遍历字典

通过 `keys()` 进行遍历

```python
# 遍历字典
# keys() 该方法会返回字典的所有的key
#   该方法会返回一个序列，序列中保存有字典的所有的键
d = {'name':'孙悟空','age':18,'gender':'男'}
for k in d.keys() :
	print(k , d[k])
```

通过 `values()` 进行遍历

```python
# values()
# 该方法会返回一个序列，序列中保存有字典的值
for v in d.values():
    print(v)
```

通过 `items()` 进行遍历

```python
# items()
# 该方法会返回字典中所有的项
# 它会返回一个序列，序列中包含有双值子序列
# 双值分别是，字典中的key和value
# print(d.items())
for k,v in d.items() :
    print(k , '=' , v)
```

# set

`set` 是一种保存不重复元素的集合

## 创建set

```python
# 创建集合
s = {'a' , 'b' , 1 , 2 , 3 , 1}
print(s)

# 使用set创建集合
s = set('hello')

# 使用set()将字典转换为集合时，只会包含字典中的键
s = set({'a':1,'b':2,'c':3})
print(s)

```

## 基本API

`in & not in`

```python
# 使用in和not in来检查集合中的元素
print('c' in s)
```

`len()`

```python
# 使用len()来获取集合中元素的数量
print(len(s))
```

`add()`

```python
# add() 向集合中添加元素
s.add(10)
s.add(30)
```

`update()` 将一个集合中的元素添加到当前集合中

```python
#   update()可以传递序列或字典作为参数，字典只会使用键
s2 = set('hello')
s.update(s2)
s.update((10,20,30,40,50))
s.update({10:'ab',20:'bc',100:'cd',1000:'ef'})
```

`pop()` 删除顶部元素

```python
result = s.pop()
```

`remove()` 删除集合中的指定元素

```python
# remove()删除集合中的指定元素
s.remove(100)
s.remove(1000)
```

`clear()` 清空集合

```python
# clear()清空集合
s.clear()
```

`copy()` 对集合进行浅复制

```python
s.copy()
```

获取set的类型

```python
print(type(s))# <class 'set'>
```

# 集合的运算

在对集合做运算时，`不会影响原来的集合`，而是返回一个运算结果

## 取交集

```python
# 创建两个集合
s = {1,2,3,4,5}
s2 = {3,4,5,6,7}
# & 交集运算
result = s & s2 # {3, 4, 5}
```

## 取并集

```python
# | 并集运算
result = s | s2 # {1,2,3,4,5,6,7}
```

## 取差集

```python
result = s - s2 # {1, 2}
```

## 异或集

获取只在一个集合中出现的元素

```python
# ^ 异或集 获取只在一个集合中出现的元素
result = s ^ s2 # {1, 2, 6, 7}
```

## <=

判断一个集合是否为另一个集合的子集

```python
# <= 检查一个集合是否是另一个集合的子集
# 如果a集合中的元素全部都在b集合中出现，那么a集合就是b集合的子集，b集合是a集合超集
a = {1,2,3}
b = {1,2,3,4,5}
result = a <= b # True
result = {1,2,3} <= {1,2,3} # True
result = {1,2,3,4,5} <= {1,2,3} # False
```

## <

检查一个集合是否是另一个集合的真子集

```python
# < 检查一个集合是否是另一个集合的真子集
# 如果超集b中含有子集a中所有元素，并且b中还有a中没有的元素，则b就是a的真超集，a是b的真子集
result = {1,2,3} < {1,2,3} # False
result = {1,2,3} < {1,2,3,4,5} # True
```

## >=

检查一个集合是否是另一个的超集

## >

检查一个集合是否是另一个的真超集

# 函数

## 函数的定义

```python
# 函数的定义
def fn() :
    print('first function')
    print('hello')

fn();
print(type(fn)); # <class 'function'>

def sum(a, b) :
    print(f'a+b={a+b}')
sum(1,2)
```

## 函数的参数

### 指定参数的默认值

```python
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
```

### 参数的传递方式

位置参数

```python
# 位置参数
# 位置参数就是将对应位置的实参复制给对应位置的形参
# 第一个实参赋值给第一个形参，第二个实参赋值给第二个形参...
defaultParm(1, 2, 3);
```

关键字参数

```python
# 关键字参数
# 关键字参数，可以不按照形参定义的顺序去传递，而直接根据参数名去传递参数
defaultParm(b=1 , c=2 , a=3)
```

位置参数和关键字参数可以混合使用

```python
# 位置参数和关键字参数可以混合使用
print('hello' , end='')
# 混合使用关键字和位置参数时，必须将位置参数写到前面
defaultParm(1, c=30)
```

## 不定长参数

 在定义函数时，可以在形参前边加上一个`*`，这样这个形参将会获取到所有的实参

它将会将所有的实参保存到一个`元组`中

### 示例

定义一个函数，可以求任意个数字的和

```python
# 定义一个函数，可以求任意个数字的和
def sum(*nums):
    result = 0
    for n in nums :
        result += n
    print(result)
sum(123,456,789,10,20,30,40)
```

```python
a,b,*c = (1,2,3,4,5,6)
print('c=', c)# [3,4,5,6]
```

```python
# *a会接受所有的位置实参，并且会将这些实参统一保存到一个元组中（装包）
def fn(*a):
    print("a =",a,type(a))# <class 'tuple'>
fn(1,2,3,4,5)
```

### 规则

带*的参数只能有1个

```python
# 带星号的形参只能有一个
# 带星号的参数，可以和其他参数配合使用
# 第一个参数给a，第二个参数给b，剩下的都保存到c的元组中
def fn2(a,b,*c):
     print('a =',a)
     print('b =',b)
     print('c =',c)
```

可变参数不是必须写在最后，但是注意，`带*的参数后的所有参数，必须以关键字参数的形式传递`

```python
# 第一个参数给a，剩下的位置参数给b的元组，c必须使用关键字参数
def fn2(a,*b,c):
    print('a =',a)
    print('b =',b)
    print('c =',c)
# 所有的位置参数都给a，b和c必须使用关键字参数
def fn2(*a,b,c):
     print('a =',a)
     print('b =',b)
     print('c =',c)
fn2(1,2,3, b=2, c=4)
```

如果在形参的开头直接写一个*,则要求我们的所有的参数必须以`关键字参数的形式传递`

```python
# 如果在形参的开头直接写一个*,则要求我们的所有的参数必须以关键字参数的形式传递
def fn2(*,a,b,c):
    print('a =',a)
    print('b =',b)
    print('c =',c)
fn2(a=3,b=4,c=5)
```

*形参只能接收位置参数，而`不能接收关键字参数`

```python
# *形参只能接收位置参数，而不能接收关键字参数
def fn3(*a) :
     print('a =',a)
```

**形参可以接收其他的关键字参数，它会将这些参数统一保存到一个`字典`中

```python
# **形参可以接收其他的关键字参数，它会将这些参数统一保存到一个字典中
#   字典的key就是参数的名字，字典的value就是参数的值
# **形参只能有一个，并且必须写在所有参数的最后
def fn3(b,c,**a) :
    print('a =',a,type(a)) # a = {'d': 2, 'e': 10, 'f': 20} <class 'dict'>
    print('b =',b) # 1
    print('c =',c) # 3
fn3(b=1,d=2,c=3,e=10,f=20)
```

### 参数的解包

解析元组

```python
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
```

解析字典

```python
# 创建一个字典
d = {'a':100,'b':200,'c':300}
# 通过 **来对一个字典进行解包操作
fn4(**d)
```

## 文档字符串

使用 `help()` 可以查看函数的说明

```python
help(print)

Help on built-in function print in module builtins:

print(...)
    print(value, ..., sep=' ', end='\n', file=sys.stdout, flush=False)
    
    Prints the values to a stream, or to sys.stdout by default.
    Optional keyword arguments:
    file:  a file-like object (stream); defaults to the current sys.stdout.
    sep:   string inserted between values, default a space.
    end:   string appended after the last value, default a newline.
    flush: whether to forcibly flush the stream.
```

自定义文档注释

```python
def sum(value1:int, value2:int) -> int :
    '''
    对两个整形值求和

     函数的参数：
        value1，作用，类型，默认值。。。。
        value2，作用，类型，默认值。。。。
    '''
    return value1 + value2;
help(sum)
```

## 作用域与命名空间

### 作用域

全局作用域

* 全局作用域在程序执行时创建，在程序执行结束时销毁

* 所有函数以外的区域都是全局作用域

* 在全局作用域中定义的变量，都属于全局变量，全局变量可以在程序的任意位置被访问

函数作用域

* 函数作用域在函数调用时创建，在调用结束时销毁
* 函数每调用一次就会产生一个新的函数作用域
* 在函数作用域中定义的变量，都是局部变量，它只能在函数内部被访问

变量的查找

* 当我们使用变量时，会优先在当前作用域中寻找该变量，如果有则使用，
* 如果没有则继续去上一级作用域中寻找，如果有则使用，
* 如果依然没有则继续去上一级作用域中寻找，以此类推
* 直到找到全局作用域，依然没有找到，则会抛出异常 `NameError: name 'a' is not defined`

### 命名空间

命名空间指的是变量存储的位置，每一个变量都需要存储到指定的命名空间当中

每一个作用域都会有一个它对应的命名空间

全局命名空间，用来保存全局变量。函数命名空间用来保存函数中的变量

命名空间实际上就是一个字典，是一个专门用来存储变量的字典

#### 获取当前命名空间

```python
scope = locals() # 当前命名空间
print(type(scope))
```

向scope中添加一个key-value，但 `一般不建议这样做`

```python
print(a)
print(scope['a'])
# 向scope中添加一个key-value
scope['c'] = 1000 # 向字典中添加key-value就相当于在全局中创建了一个变量（一般不建议这么做）
print(c)
```

#### 函数命名空间

```python
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
```

## 高阶函数

接收 `函数作为参数`，或者将 `函数作为返回值` 的函数是高阶函数

```python
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
```

使用lambda表达式进行过滤

```python
lst = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
l = filter(lambda number : number % 3 == 0, lst)
print(list(l))# [3, 6, 9]
```

对列表进行排序

```python
# 对列表进行排序
lst = ['bb','aaaa','c','ddddddddd','fff'];
lst.sort(key=len)
print(lst) # ['c', 'bb', 'fff', 'aaaa', 'ddddddddd']

lst = [2,5,'1',3,'6','4']
lst.sort(key=int)
print(lst)# ['1', 2, 3, '4', 5, '6']
```

## 闭包

形成闭包的必要条件？

​	① 函数嵌套

​	② 将内部 `函数` 作为返回值 `返回`

​	③ 内部函数必须要 `使用到外部函数的变量`

```python
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
```

## 装饰器

现有如下两个函数：

```python
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
```

需求：希望函数可以在计算前，打印开始计算，计算结束后打印计算完毕。

我们可以直接通过修改函数中的代码来完成这个需求，但是会产生以下一些问题

​	① 如果要修改的函数过多，修改起来会比较麻烦

​	② 并且不方便后期的维护

​	③ 并且这样做会违反开闭原则（OCP）

### 方式一(在新的函数中调用旧函数)

```python
def fn():
    print('我是fn函数....')
def fn2():
    print('函数开始执行~~~')
    fn()
    print('函数执行结束~~~')
fn2();
```

存在的问题：这种方式要求每扩展一个函数就要手动创建一个新的函数，太麻烦了

### 方式二(对函数进行包装)

```python
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
```

像`begin_end()`这种函数我们就称它为`装饰器`

通过装饰器，可以在不修改原来函数的情况下来对函数进行扩展

在开发中，我们都是通过装饰器来扩展函数的功能的

### 方式三(通过@装饰器进行包装)

在定义函数时，可以通过@装饰器，来使用指定的装饰器，来装饰当前的函数

可以同时为一个函数指定多个装饰器，这样函数将会按照 `从内向外的顺序被装饰`

```python
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
# fn3装饰~开始执行~~~~
# 开始执行~~~~
# test
# 执行结束~~~~
# fn3装饰~执行结束~~~~
```

# 面向对象

## 类的定义

```python
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
```

## 对象的初始化

在类中可以定义一些特殊方法（魔术方法）

特殊方法都是以`__(双下划线)`开头，`__(双下划线)`结尾的方法

特殊方法不需要我们自己调用，不要尝试去调用特殊方法，`特殊方法将会在特殊的时刻自动调用`

> p1 = Person()的运行流程
>
> ​	1.创建一个变量
> ​	2.在内存中创建一个新对象
> ​    3.__init__(self)方法执行
> ​    4.将对象的id赋值给变量

```python
class TestInit :
    def __init__(self,name) :
        self.name = name;

    def sayHello(self) :
        print(f'你好!我是{self.name}')

ti1 = TestInit('ti1');
ti2 = TestInit('ti2');
ti1.sayHello();
ti2.sayHello();
```

## 封装

封装是面向对象的三大特性之一

封装指的是`隐藏`对象中一些`不希望被外部所访问`到的属性或方法

如何隐藏一个对象中的属性？

​	将对象的属性名，修改为一个外部不知道的名字

如何获取（修改）对象中的属性？

​	需要提供一个getter和setter方法使外部可以访问到属性

​	getter 获取对象中的指定属性（get_属性名）

​	setter 用来设置对象的指定属性（set_属性名）

使用封装，确实增加了类的定义的复杂程度，但是它也确保了数据的安全性

1. 隐藏了属性名，使调用者无法随意的修改对象中的属性

2. 增加了getter和setter方法，很好的控制的属性是否是只读的

3. 使用setter方法设置属性，可以增加数据的验证，确保数据的值是正确的

4. 使用getter方法获取属性，使用setter方法设置属性，可以在读取属性和修改属性的同时做一些其他的处理

5. 使用getter方法可以表示一些计算的属性

### 第一种方式(重命名属性名)

```python
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
```

### 第二种方式(使用双下划线开头命名私有属性)

双下划线开头的属性，是对象的隐藏属性，隐藏属性只能在类的内部访问，无法通过对象访问

其实隐藏属性只不过是Python自动为属性改了一个名字

实际上是将名字修改为了，`_类名__属性名 比如 __name -> _Person__name`

```python
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
```

### 方式三`推荐使用`(使用_开头命名私有属性,约定俗成)

```python
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
```

### 使用装饰器优化getter和setter

```python
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
```



## 继承

继承是面向对象三大特性之一

通过继承我们可以使一个类获取到其他类中的属性和方法

在定义类时，可以在 `类名后的括号中指定当前类的父类`（超类、基类、super）

### 继承&重写

```python
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
```

### object

在创建类时，如果省略了父类，则默认父类为object

object是所有类的父类，所有类都继承自object

```python
class Person():
    pass
print(isinstance(Person,object)) # True
print(isinstance(print,object)) # True
```

### 重写特殊方法

```python
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
```

### 多重继承

在Python中是支持多重继承的，也就是我们可以为一个类同时指定多个父类

可以在类名的()后边添加多个类，来实现多重继承,如`class C(A,B):`

多重继承，会使子类同时拥有多个父类，并且会获取到所有父类中的方法

在开发中没有特殊的情况，应该`尽量避免使用多重继承`，因为多重继承会让我们的代码过于复杂

`如果多个父类中有同名的方法，则会现在第一个父类中寻找，然后找第二个，然后找第三个。。。`

```python
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
```

## 多态

`多态` 就是指一个对象可以以不同的形态去呈现

## 面向对象总结

封装

- 确保对象中的数据安全

继承

- 保证了对象的可扩展性

多态

- 保证了程序的灵活性

## 类中的属性和方法

`类属性`：直接在类中定义的属性是类属性

* 类属性可以通过`类`或类的`实例`访问到
* 但是类属性`只能通过类对象来修改`，无法通过实例对象修改

```python
class Test :
    # 类属性,可以通过类或实例访问到，但只能通过类来修改
    count = 0;

# 类属性,可以通过类或实例访问到，但只能通过类来修改
t = Test();
print(Test.count) # 0
print(t.count) # 0
Test.count = 10;
print(t.count) # 10
t.count = 20;
print(t.count, Test.count) # 20 10
```



`实例属性`：通过实例对象添加的属性属于实例属性

* 实例属性`只能通过实例对象来访问和修改`，类对象无法访问修改

```python
# 类中的属性和方法
class Test :
    # 实例属性,只能通过实例属性访问和修改
    def __init__(self) :
        self.name = '齐天大圣'

# 实例属性,只能通过实例属性访问和修改
t = Test();
# print(Test.name) # type object 'Test' has no attribute 'name'
print(t.name)
```



`类方法`：在类内部使用 @classmethod 来修饰的方法属于类方法

* 类方法的第一个参数是cls，也会被自动传递，cls就是当前的类对象
* 类方法和实例方法的区别，实例方法的第一个参数是self，而类方法的第一个参数是cls
* 类方法可以通过类去调用，也可以通过实例调用，没有区别

```python
# 类中的属性和方法
class Test :

    # 类方法,可以通过实例和类访问,第一个参数会传入类型
    @classmethod
    def classMethod(clazz) :
        print(clazz)
        print('我是类方法')
        
# 类方法,可以通过实例和类访问,第一个参数会传入类型
Test.classMethod(); # <class '__main__.Test'>
t = Test();
t.classMethod(); # <class '__main__.Test'>
```



`实例方法`：在类中定义，以self为第一个参数的方法都是实例方法

* 实例方法在调用时，Python会将调用对象作为self传入 
* 实例方法可以通过实例和类去调用
  * 当通过实例调用时，会自动将当前调用对象作为self传入
  * 当通过类调用时，不会自动传递self，此时我们必须手动传递self

```python
# 类中的属性和方法
class Test :
    # 实例方法,可以通过类或实例取访问，但通过类访问时，不会传入第一个参数self
    def instanceMethod(self) :
        print(self.name)

# 实例方法,可以通过类或实例取访问，但通过类访问时，不会传入第一个参数self
t = Test();
t.instanceMethod()
# Test.instanceMethod() # instanceMethod() missing 1 required positional argument: 'self'
```



`静态方法`：在类中使用 @staticmethod 来修饰的方法属于静态方法 

* 静态方法不需要指定任何的默认参数，静态方法可以通过类和实例去调用
* 静态方法，基本上是一个和当前类无关的方法，它只是一个保存到当前类中的函数
* 静态方法一般都是一些工具方法，和当前类无关

```python
# 类中的属性和方法
class Test :
    # 静态方法，静态方法一般为工具方法,可以通过类或实例访问
    @staticmethod
    def static_method() :
        print('我是静态方法')

# 静态方法，静态方法一般为工具方法,可以通过类或实例访问
t = Test();
t.static_method()
Test.static_method()
```

## 特殊方法

特殊方法，也称为魔术方法

特殊方法都是使用__开头和结尾的

特殊方法一般`不需要我们手动调用，需要在一些特殊情况下自动执行`

实例上类似java Object类中的方法

```python
# 定义一个Person类
class Person(object):
    """人类"""
    def __init__(self, name , age):
        self.name = name
        self.age = age

    # __str__（）这个特殊方法会在尝试将对象转换为字符串的时候调用
    # 它的作用可以用来指定对象转换为字符串的结果  （print函数）  
    def __str__(self):
        return 'Person [name=%s , age=%d]'%(self.name,self.age)        

    # __repr__()这个特殊方法会在对当前对象使用repr()函数时调用
    # 它的作用是指定对象在 ‘交互模式’中直接输出的效果    
    def __repr__(self):
        return 'Hello'        

    # object.__add__(self, other)
    # object.__sub__(self, other)
    # object.__mul__(self, other)
    # object.__matmul__(self, other)
    # object.__truediv__(self, other)
    # object.__floordiv__(self, other)
    # object.__mod__(self, other)
    # object.__divmod__(self, other)
    # object.__pow__(self, other[, modulo])
    # object.__lshift__(self, other)
    # object.__rshift__(self, other)
    # object.__and__(self, other)
    # object.__xor__(self, other)
    # object.__or__(self, other)

    # object.__lt__(self, other) 小于 <
    # object.__le__(self, other) 小于等于 <=
    # object.__eq__(self, other) 等于 ==
    # object.__ne__(self, other) 不等于 !=
    # object.__gt__(self, other) 大于 >
    # object.__ge__(self, other) 大于等于 >= 
    
    # __len__()获取对象的长度

    # object.__bool__(self)
    # 可以通过bool来指定对象转换为布尔值的情况
    def __bool__(self):
        return self.age > 17

    # __gt__会在对象做大于比较的时候调用，该方法的返回值将会作为比较的结果
    # 他需要两个参数，一个self表示当前对象，other表示和当前对象比较的对象
    # self > other
    def __gt__(self , other):
        return self.age > other.age
    

# 创建两个Person类的实例        
p1 = Person('孙悟空',18)
p2 = Person('猪八戒',28)

# 打印p1
# 当我们打印一个对象时，实际上打印的是对象的中特殊方法 __str__()的返回值
print(p1)
print(p2)

print(repr(p1))

print(p1 > p2)
print(p2 > p1)
```

# 模块化

模块化，模块化指将一个完整的程序分解为一个一个小的模块，不采用模块化，统一将所有的代码编写到一个文件中，采用模块化，将程序分别编写到多个文件中。

在Python中`一个py文件就是一个模块`，要想创建模块，实际上就是创建一个python文件

## 模块的使用

引入模块

```python
# 引入test_moudle模块
import test_moudle as test
```

`__name__`

* 在每一个模块内部都有一个`__name__`属性，通过这个属性可以获取到模块的名字
* `__name__`属性值为 `__main__`的模块是主模块，一个程序中只会有一个主模块

```python
# 引入test_moudle模块
import test_moudle as test

print(test.__name__) # test_moudle
print(__name__) # __main__

```

访问模块中的变量、函数、类

```python
# 访问模块中的变量、函数、类
print('testA:', test.testA)
print('testB:', test.testB)
test.testFun();
p = test.Person();
print(p)
```

导入模块的几种方式

```python
# 导入模块的几种方式
# import xxx
# import xxx as yyy
# from xxx import yyy , zzz , fff
# from xxx import * # 这种方式一般不用
# from xxx import yyy as zz
```

变量隐藏

```python
# test_moudle.py
_c = 30

# 主模块.py
# 添加了_的变量，只能在模块内部访问，在通过import * 引入时，不会引入_开头的变量
from test_moudle import *
# print(_c) # name '_c' is not defined
print(test._c) # 可以正常访问
```

导入模块后不执行测试代码

```python
# 编写测试代码，这部分代码，只要当当前文件作为主模块的时候才需要执行
#   而当模块被其他模块引入时，不需要执行的，此时我们就必须要检查当前模块是否是主模块  
if __name__ == '__main__':
    testFun()
```

## 包

包也是一个模块

当我们模块中代码过多时，或者一个模块需要被分解为多个模块时，这时就需要使用到包

普通的模块就是一个py文件，而包是一个文件夹

包中必须要一个`__init__.py` 这个文件，这个文件中可以包含有包中的主要内容

```python
# 包
from testPack import a,b
print(a.a)
print(b.b)
```

`__pycache__` 

* `__pycache__` 是模块的缓存文件
* py代码在执行前，需要被解析器先`转换为机器码，然后再执行`。所以我们在使用模块（包）时，也需要将模块的代码先转换为机器码然后再交由计算机执行,而为了提高程序运行的性能，`python会在编译过一次以后，将代码保存到一个缓存文件中`，这样在下次加载这个模块（包）时，就可以`不再重新编译`而是直接加载缓存中编译好的代码即可

# Python标准库

## sys模块

```python
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
```

## os模块

```python
# os 模块让我们可以对操作系统进行访问
import os

# os.environ
# 通过这个属性可以获取到系统的环境变量
pprint.pprint(os.environ['path'])

# os.system()
# 可以用来执行操作系统的名字
os.system('dir')
os.system('notepad')
```

# 异常

`try except代码块的基本使用`

```python
print('hello')
try:
    print(10 / 0) # ZeroDivisionError: division by zero
except:
    print('出错了')
else:
    print('未出错')
```

异常类型

* Exception 是所有异常类的父类，所以如果except后跟的是Exception，他也会捕获到所有的异常

```python
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
```

抛出异常

```python
# 自定义异常
class IllegalArgumentException(Exception):
    pass;

# 参数为None时，抛出异常
def getName(obj):
    if(obj == None):
        raise IllegalArgumentException('参数Obj不能')
getName(None)
```

# 文件操作

## 打开文件

```python
open(file, mode='r', buffering=-1, encoding=None, errors=None, newline=None, closefd=True, opener=None)
Open file and return a stream.  Raise OSError upon failure.
```

```python
file = 'demo.txt'

# 绝对路径
file = r'C:\Users\wl\Desktop\hello.txt'

# 相对路径
file = '../file/demo.txt'
file = 'file\\demo.txt' 
file = r'file\demo.txt'

fileStream = open(file);
print(fileStream) # <_io.TextIOWrapper name='demo.txt' mode='r' encoding='cp936'>
```

## 关闭文件

当我们获取了文件对象以后，所有的对文件的操作都应该通过对象来进行，例如 `读取文件中的内容` 。

`read()` 方法，用来读取文件中的内容，它会将内容全部保存为一个字符串返回。

使用完文件对象后,需要 `关闭文件`

### `close`

```python
content = fileStream.read();
print(content)
# 使用完文件对象后,需要关闭文件
fileStream.close()
# content = fileStream.read() # 报错,文件对象关闭后将不能再对文件对象进行任何操作
```

### `with ... as 语句`

```python
# with open(file_name) as file_obj :
#     # 在with语句中可以直接使用file_obj来做文件操作
#     # 此时这个文件只能在with中使用，一旦with结束则文件会自动close()
#     print(file_obj.read())
try:
    with open(file) as fileStream:
        print(fileStream.read())
except FileNotFoundError:
    print(f'{file} 文件不存在~~')
```

## 文件的读取

```python
file_path = 'demo2.txt'
try:
    # 调用open()来打开一个文件，可以将文件分成两种类型
    # 一种，是纯文本文件（使用utf-8等编码编写的文本文件）
    # 一种，是二进制文件（图片、mp3、ppt等这些文件）
    # open()打开文件时，默认是以文本文件的形式打开的，但是open()默认的编码为None
    #   所以处理文本文件时，必须要指定文件的编码
    with open(file_path,encoding='utf-8') as file_obj:
        # 通过 read() 来读取文件中的内容
        # 如果直接调用read()它会将文本文件的所有内容全部都读取出来
        #   如果要读取的文件较大的话，会一次性将文件的内容加载到内存中，容易导致内存泄漏
        #   所以对于较大的文件，不要直接调用read()
        # help(file_obj.read)
        # read()可以接收一个size作为参数，该参数用来指定要读取的字符的数量
        #   默认值为-1，它会读取文件中的所有字符
        #   可以为size指定一个值，这样read()会读取指定数量的字符，
        #       每一次读取都是从上次读取到位置开始读取的
        #       如果字符的数量小于size，则会读取剩余所有的
        #       如果已经读取到了文件的最后了，则会返回''空串
        content = file_obj.read(6);
        print(content)
        content = file_obj.read(6);
        print(content)
        content = file_obj.read(6);
        print(content)
        content = file_obj.read(6);
        print(content)
        content = file_obj.read(6);
        print(content)
        content = file_obj.read(6);
        print(content)
except Exception as e:
    print(e)
```

读取大文件

```python
file_path = 'demo.txt'
try:
    with open(file_path,encoding='utf-8') as file_obj:
        file_content = '';
        buffer_size = 10;
        while True:
            file_content = file_obj.read(10)
            if not file_content :
                break
            print(file_content)
except Exception as e:
    print(e)
```

读取一行内容

```python
file_path = 'demo.txt'
with open(file_path, encoding='utf-8') as file_obj:
    # readline()
    # 该方法可以用来读取一行内容
    # print(file_obj.readline(), end='')
    # print(file_obj.readline())
    # print(file_obj.readline())

    # readlines()
    # 该方法用于一行一行的读取内容，它会一次性将读取到的内容封装到一个列表中返回
    # lines = file_obj.readlines()
    # for line in lines:
    #     print(line)

    # 直接遍历文件流就是进行一行一行的读取
    for t in file_obj:
        print(t)
```

## 打开文件的模式

使用`open()`打开文件时必须要指定打开文件所要做的操作（读、写、追加）

如果不指定操作类型，则`默认是 读取文件` ， 而读取文件时是不能向文件中写入的

* `r`： 表示只读的

* `w`： 表示是可写的，使用w来写入文件时，如果文件不存在会创建文件，如果文件存在则会截断文件

  ​			截断文件指删除原来文件中的所有内容

* `a`： 表示追加内容，如果文件不存在会创建文件，如果文件存在则会向文件中追加内容

* `x`： 用来新建文件，如果文件不存在则创建，存在则报错

+为操作符增加功能

* `r+` ：既可读又可写，文件不存在会报错

* `w+`：既可写又可读

* `a+`：即可追加也可读

## 写入内容到文件

```python
file_path = 'demo_x.txt'
with open(file_path , 'x' , encoding='utf-8') as file_obj:
    # write()来向文件中写入内容，
    # 如果操作的是一个文本文件的话，则write()需要传递一个字符串作为参数
    # 该方法会可以分多次向文件中写入内容
    # 写入完成以后，该方法会返回写入的字符的个数
    file_obj.write('aaa\n')
    file_obj.write('bbb\n')
    file_obj.write('ccc\n')
    r = file_obj.write(str(123)+'123123\n')
    r = file_obj.write('今天天气真不错')
    print(r)
```

## 操作二进制文件

读取模式

* `t`： 读取文本文件（默认值）

* `b`： 读取二进制文件

```python
file_path = r'C:\Users\wl\Desktop\告白气球.flac'
with open(file_path, 'rb') as file_obj:
    # 读取文本文件时，size是以字符为单位的
    # 读取二进制文件时，size是以字节为单位

    # 将读取的内容写入到另一个文件
    with open('new告白气球.flac', 'wb') as new_stream:
        buffer_size = 1024 * 100;
        while True:
            content = file_obj.read(buffer_size)
            if not content:
                break
            new_stream.write(content)
```

## 常见操作

* `seek`

  修改当前读取的位置

* `tell`

  查看当前读取的位置

```python
# seek()可以修改当前读取的位置
# seek()需要两个参数
#   第一个 是要切换到的位置
#   第二个 计算位置方式
#     可选值：
#        0 从头计算，默认值
#        1 从当前位置计算
#        2 从最后位置开始计算

with open('demo2.txt', 'rt', encoding='utf-8') as input_stream:
    print('当前读取到的位置:', input_stream.tell()) # 0
    input_stream.seek(9) # 9
    print('当前读取到的位置:', input_stream.tell())
    print(input_stream.read())

    # tell() 方法用来查看当前读取的位置
    print('当前读取到的位置:', input_stream.tell())# 66
```

## 文件其他操作

* 获取指定目录下的目录结构

  ```python
  # 获取指定目录下的目录结构
  #   需要一个路径作为参数，会获取到该路径下的目录结构，默认路径为 . 当前目录
  #   该方法会返回一个列表，目录中的每一个文件（夹）的名字都是列表中的一个元素
  r = os.listdir();
  pprint(r)
  ```

* 获取当前所在的目录

  ```python
  r = os.getcwd()
  pprint(r)
  ```

* 切换目录

  ```python
  # os.chdir() 切换当前所在的目录 作用相当于 cd
  os.chdir('d:/log')
  pprint(os.getcwd())
  ```

* 创建目录

  ```python
  # 创建目录
  os.mkdir('mylog')
  ```

* 删除目录

  ```python
  # 删除目录
  os.rmdir('mylog
  ```

* 重命名文件/目录

  ```python
  # 重命名
  os.mkdir('oldlog')
  os.rename('oldlog', 'newlog')
  ```

* 通过重命名移动文件

  ```python
  os.rename('log.log','d:/log/newlong/bb.txt')
  ```

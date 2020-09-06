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

# 使用 dict()函数来创建字典
# 每一个参数都是一个键值对，参数名就是键，参数名就是值（这种方式创建的字典，key都是字符串）
d = dict(name='孙悟空',age=18,gender='男') 
print(d)

# 也可以将一个包含有双值子序列的序列转换为字典
# 双值序列，序列中只有两个值，[1,2] ('a',3) 'ab'
# 子序列，如果序列中的元素也是序列，那么我们就称这个元素为子序列
# [(1,2),(3,5)]
d = dict([('name','孙悟饭'),('age',18)])
# print(d , type(d))
d = dict(name='孙悟空',age=18,gender='男') 

# 获取字典中键值对的个数
# len() 获取字典中键值对的个数
print(len(d))

# in 检查字典中是否包含指定的键
# not in 检查字典中是否不包含指定的键
print('hello' in d)

# 获取字典中的值，根据键来获取值
# 语法：d[key]
print(d['age'])
n = 'name'
print(d[n])

# 通过[]来获取值时，如果键不存在，会抛出异常 KeyError
# get(key[, default]) 该方法用来根据键来获取字典中的值
#   如果获取的键在字典中不存在，会返回None
#   也可以指定一个默认值，来作为第二个参数，这样获取不到值时将会返回默认值
print(d.get('name'))
print(d.get('hello','默认值'))


# 修改字典
# d[key] = value 如果key存在则覆盖，不存在则添加
d['name'] = 'sunwukong' # 修改字典的key-value
d['address'] = '花果山' # 向字典中添加key-value
print(d)

# setdefault(key[, default]) 可以用来向字典中添加key-value
#   如果key已经存在于字典中，则返回key的值，不会对字典做任何操作
#   如果key不存在，则向字典中添加这个key，并设置value
result = d.setdefault('name','猪八戒')
result = d.setdefault('hello','猪八戒')
print(d)

# update([other])
# 将其他的字典中的key-value添加到当前字典中
# 如果有重复的key，则后边的会替换到当前的
d = {'a':1,'b':2,'c':3}
d2 = {'d':4,'e':5,'f':6, 'a':7}
d.update(d2)
print(d)

# 删除，可以使用 del 来删除字典中的 key-value
del d['a']
del d['b']
print(d)

# popitem()
# 随机删除字典中的一个键值对，一般都会删除最后一个键值对
#   删除之后，它会将删除的key-value作为返回值返回
#   返回的是一个元组，元组中有两个元素，第一个元素是删除的key，第二个是删除的value
# 当使用popitem()删除一个空字典时，会抛出异常 KeyError: 'popitem(): dictionary is empty'
d.popitem()
result = d.popitem()
print(result)


# pop(key[, default])
# 根据key删除字典中的key-value
# 会将被删除的value返回！
# 如果删除不存在的key，会抛出异常
#   如果指定了默认值，再删除不存在的key时，不会报错，而是直接返回默认值
result = d.pop('d')
result = d.pop('z','这是默认值')
print(result)

# clear()用来清空字典
d.clear()
print(d)

# copy()
# 该方法用于对字典进行浅复制
# 复制以后的对象，和原对象是独立，修改一个不会影响另一个
# 注意，浅复制会简单复制对象内部的值，如果值也是一个可变对象，这个可变对象不会被复制
d = {'a':1,'b':2,'c':{'v':'我是c'}}
d2 = d.copy()
d['a'] = 100
d['c']['v']='我是d中的c'
print(d2) # a对应的值未变,c对应的值改变

# 遍历字典
# keys() 该方法会返回字典的所有的key
#   该方法会返回一个序列，序列中保存有字典的所有的键
d = {'name':'孙悟空','age':18,'gender':'男'}
for k in d.keys() :
    print(k , d[k])

# values()
# 该方法会返回一个序列，序列中保存有字典的的值
for v in d.values():
    print(v)

# items()
# 该方法会返回字典中所有的项
# 它会返回一个序列，序列中包含有双值子序列
# 双值分别是，字典中的key和value
# print(d.items())
for k,v in d.items() :
    print(k , '=' , v)

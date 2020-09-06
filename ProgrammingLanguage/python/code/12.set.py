# 创建集合
s = {'a' , 'b' , 1 , 2 , 3 , 1}
print(s)

# 使用set创建集合
s = set('hello')

# 使用set()将字典转换为集合时，只会包含字典中的键
s = set({'a':1,'b':2,'c':3})
print(s)

# 使用in和not in来检查集合中的元素
print('c' in s)


# 使用len()来获取集合中元素的数量
print(len(s))

# add() 向集合中添加元素
s.add(10)
s.add(30)

# update() 将一个集合中的元素添加到当前集合中
#   update()可以传递序列或字典作为参数，字典只会使用键
s2 = set('hello')
s.update(s2)
s.update((10,20,30,40,50))
s.update({10:'ab',20:'bc',100:'cd',1000:'ef'})
print(s)

result = s.pop()
print(result)

# remove()删除集合中的指定元素
s.remove(100)
s.remove(1000)


# clear()清空集合
s.clear()

# copy()对集合进行浅复制
s.copy()

print(type(s))# <class 'set'>

# 初始化列表
myList = []; # 创建空列表
myList = [10];
myList = [10, 20, 'hello', True, False];

# 获取列表长度
print(len(myList));

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

# 列表合并
myList = [1,2,3] + [4,5,6];
print(myList);# 1,2,3,4,5,6

# * 可以将列表重复指定的次数
myList = [1,2,3] * 6;
print(myList); # 1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3

# in & not in
myList = ['张三', '李四', '王五', '赵六'];
zhangsanIsIn = '张三' in myList;
print(zhangsanIsIn);# True
print('张三' not in myList);# False

# 求列表长度
print(len(myList)); # 4

# 求最小值最大值
myList = [2,1,3,4,5]
print(min(myList));# 1
print(max(myList));# 5

# 获取元素索引
print(myList.index(3));# 2

# 求元素出现的个数
myList = ['张三', '李四', '张三', '王五'];
print(myList.count('张三'));# 2


###################################
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


########################################
# 列表的方法
stus = ['孙悟空','猪八戒','沙和尚','唐僧'];
print('原列表：',stus);

#append() 
# 向列表的最后添加一个元素
stus.append('唐僧')

# insert()
# 向列表的指定位置插入一个元素
# 参数：
#   1.要插入的位置
#   2.要插入的元素
# stus.insert(2,'唐僧')

# extend()
# 使用新的序列来扩展当前序列
# 需要一个序列作为参数，它会将该序列中的元素添加到当前列表中
# stus.extend(['唐僧','白骨精'])
# stus += ['唐僧','白骨精']

# clear()
# 清空序列
# stus.clear()

# pop()
# 根据索引删除并返回被删除的元素

# result = stus.pop(2) # 删除索引为2的元素
# result = stus.pop() # 删除最后一个
# print('result =',result)

# remove()
# 删除指定值得元素，如果相同值得元素有多个，只会删除第一个
# stus.remove('猪八戒')

# reverse()
# 用来反转列表
# stus.reverse()

# sort()
# 用来对列表中的元素进行排序，默认是升序排列
# 如果需要降序排列，则需要传递一个reverse=True作为参数
my_list = list('asnbdnbasdabd')
my_list = [10,1,20,3,4,5,0,-2]

print('修改前',my_list)

my_list.sort(reverse=True)
print('修改后',my_list)
# print('修改后：',stus)


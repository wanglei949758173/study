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


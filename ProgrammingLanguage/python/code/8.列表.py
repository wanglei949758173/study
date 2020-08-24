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

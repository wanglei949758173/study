# and
a = True and False;
print(a);# False
a = not False;
print(a);# True
a = True or False;
print(a);# True

# 条件运算符
a = -1;
result = '';
if (a <= 0):
    result = '小于等于0';
else:
    result = '大于0';

print(result);


age = 200;
if (age > 199):
    print('老妖怪');
elif (age > 100):
    print('长寿秘诀能告诉我吗?');
elif (age > 50):
    print('祝您活过百岁');
else:
    print('努力生活吧');

age = int(input('请输入您的年龄'));
if (age > 199):
    print('老妖怪');
elif (age > 100):
    print('长寿秘诀能告诉我吗?');
elif (age > 50):
    print('祝您活过百岁');
else:
    print('努力生活吧');

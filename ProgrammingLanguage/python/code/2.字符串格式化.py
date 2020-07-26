# 使用占位符
str = 'hello %s'%'小明'
str = 'hello %s和%s'%('小明','小红')
str = 'hello %3.5s'%'abcdefg' # %3.5s字符串的长度限制在3-5之间
str = 'hello %s'%123.456
str = 'hello %.2f'%123.456
str = 'hello %d'%123.456


# 使用f进行字符串的格式化
name='张三'
age=40
str = f'你好，小明! 我是{name},今年{age}岁了。'
print(str)

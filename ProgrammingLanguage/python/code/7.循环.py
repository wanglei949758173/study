# while循环
i = 0;
sum = 0;
while (i < 10) :
    i += 1;
    print(i);
    sum += i;
else :
    print(f'else代码块,总和={sum}');

# 使用pass站位
i = 10;
if(i == 10):
    pass;# 写代码调试时可以使用pass占位,让程序可以通过编译

# 文件操作
print("===打开文件===")
help(open)
# open(file, mode='r', buffering=-1, encoding=None, errors=None, newline=None, closefd=True, opener=None)
# Open file and return a stream.  Raise OSError upon failure.
file = 'demo.txt'

# 绝对路径
file = r'C:\Users\wl\Desktop\hello.txt'

# 相对路径
file = '../file/demo.txt'
file = 'file\\demo.txt' 
file = r'file\demo.txt'

fileStream = open(file);
print(fileStream) # <_io.TextIOWrapper name='demo.txt' mode='r' encoding='cp936'>


print("===关闭文件===")
# 当我们获取了文件对象以后，所有的对文件的操作都应该通过对象来进行
# 读取文件中的内容
# read()方法，用来读取文件中的内容，它会将内容全部保存为一个字符串返回
content = fileStream.read();
print(content)
# 使用完文件对象后,需要关闭文件
fileStream.close()
# content = fileStream.read() # 报错,文件对象关闭后将不能再对文件对象进行任何操作

# with ... as 语句
# with open(file_name) as file_obj :
#     # 在with语句中可以直接使用file_obj来做文件操作
#     # 此时这个文件只能在with中使用，一旦with结束则文件会自动close()
#     print(file_obj.read())
try:
    with open(file) as fileStream:
        print(fileStream.read())
except FileNotFoundError:
    print(f'{file} 文件不存在~~')

print("===文件的读取===")
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

# 读取大文件的方式
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
    
    


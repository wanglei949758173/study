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

# 读取一行内容
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
    
print("===文件的写入===")
# 使用open()打开文件时必须要指定打开文件所要做的操作（读、写、追加）
# 如果不指定操作类型，则默认是 读取文件 ， 而读取文件时是不能向文件中写入的
# r 表示只读的
# w 表示是可写的，使用w来写入文件时，如果文件不存在会创建文件，如果文件存在则会截断文件
#   截断文件指删除原来文件中的所有内容
# a 表示追加内容，如果文件不存在会创建文件，如果文件存在则会向文件中追加内容
# x 用来新建文件，如果文件不存在则创建，存在则报错
# + 为操作符增加功能
#   r+ 即可读又可写，文件不存在会报错
#   w+
#   a+
5file_path = 'demo_x.txt'
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

print("===操作二进制文件===")
# 读取模式
# t 读取文本文件（默认值）
# b 读取二进制文件
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

import os
from pprint import pprint
print("===文件常见操作===")
# seek()可 以修改当前读取的位置
# seek()需要两个参数
#   第一个 是要切换到的位置
#   第二个 计算位置方式
#     可选值：
#        0 从头计算，默认值
#        1 从当前位置计算
#        2 从最后位置开始计算

with open('demo2.txt', 'rt', encoding='utf-8') as input_stream:
    print('当前读取到的位置:', input_stream.tell()) # 0
    input_stream.seek(9) # 9
    print('当前读取到的位置:', input_stream.tell())
    print(input_stream.read())

    # tell() 方法用来查看当前读取的位置
    print('当前读取到的位置:', input_stream.tell())# 66
    
# 获取指定目录下的目录结构
#   需要一个路径作为参数，会获取到该路径下的目录结构，默认路径为 . 当前目录
#   该方法会返回一个列表，目录中的每一个文件（夹）的名字都是列表中的一个元素
r = os.listdir();
pprint(r)

# 获取当前所在的目录
r = os.getcwd()
pprint(r)

# os.chdir() 切换当前所在的目录 作用相当于 cd
os.chdir('d:/log')
pprint(os.getcwd())

# 创建目录
os.mkdir('mylog')

# 删除目录
os.rmdir('mylog')

# 重命名
os.mkdir('oldlog')
os.rename('oldlog', 'newlog')

# 通过重命名移动文件
os.rename('log.log','d:/log/newlong/bb.txt')

# linux目录结构

* /dev 是device的意思，该目录下存储linux的外部设备
* /mnt 用户临时挂载别的文件系统的目录
* /proc 是processes的缩写，是系统内存的映射
* /run 存储系统启动以来的信息，重新会被删除
* /srv 存储对外提供服务的文件，如：web页面，后台服务
* /tmp 用来存储临时文件，可直接删除，如软件的压缩包
* /var 用来存储缓存文件，如日志、数据库文件等
* /media linux识别u盘、光驱等设备后，会把识别的设备挂载到这个目录下
* /opt optinal的缩写，用于安装大型的可选软件，如游戏等，相当于windows下的d:/software
* /usr 用于存放比较重要软件的安装文件，相当于windows下的c:/programfiles

# vi&vim

* 复制 5yy(复制5行)
* 粘贴 p
* 撤销 u
* 恢复 ctrl+r
* 删除 dd
* 设置行号 :setnu
* 跳转至某行 10 shif+g(跳转至第10行)
* 查找某个字符 /hello (查找hello字符) n (定位到下一个hello)
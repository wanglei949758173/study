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

# 实用指令

* 立即关机：shutdown -h now

## 帮助指令

* man ls （获取ls指令的帮助信息）
* help cd （获取cd指令的帮助信息）

## 文件目录类

* mkdir -p /tmp/animal/tiger 创建多级目录

* cp -r /tmp/animal /tmp/zoo 递归的将/tmp/animal 目录拷贝到/tmp/zoo下

* mv /tmp/helloworld.java /tmp/HelloWorld.java 重命名文件

* mv /tmp/animal /tmp/zoo/animal 将/tmp/animal移动到/tmp/zoo/animal

* cat -n /etc/profile | more 以显示行号的方式查看文件

* more 

  空格：下翻页 	回车：下一行	ctrl+F：下翻页：ctrl+B：上翻页

* less

  less /etc/services  查看文件

  pagedown：下翻页	pageup：上翻页	/字符串：向下查找某个字符串,n：向下查找；N：向上查找

* `>` 输出重定向，会 **覆盖原来的内容**

* `>>` 追加内容

* tail -n 5 /etc/profile 查看最后5行的内容

* ln -s /root /tmp/linkToRoot 创建软连接linkToRoot,连接到/root目录

* 删除软<span style='color:red'>连接时不要删除/tmp/linkToRoot/</span> ，<span style='color:green'>应该删除/tmp/linkToRoot</span>

* date -s "2020-10-10 20:56:00" 设置系统当前时间

* find /tmp -name *.txt 在tmp目录下查找名字为*.txt的文件

* find /tmp -user root 按用户名查找

* find / -size +20M 按文件大小查找 (+表示大于,-小于,无符号等于)

* unzip -d /tmp/zz /tmp/z.zip 解压z.zip到zz目录下

* tar

  -c：产生.tar打包文件 	-v：显示详细信息	-f：指定压缩后的文件名

  -z：打包同时压缩	-x：解包.tar文件

  tar -zcvf a.tar.gz a1.txt a2.txt 将a1.txt和a2.txt压缩成a.tar.gz

  tar -zcvf test.tar.gz test 将test文件夹压缩成test.tar.gz

  tar -zxvf test.tar.gz -C test 将test.tar.gz解压到test下

# 磁盘指令

* 查看系统分区情况：lsblk -f

  ![image-20201220103806919](linux笔记总结.assets/image-20201220103806919.png)

* 查看系统整体磁盘使用情况：df -h

  ![image-20201220103852000](linux笔记总结.assets/image-20201220103852000.png)

* 查看指定目录的磁盘占用情况：du -h

  查看/home目录的磁盘占用情况：du -ach --max-depth=1 /home

  ![image-20201220104100720](linux笔记总结.assets/image-20201220104100720.png)

# 进程管理

* 查看是否存在sshd服务：ps -aux | grep sshd
* 查看所有服务名：systemctl list-unit-files
* 动态监控进程，每10秒自动更新：top -d 10
* 查看服务sshd的网络情况：netstat -anp | grep sshd

# rpm&yum

* 查看linux有没有安装firefox：rpm -qa | grep firefox
* 查看软件包安装到了什么地方：rpm -ql 软件包名
* 删除firefox：rpm -e firefox
* 安装firefox：rpm -ivh xxx.rpm
* 查看yum服务器是否存在firefox：yum list | grep firefox
* 安装firefox：yum install firefox
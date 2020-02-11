# 创建配置文件my.ini
```
[mysqld]
basedir=D:/Program Files (x86)/mariadb-10.3.10-winx64
datadir=D:/Program Files (x86)/mariadb-10.3.10-winx64/data
character_set_server=utf8
max_connections=200
port=3306

[client]
port=3306
default_character_set=utf8

[WinMySQLAdmin]
Server=D:/Program Files (x86)/mariadb-10.3.10-winx64/bin/mysqld.exe
```

# 安装
```
::指定创建服务的程序
@set mysql_service="D:\Program Files (x86)\mariadb-10.3.10-winx64\bin\mysqld.exe"
::设置服务名
@set service_name="MariaDB"

::安装服务
%mysql_service% --install %service_name% --defaults-file="D:\Program Files (x86)\mariadb-10.3.10-winx64\my.ini"
Pause
```

# 启动服务
`net start MariaDB`

# 设置root用户密码
```
set password for 'root'@'localhost' = password('jdsn');
```

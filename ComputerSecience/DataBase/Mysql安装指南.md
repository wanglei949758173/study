# Mysql压缩版安装指南
## 1.解压文件

## 2. 创建配置文件
```ini
[mysqld]
# set basedir to your installation path
basedir=C:/Program Files (x86)/mysql-5.7.25-winx64
# set datadir to the location of your data directory
datadir==C:/Program Files (x86)/mysql-5.7.25-winx64/data
character_set_server=utf8
port=3307
```

## 3. 初始化data目录
`mysqld --initialize`

## 4. 安装为系统服务
```bash
mysqld -install
```

## 5. 启动服务
```bash
net start mysql
```

## 6. 登录&修改密码
* 默认密码在`data/xx.err`下
* 修改密码命令
```sql
alter user root@localhost identified by '1234'
```

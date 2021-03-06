# crond任务调度

## 概述

任务调度：

- 是指系统在某个时间执行特定的命令或程序；

任务调度分类

- 系统工作
  - 有些重要的工作必须周而复始地执行，如：病毒扫描等。

* 个别用户工作
  - 个别用户可能希望执行某些程序，比如对mysql数据库的备份。

## 基本语法

crontab [选项]

常用选项：

| 选项 | 作用                          |
| ---- | ----------------------------- |
| -e   | 编辑crontab定时任务           |
| -l   | 查询crontab任务               |
| -r   | 删除当前用户所有的crontab任务 |

## 快速入门

* 每小时的每分钟执行 `ls -l /etc/ >> /tmp/to.txt`

  ```bash
  crontab -e
  */1 * * * * ls -l /etc/ >> /tmp/to.txt
  ```

## 占位符说明

| 项目    | 含义                 | 范围                    |
| ------- | -------------------- | ----------------------- |
| 第一个* | 一小时当中的第几分钟 | 0-59                    |
| 第二个* | 一天当中的第几个小时 | 0-23                    |
| 第三个* | 一个月当中的第几天   | 1-31                    |
| 第四个* | 一年当中的第几月     | 1-12                    |
| 第五个* | 一周当中的星期几     | 0-7（0和7都代表星期日） |

**特殊符号说明**

| 特殊符号 | 含义                                                         |
| -------- | ------------------------------------------------------------ |
| *        | 代表任何时间。如第一个*，就代表一小时中的每分钟都执行一次的意思 |
| ，       | 代表不连续的事件。比如“0 8,12,16 * * *”命令，就代表在每天的8点0分，12点0分，16点0分都执行一次命令 |
| -        | 代表连续的时间范围。比如“0 5 * * 1-6”命令，代表每周一到周六的凌晨5点0分执行命令 |
| */n      | 代表每个多久执行一次。比如"*/10 * * * *"命令，代表每隔10分钟就执行一遍命令 |

**特定时间执行任务案例**

| 时间         | 含义                                        |
| ------------ | ------------------------------------------- |
| 45 22 * * *  | 在22点45分执行命令                          |
| 0 17 * * 1   | 在周1的17点0分执行命令                      |
| 0 5 1,15 * * | 在1号和15号的5点0分执行命令                 |
| 40 4 * * 1-5 | 每周一到周五的凌晨4点40分执行命令           |
| */10 4 * * * | 每天的凌晨4点，每隔10分钟执行一次命令       |
| 0 0 1,15 * 1 | 每月1号和15号，每周一的0点0分都会执行命令。 |

**注意：星期几和几号最好不要同时出现，因为他们定义的都是天。非常容易让人搞混**

## 应用实例

* 每隔1分钟，就将当前的日期信息追加到 /tmp/mydate文件中

  1. 创建/tmp/testcrontab/task1.sh

  2. ```bash
     date >> /tmp/mydate
     ```

  3. 赋予task1.sh执行权限：`chmod 744 /tmp/testcrontab/task1.sh`

  4. `crontab -e`

  5. `*/1 * * * *  /tmp/testcrontab/task1.sh`
  
* 每隔1分钟，将当前日期和日历都追加到 /home/mycal 文件中

  1. 创建/tmp/testcrontab/task2.sh

  2. ```bash
     date >> /tmp/mycal
     cal >> /tmp/mycal
     ```

  3. 赋予task2.sh执行权限：`chmod 744 /tmp/testcrontab/task2.sh`

  4. `crontab -e`

  5. `*/1 * * * * /tmp/testcrontab/task2.sh`

* 每天凌晨2:00将Mysql数据库testdb,备份到文件/tmp/mydb.back

  1. 创建/tmp/testcrontab/task3.sh

  2. ```bash
     /usr/local/mysql/bin/mysqldump -u root -p1234 testdb > /tmp/mydb.back
     ```

  3. 赋予task3.sh执行权限：`chmod 744 /tmp/testcrontab/task3.sh`

  4. `crontab -e`

  5. `0 2 * * * /tmp/testcrontab/task3.sh`

## crontab相关指令

* crontab -r：终止任务调度
* crontab -l ：列出当前有哪些任务调度
* systectl  restart crond：重启任务调度
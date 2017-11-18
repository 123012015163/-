JAVA的IO操作
====================================
 #前面两个实验，在前面的一个工程里面，这是后来新加的两个实验
#实验三 带缓冲区的IO
1. 用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

#实验四 对象序列化

1. 类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
2. 使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
3. 使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。


---------------------------------------------------------------------------------
#实验截图
##实验三
1. 控制台选择
![](https://github.com/123012015163/-/blob/master/Test_five_second/img/test3.png)

##实验四
1. 实验结果
![](https://github.com/123012015163/-/blob/master/Test_five_second/img/test4.png)

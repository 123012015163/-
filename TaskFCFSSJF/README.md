模拟实现FCFS（先来先服务）算法-1
====================================
 FCFS算法按照任务到达的顺序进行服务，先来先服务
 SJF算法首先调度已到达的任务中，服务时间最短的
 需要实现以上两个算法，按照以下要求
 ----------------------------------------------------------------------------
 1.   每个Task对象可以描述为至少包含下列属性：
    taskID //任务ID
    arrivalTime //到达时间
    serviceTime //服务时间
    startingTime //开始时间
    finishingTime //完成时间=开始时间+服务时间
    turnAroundTime //周转时间=完成时间-达到时间
    weightTurnAround //带权周转时间=周转时间/服务时间
    其他的属性根据程序需要设置

2. 任务(Task)的ID、开始时间和服务时间由文件读入。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。

3. 要求实现如下要求的FCFS
当只有一个处理队列时的情况
当有两个处理队列时的情况

4. 实现SJF算法，同样要求处理两种情况：
当只有一个处理队列时的情况
当有两个处理队列时的情况
---------------------------------------------------------------------------------
实验截图：
1. 控制台选择
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/Main.png)
2. 数据从文件里面读取出来，因为每次都执行那个函数，所以可能每次的数据都不大一样
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/Time.png)
3. 单线程先到先服务
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/SingleFCFS.png)
4. 双线程先到先服务
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/DoubleFCFS.png)
5. 单线程短作业优先（我每次判断任务优先的时候，任务需要没变，但是任务的到达时间和服务时间进行调换）
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/SingleSJF.png)
6. 双线程短作业优先
![](https://github.com/123012015163/-/raw/master/TaskFCFSSJF/img/DoubleSJF.png)



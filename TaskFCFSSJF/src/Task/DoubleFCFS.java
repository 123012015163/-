package Task;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class DoubleFCFS extends TASK{
    public void doubleFCFS(){//先到先服务（双线程）
    	File file = new File("input.txt");//创建文件对象
    	
    	if(file.exists()){//判断文件是否存在   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
    		   Scanner scan =new Scanner(in);//用scan读取string信息(遇到空格,换行就自动换)
 /*              for(int i=0;i<100;i++){//将文件夹里面的数据读取出来
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }*/
    		   int i=0;
    		   while(scan.hasNext()){
    			   Task_id[i]=scan.nextInt();
    			   ArrivedTime[i]=scan.nextInt();
    			   ServerTime[i]=scan.nextInt();
    			   i=i+1;
    		   }
               scan.close();
               int FirstTime=0;//第一线程的时间
               int SecondTime=0;//第二线程的时间
               int MarkTask[];//用来标记采用哪个
               MarkTask=new int[100];
               for(i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){//如果第一线程是无任务
            		   startingTime[i]=FirstTime;//记录任务的开始时间
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            		   
            	   }else if(SecondTime<=ArrivedTime[i]){//如果第一线程正在任务，而第二线程空闲
            		   if(SecondTime==0){
            			   SecondTime=ArrivedTime[i];
            		   }
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            		   
            	   }else if(FirstTime<=SecondTime){//如果第一，第二线程都在工作，那么就判断哪个先结束任务
            		   startingTime[i]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            		   
            	   }else{
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+SecondTime;
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            		   
            	   }
               }
               /*计算周转时间，带权周转时间*/
               for(i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               System.out.println("TaskId ArrivalTime ServiceTime StartingTime FinishingTime TurnAroundTime WeightTurnAround");
               for(i=0;i<100;i++){
            	   if(MarkTask[i]==1){
	            	   System.out.print("   "+Task_id[i]+"   ");
	            	   System.out.print(ArrivedTime[i]+"   ");
	            	   System.out.print(ServerTime[i]+"    ");
	            	   System.out.print(startingTime[i]+"   ");
	            	   System.out.print(finishingTime[i]+"   ");
	            	   System.out.print(turnAroundTime[i]+"   ");
	            	   System.out.println(weightTurnAround[i]);         		   
            	   }else{
	            	   System.out.print("   "+Task_id[i]+"   ");
	            	   System.out.print(ArrivedTime[i]+"   ");
	            	   System.out.print(ServerTime[i]+"   ");
	            	   System.out.print(startingTime[i]+"   ");
	            	   System.out.print(finishingTime[i]+"   ");
	            	   System.out.print(turnAroundTime[i]+"   ");
	            	   System.out.println(weightTurnAround[i]);
            	   }
               }
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}

    }
}

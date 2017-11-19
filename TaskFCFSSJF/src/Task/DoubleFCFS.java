package Task;

import java.io.File;
import java.io.FileInputStream;

public class DoubleFCFS extends TASK{
    public void doubleFCFS(){//先到先服务（双线程）
    	File file = new File("time.txt");//创建文件对象
    	
    	if(file.exists()){//判断文件是否存在   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
               for(int i=0;i<100;i++){//将文件夹里面的数据读取出来
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
               int FirstTime=0;//第一线程的时间
               int SecondTime=0;//第二线程的时间
               int MarkTask[];//用来标记采用哪个
               MarkTask=new int[100];
               for(int i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){//如果第一线程是无任务
            		   startingTime[i]=FirstTime;//记录任务的开始时间
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            	   }else if(SecondTime<=ArrivedTime[i]){//如果第一线程正在任务，而第二线程空闲
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
               for(int i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               
               for(int i=0;i<100;i++){
            	   if(MarkTask[i]==1){
            		   System.out.print("第"+(i+1)+"个任务在");
            		   System.out.print("第一线程进行,开始时间是"+startingTime[i]+",");
            		   System.out.print("结束时间是"+finishingTime[i]+",");
            		   System.out.print("周转时间是"+turnAroundTime[i]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[i]);            		   
            	   }else{
            		   System.out.print("第"+(i+1)+"个任务在");
            		   System.out.print("第二线程进行,开始时间是"+startingTime[i]+",");
            		   System.out.print("结束时间是"+finishingTime[i]+",");
            		   System.out.print("周转时间是"+turnAroundTime[i]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[i]);
            	   }
               }
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}

    }
}

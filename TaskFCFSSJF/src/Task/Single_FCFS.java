package Task;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Single_FCFS extends TASK{
	   public void SingleFCFS(){//先来先服务(单线程)
	    	File file = new File("input.txt");//创建文件对象	    	
	    	if(file.exists()){//判断文件是否存在   	
	    		try{   			
	    		   FileInputStream in = new FileInputStream(file);   //创建FileInputStream对象，将数据信息从文件中读取出来
	    		   Scanner scan =new Scanner(in);//用scan读取string信息(遇到空格,换行就自动换)
/*	               for(int i=0;i<100;i++){//将文件夹里面的数据读取出来
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
	               for(i=0;i<100;i++){
	            	   System.out.println(Task_id[i]+"  "+ArrivedTime[i]+"  "+ServerTime[i]);
	               }
	               startingTime[0]=ArrivedTime[0];//这里是第一个服务开始时间
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//这个是第一个结束时间
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个带权周转时间
	               for(i=1;i<100;i++){
	            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
	            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
	            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
	            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
	               }
	               System.out.println("TaskId ArrivalTime ServiceTime StartingTime FinishingTime TurnAroundTime WeightTurnAround");
	               for(i=0;i<100;i++){
	            	   System.out.print("   "+Task_id[i]+"   ");
	            	   System.out.print(ArrivedTime[i]+"   ");
	            	   System.out.print(ServerTime[i]+"   ");
	            	   System.out.print(startingTime[i]+"   ");
	            	   System.out.print(finishingTime[i]+"   ");
	            	   System.out.print(turnAroundTime[i]+"   ");
	            	   System.out.println(weightTurnAround[i]);
	               }
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	    	
	    }
}

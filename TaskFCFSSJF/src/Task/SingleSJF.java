package Task;

import java.io.File;
import java.io.FileInputStream;

public class SingleSJF extends TASK{
	   public void singleSJF(){//短作业优先(单线程)
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

	               startingTime[0]=ArrivedTime[0];//这里是第一个服务开始时间
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//这个是第一个结束时间
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个带权周转时间            	   
	               System.out.print("第1个任务的开始时间:"+startingTime[0]+"     ");
	        	   System.out.print("结束时间:"+finishingTime[0]+"     ");
	        	   System.out.print("周转时间:"+turnAroundTime[0]+"     ");
	        	   System.out.println("带权周转时间:"+weightTurnAround[0]);
	        	   int temp_id;//用来短暂存储任务ID       	   
	        	   int temp;//存储上一个任务完成的时间
	        	   int temp_AT;//临时到达时间
	        	   int temp_ST;//临时服务时间

	               for(int i=1;i<100;i++){//这边开始判断短作业
	            	   temp=finishingTime[i-1];//存储上一个任务完成的时间
	            	   temp_id=i;
	            	   if(temp>=99){
	            		   temp=99;
	            	   }
	            	   
	            	   for(int j=i+1;j<=temp ;j++){
	            		   if(ServerTime[temp_id]>ServerTime[j]){
	            			   temp_id=j;
	            		   }
	            	   }            	   
	            	   /*这边是把服务时间小的与大的位置对换*/

	            	   temp_AT=ArrivedTime[i];           	   
	            	   ArrivedTime[i]=ArrivedTime[temp_id];
	            	   ArrivedTime[temp_id]=temp_AT;
	            	   
	            	   temp_ST=ServerTime[i];            	   
	            	   ServerTime[i]=ServerTime[temp_id];
	            	   ServerTime[temp_id]=temp_ST;
	            	   
	            	   /*计算各种时间*/
	            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
	            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
	            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
	            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
	            	   
	            	   System.out.print("第"+(Task_id[i])+"个任务的开始时间:"+startingTime[i]+"     ");
	            	   System.out.print("结束时间:"+finishingTime[i]+"     ");
	            	   System.out.print("周转时间:"+turnAroundTime[i]+"     ");
	            	   System.out.println("带权周转时间:"+weightTurnAround[i]);
	            	   
	               }

	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	    }
}

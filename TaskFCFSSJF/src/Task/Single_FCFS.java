package Task;

import java.io.File;
import java.io.FileInputStream;

public class Single_FCFS extends TASK{
	   public void SingleFCFS(){//先来先服务(单线程)
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
	               for(int i=0;i<100;i++){
	            	   System.out.println(Task_id[i]+"  "+ArrivedTime[i]+"  "+ServerTime[i]);
	               }
	               startingTime[0]=ArrivedTime[0];//这里是第一个服务开始时间
	               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//这个是第一个结束时间
	               turnAroundTime[0]=finishingTime[0]-startingTime[0];//第一个周转时间
	               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//第一个带权周转时间
	               for(int i=1;i<100;i++){
	            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
	            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
	            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
	            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
	               }
	               for(int i=0;i<100;i++){
	            	   System.out.print("第"+(i+1)+"个任务的开始时间:"+startingTime[i]+"     ");
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

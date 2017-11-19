package Task;

import java.io.File;
import java.io.FileInputStream;

public class SingleSJF extends TASK{
	   public void singleSJF(){//短作业优先(单线程)
	    	File file = new File("time.txt");//创建文件对象

	        boolean [] Server;
	        Server =new boolean[100];
	        for(int i=0;i<100;i++){
	        	Server[i]=false;
	        }
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
/*	               for(int i=0;i<100;i++){//将文件夹里面的数据读取出来
	            	   System.out.println(Task_id[i]+" "+ArrivedTime[i]+" "+ServerTime[i]);
	               }*/
	               in.close();       	   
	        	   int temp_id=0;//用来短暂存储任务ID 
	        	   int first_unserver=temp_id;

	        	   int time=0;
	        	   for(int i=0;i<100;i++){
	        		   for(int j=first_unserver;j<100;j++){
	        			   if(Server[j]==false){//判断最靠前的任务是否被服务过
	        				   temp_id=j;
	        				   break;
	        			   }
	        		   }
	        		   first_unserver=temp_id;
	        		   for(int k=temp_id+1;k<100 && k<=time;k++){
	        			   if(Server[k]==true){
	        				   continue;
	        			   }
	        			   if(ServerTime[k]<ServerTime[temp_id] ){
	        				   temp_id=k;	        				   
	        			   }
	        		   }
	        		   if(ArrivedTime[temp_id]<=time){//如果任务达到时间小于前一个任务完成时间
	        			   startingTime[temp_id]=time;
	        			   finishingTime[temp_id]=time+ServerTime[temp_id];
	        			   turnAroundTime[temp_id]=finishingTime[temp_id]-ArrivedTime[temp_id];
	        			   weightTurnAround[temp_id]=turnAroundTime[temp_id]/ServerTime[temp_id];
	        			   System.out.print("这是第"+(temp_id+1)+"个任务  ");
	        			   System.out.print("开始时间："+startingTime[temp_id]+"结束时间："+finishingTime[temp_id]);
	        			   System.out.println("周转时间："+turnAroundTime[temp_id]+"带权周转时间："+ weightTurnAround[temp_id]);
	        		   }else{
	        			   startingTime[temp_id]=ArrivedTime[temp_id];
	        			   finishingTime[temp_id]=ArrivedTime[temp_id]+ServerTime[temp_id];
	        			   turnAroundTime[temp_id]=finishingTime[temp_id]-startingTime[temp_id];
	        			   weightTurnAround[temp_id]=turnAroundTime[temp_id]/ServerTime[temp_id];
	        			   System.out.print("这是第"+(temp_id+1)+"个任务  ");
	        			   System.out.print("开始时间："+startingTime[temp_id]+"结束时间："+finishingTime[temp_id]);
	        			   System.out.println("周转时间："+turnAroundTime[temp_id]+"带权周转时间："+ weightTurnAround[temp_id]);
	        		   }
	        		   time=finishingTime[temp_id];
	        		   Server[temp_id]=true;
	        	   }
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	    }
}

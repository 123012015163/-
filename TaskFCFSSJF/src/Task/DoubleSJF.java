package Task;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class DoubleSJF extends TASK{
	   public void doubleSJF(){//短作业优先(双线程)
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
		           int FirstTime=0;//第一线程的时间
		           int SecondTime=0;//第二线程的时间
		           
		           boolean ID[];//用来判断任务是否已经完成
		           ID = new boolean [100];
		           
		           int NoServerID=0;//标记队列最前方未服务任务的序号
		           int min=0;//最短作业所在序号
		           System.out.println("TaskId ArrivalTime ServiceTime StartingTime FinishingTime TurnAroundTime WeightTurnAround");
	               for(i=0;i<100;i++){
	            	   for(int j=NoServerID;j<100;j++){
	            		   if(ID[j]==false){
	            			   min=j;
	            			   break;
	            		   }
	            	   }
	            	   NoServerID=min;
		       		   for(int k=min+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//找到已到达任务中最短任务
		    			   if(ID[k]==true) {
		    				   continue;
		    			   }
		    			   if(ServerTime[min]>ServerTime[k]) {
		    				   min=k;
		    			   }
		    		   }
	            	   if(FirstTime<=ArrivedTime[min]){//如果第一线程空闲
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
		            	   System.out.print("   "+Task_id[min]+"   ");
		            	   System.out.print(ArrivedTime[min]+"   ");
		            	   System.out.print(ServerTime[min]+"   ");
		            	   System.out.print(startingTime[min]+"   ");
		            	   System.out.print(finishingTime[min]+"   ");
		            	   System.out.print(turnAroundTime[min]+"   ");
		            	   System.out.println(weightTurnAround[min]);
		            	   
	            	   }else if(SecondTime<=ArrivedTime[min]){//如果第一线程正在运行任务，第二线程空闲
	            		   if(SecondTime==0){
	            			   SecondTime=ArrivedTime[min];
	            		   }
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=ArrivedTime[min]+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
		            	   System.out.print("   "+Task_id[min]+"   ");
		            	   System.out.print(ArrivedTime[min]+"   ");
		            	   System.out.print(ServerTime[min]+"   ");
		            	   System.out.print(startingTime[min]+"   ");
		            	   System.out.print(finishingTime[min]+"   ");
		            	   System.out.print(turnAroundTime[min]+"   ");
		            	   System.out.println(weightTurnAround[min]);
		            	   
	            	   }else if(FirstTime<=SecondTime){//第一线程比第二线程提前空闲
	            		   startingTime[min]=FirstTime;
	            		   FirstTime=FirstTime+ServerTime[min];
	            		   finishingTime[min]=FirstTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
		            	   System.out.print("   "+Task_id[min]+"   ");
		            	   System.out.print(ArrivedTime[min]+"   ");
		            	   System.out.print(ServerTime[min]+"   ");
		            	   System.out.print(startingTime[min]+"   ");
		            	   System.out.print(finishingTime[min]+"   ");
		            	   System.out.print(turnAroundTime[min]+"    ");
		            	   System.out.println(weightTurnAround[min]);
		            	   
	            	   }else{
	            		   startingTime[min]=SecondTime;
	            		   SecondTime=SecondTime+ServerTime[min];
	            		   finishingTime[min]=SecondTime;
	            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
	            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
		            	   System.out.print("   "+Task_id[min]+"   ");
		            	   System.out.print(ArrivedTime[min]+"   ");
		            	   System.out.print(ServerTime[min]+"   ");
		            	   System.out.print(startingTime[min]+"   ");
		            	   System.out.print(finishingTime[min]+"    ");
		            	   System.out.print(turnAroundTime[min]+"   ");
		            	   System.out.println(weightTurnAround[min]);
		            	   
	            	   }
	            	   ID[min]=true;//将该任务已经完成
	               }

	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
	    }
}

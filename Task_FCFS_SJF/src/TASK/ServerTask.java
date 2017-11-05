package TASK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class ServerTask {
	private int TaskId[];//任务ID
	private int arrived_time[];//到达时间
	private int server_time[];//服务时间
	
	public ServerTask(){//构建函数
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
    public static void main(String[] args){//main函数
    	ServerTask I=new ServerTask();
 //    	I.InputData();//向文件输入数据   	
    	System.out.println("1、先到先服务(单线程)");
    	System.out.println("2、先到先服务(双线程)");
    	System.out.println("3、短作业优先(单线程)");
    	System.out.println("4、短作业优先(双线程)");
    	System.out.print("请输入你的选择:");
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	switch(input){
    		case 1:
    			I.SingleFCFS();
    			break;
    		case 2:
    			I.DoubleFCFS();
    			break;
    		case 3:
    			I.SingleSJF();
    			break;
    		case 4:
    			I.DoubleSJF();
    			break;
    		default:
    			System.out.println("选择错误，结束！");
    			break;
    	}       
    }
    
    public void SingleFCFS(){//先来先服务(单线程)
    	File file = new File("time.txt");//创建文件对象
    	int Task_id[] ;//定义变量任务ID
    	Task_id=new int[100];//初始化变量任务ID
    	int []ServerTime;//服务时间
    	ServerTime=new int[100];
    	
    	int []ArrivedTime;//到达时间
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//开始时间
    	startingTime =new int[100];
    	
    	int finishingTime[];//完成时间=开始时间+服务时间
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//周转时间=完成时间-达到时间
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//带权周转时间=周转时间/服务时间
    	weightTurnAround=new float[100];
    	
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
    
    public void DoubleFCFS(){//先到先服务（双线程）
    	File file = new File("time.txt");//创建文件对象
    	int Task_id[] ;//定义变量
    	Task_id=new int[100];//初始化变量
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//开始时间
    	startingTime =new int[100];
    	
    	int finishingTime[];//完成时间=开始时间+服务时间
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//周转时间=完成时间-达到时间
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//带权周转时间=周转时间/服务时间
    	weightTurnAround=new float[100];
    	
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
    
    public void SingleSJF(){//短作业优先(单线程)
    	File file = new File("time.txt");//创建文件对象
    	int Task_id[] ;//定义变量
    	Task_id=new int[100];//初始化变量
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//开始时间
    	startingTime =new int[100];
    	
    	int finishingTime[];//完成时间=开始时间+服务时间
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//周转时间=完成时间-达到时间
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//带权周转时间=周转时间/服务时间
    	weightTurnAround=new float[100];
        	
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
    
    public void DoubleSJF(){//短作业优先(双线程)
    	File file = new File("time.txt");//创建文件对象
    	int Task_id[] ;//定义变量
    	Task_id=new int[100];//初始化变量
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//开始时间
    	startingTime =new int[100];
    	
    	int finishingTime[];//完成时间=开始时间+服务时间
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//周转时间=完成时间-达到时间
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//带权周转时间=周转时间/服务时间
    	weightTurnAround=new float[100];
    
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
	           
	           boolean ID[];//用来判断任务是否已经完成
	           ID = new boolean [100];
	           
	           int NoServerID=0;//标记队列最前方未服务任务的序号
	           int min=0;//最短作业所在序号
	           
               for(int i=0;i<100;i++){
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
            		   System.out.print("这是第"+(min+1)+"个任务在第一线程中进行，开始时间是");
            		   System.out.print(startingTime[min]+",结束时间是"+finishingTime[min]+",");
            		   System.out.print("周转时间"+turnAroundTime[min]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
            	   }else if(SecondTime<=ArrivedTime[min]){//如果第一线程正在运行任务，第二线程空闲
            		   startingTime[min]=SecondTime;
            		   SecondTime=ArrivedTime[min]+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("这是第"+(min+1)+"个任务在第二线程中进行，开始时间是");
            		   System.out.print(startingTime[min]+",结束时间是"+finishingTime[min]+",");
            		   System.out.print("周转时间"+turnAroundTime[min]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
            	   }else if(FirstTime<=SecondTime){//第一线程比第二线程提前空闲
            		   startingTime[min]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[min];
            		   finishingTime[min]=FirstTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("这是第"+(min+1)+"个任务在第一线程中进行，开始时间是");
            		   System.out.print(startingTime[min]+",结束时间是"+finishingTime[min]+",");
            		   System.out.print("周转时间"+turnAroundTime[min]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[min]);

            	   }else{
            		   startingTime[min]=SecondTime;
            		   SecondTime=SecondTime+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("这是第"+(min+1)+"个任务在第二线程中进行，开始时间是");
            		   System.out.print(startingTime[min]+",结束时间是"+finishingTime[min]+",");
            		   System.out.print("周转时间"+turnAroundTime[min]+",");
            		   System.out.println("带权周转时间是"+weightTurnAround[min]);
            	   }
            	   ID[min]=true;//将该任务已经完成
               }

    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
    
    public void InputData(){  //将数据输入到文件里面 	 
    	File file = new File("time.txt");//创建文件对象
    	int[] numbers = {6,2,1,3,9};//在这个范围里面产生随机数
    	if(file.exists()){//判断文件是否存在
    		try{
    			FileOutputStream out = new FileOutputStream(file);//创建FileOutputStream对象，将数据信息写入到文件中
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//赋予任务编号
    				out.write(TaskId[i]);
    				
    				arrived_time[i]=i;//赋予任务达到时间
    				out.write(arrived_time[i]);
    				
    	    		Random random = new Random();//利用随机数，来选择任务的服务时间
    	    		int index = random.nextInt(numbers.length);
    	    		server_time[i]=numbers[index];
    	    		out.write(server_time[i]);   	    		
    			}
    			out.close();
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}else{//不存在的话，新建文件
    		try{//try语句块捕捉可能出现的异常
    			file.createNewFile();//创建该文件 
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}
    	}
    }
}


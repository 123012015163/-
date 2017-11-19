package Task;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class TASK {
    int TaskId[];//任务ID
	int arrived_time[];//到达时间
	int server_time[];//服务时间
	int Task_id[] ;//定义变量
	int []ServerTime;
	int []ArrivedTime;
	int startingTime[];//开始时间
	int finishingTime[];//完成时间=开始时间+服务时间
	int turnAroundTime[];//周转时间=完成时间-达到时间
	float weightTurnAround[] ;//带权周转时间=周转时间/服务时间
	
	public TASK(){//构建函数
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];
		Task_id=new int[100];//初始化变量任务ID
		ServerTime=new int[100];
		ArrivedTime=new int[100];
		startingTime =new int[100];
		finishingTime=new int[100];
		turnAroundTime=new int[100];
		weightTurnAround=new float[100];

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

package TASK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import java.util.Scanner;

public class ServerTask {
	private int TaskId[];//����ID
	private int arrived_time[];//����ʱ��
	private int server_time[];//����ʱ��
	
	public ServerTask(){//��������
		TaskId= new int[100];
		arrived_time=new int[100];
		server_time=new int[100];		
	}
	
    public static void main(String[] args){//main����
    	ServerTask I=new ServerTask();
 //    	I.InputData();//���ļ���������   	
    	System.out.println("1���ȵ��ȷ���(���߳�)");
    	System.out.println("2���ȵ��ȷ���(˫�߳�)");
    	System.out.println("3������ҵ����(���߳�)");
    	System.out.println("4������ҵ����(˫�߳�)");
    	System.out.print("���������ѡ��:");
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
    			System.out.println("ѡ����󣬽�����");
    			break;
    	}       
    }
    
    public void SingleFCFS(){//�����ȷ���(���߳�)
    	File file = new File("time.txt");//�����ļ�����
    	int Task_id[] ;//�����������ID
    	Task_id=new int[100];//��ʼ����������ID
    	int []ServerTime;//����ʱ��
    	ServerTime=new int[100];
    	
    	int []ArrivedTime;//����ʱ��
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
    	
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
               for(int i=0;i<100;i++){//���ļ�����������ݶ�ȡ����
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
               startingTime[0]=ArrivedTime[0];//�����ǵ�һ������ʼʱ��
               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//����ǵ�һ������ʱ��
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ����Ȩ��תʱ��
               for(int i=1;i<100;i++){
            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               for(int i=0;i<100;i++){
            	   System.out.print("��"+(i+1)+"������Ŀ�ʼʱ��:"+startingTime[i]+"     ");
            	   System.out.print("����ʱ��:"+finishingTime[i]+"     ");
            	   System.out.print("��תʱ��:"+turnAroundTime[i]+"     ");
            	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[i]);
               }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    	
    }
    
    public void DoubleFCFS(){//�ȵ��ȷ���˫�̣߳�
    	File file = new File("time.txt");//�����ļ�����
    	int Task_id[] ;//�������
    	Task_id=new int[100];//��ʼ������
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
    	
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
               for(int i=0;i<100;i++){//���ļ�����������ݶ�ȡ����
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
               int FirstTime=0;//��һ�̵߳�ʱ��
               int SecondTime=0;//�ڶ��̵߳�ʱ��
               int MarkTask[];//������ǲ����ĸ�
               MarkTask=new int[100];
               for(int i=0;i<100;i++){
            	   if(FirstTime<=ArrivedTime[i]){//�����һ�߳���������
            		   startingTime[i]=FirstTime;//��¼����Ŀ�ʼʱ��
            		   FirstTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=FirstTime;
            		   MarkTask[i]=1;
            	   }else if(SecondTime<=ArrivedTime[i]){//�����һ�߳��������񣬶��ڶ��߳̿���
            		   startingTime[i]=SecondTime;
            		   SecondTime=ServerTime[i]+ArrivedTime[i];
            		   finishingTime[i]=SecondTime;
            		   MarkTask[i]=2;
            	   }else if(FirstTime<=SecondTime){//�����һ���ڶ��̶߳��ڹ�������ô���ж��ĸ��Ƚ�������
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
               /*������תʱ�䣬��Ȩ��תʱ��*/
               for(int i=0;i<100;i++){
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
               }
               
               for(int i=0;i<100;i++){
            	   if(MarkTask[i]==1){
            		   System.out.print("��"+(i+1)+"��������");
            		   System.out.print("��һ�߳̽���,��ʼʱ����"+startingTime[i]+",");
            		   System.out.print("����ʱ����"+finishingTime[i]+",");
            		   System.out.print("��תʱ����"+turnAroundTime[i]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[i]);            		   
            	   }else{
            		   System.out.print("��"+(i+1)+"��������");
            		   System.out.print("�ڶ��߳̽���,��ʼʱ����"+startingTime[i]+",");
            		   System.out.print("����ʱ����"+finishingTime[i]+",");
            		   System.out.print("��תʱ����"+turnAroundTime[i]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[i]);
            	   }
               }
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
    
    public void SingleSJF(){//����ҵ����(���߳�)
    	File file = new File("time.txt");//�����ļ�����
    	int Task_id[] ;//�������
    	Task_id=new int[100];//��ʼ������
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
        	
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
               for(int i=0;i<100;i++){//���ļ�����������ݶ�ȡ����
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();

               startingTime[0]=ArrivedTime[0];//�����ǵ�һ������ʼʱ��
               finishingTime[0]=ArrivedTime[0]+ServerTime[0];//����ǵ�һ������ʱ��
               turnAroundTime[0]=finishingTime[0]-startingTime[0];//��һ����תʱ��
               weightTurnAround[0]=turnAroundTime[0]/ServerTime[0];//��һ����Ȩ��תʱ��            	   
               System.out.print("��1������Ŀ�ʼʱ��:"+startingTime[0]+"     ");
        	   System.out.print("����ʱ��:"+finishingTime[0]+"     ");
        	   System.out.print("��תʱ��:"+turnAroundTime[0]+"     ");
        	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[0]);
        	   int temp_id;//�������ݴ洢����ID       	   
        	   int temp;//�洢��һ��������ɵ�ʱ��
        	   int temp_AT;//��ʱ����ʱ��
        	   int temp_ST;//��ʱ����ʱ��

               for(int i=1;i<100;i++){//��߿�ʼ�ж϶���ҵ
            	   temp=finishingTime[i-1];//�洢��һ��������ɵ�ʱ��
            	   temp_id=i;
            	   if(temp>=99){
            		   temp=99;
            	   }
            	   
            	   for(int j=i+1;j<=temp ;j++){
            		   if(ServerTime[temp_id]>ServerTime[j]){
            			   temp_id=j;
            		   }
            	   }            	   
            	   /*����ǰѷ���ʱ��С������λ�öԻ�*/

            	   temp_AT=ArrivedTime[i];           	   
            	   ArrivedTime[i]=ArrivedTime[temp_id];
            	   ArrivedTime[temp_id]=temp_AT;
            	   
            	   temp_ST=ServerTime[i];            	   
            	   ServerTime[i]=ServerTime[temp_id];
            	   ServerTime[temp_id]=temp_ST;
            	   
            	   /*�������ʱ��*/
            	   startingTime[i]=startingTime[i-1]+ServerTime[i-1];
            	   finishingTime[i]=finishingTime[i-1]+ServerTime[i];
            	   turnAroundTime[i]=finishingTime[i]-ArrivedTime[i];
            	   weightTurnAround[i]=turnAroundTime[i]/ServerTime[i];
            	   
            	   System.out.print("��"+(Task_id[i])+"������Ŀ�ʼʱ��:"+startingTime[i]+"     ");
            	   System.out.print("����ʱ��:"+finishingTime[i]+"     ");
            	   System.out.print("��תʱ��:"+turnAroundTime[i]+"     ");
            	   System.out.println("��Ȩ��תʱ��:"+weightTurnAround[i]);
            	   
               }

    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
    
    public void DoubleSJF(){//����ҵ����(˫�߳�)
    	File file = new File("time.txt");//�����ļ�����
    	int Task_id[] ;//�������
    	Task_id=new int[100];//��ʼ������
    	int []ServerTime;
    	ServerTime=new int[100];
    	int []ArrivedTime;
    	ArrivedTime=new int[100];
    	
    	int startingTime[];//��ʼʱ��
    	startingTime =new int[100];
    	
    	int finishingTime[];//���ʱ��=��ʼʱ��+����ʱ��
    	finishingTime=new int[100];
    	
    	int turnAroundTime[];//��תʱ��=���ʱ��-�ﵽʱ��
    	turnAroundTime=new int[100];
    	
    	float weightTurnAround[] ;//��Ȩ��תʱ��=��תʱ��/����ʱ��
    	weightTurnAround=new float[100];
    
    	if(file.exists()){//�ж��ļ��Ƿ����   	
    		try{   			
    		   FileInputStream in = new FileInputStream(file);   //����FileInputStream���󣬽�������Ϣ���ļ��ж�ȡ����
               for(int i=0;i<100;i++){//���ļ�����������ݶ�ȡ����
            	   int a=in.read();
            	   Task_id[i]=a;
            	   int b=in.read();
            	   ArrivedTime[i] =b;
            	   int c=in.read();            	   
            	   ServerTime[i]=c;           	   
               }
               in.close();
	           int FirstTime=0;//��һ�̵߳�ʱ��
	           int SecondTime=0;//�ڶ��̵߳�ʱ��
	           
	           boolean ID[];//�����ж������Ƿ��Ѿ����
	           ID = new boolean [100];
	           
	           int NoServerID=0;//��Ƕ�����ǰ��δ������������
	           int min=0;//�����ҵ�������
	           
               for(int i=0;i<100;i++){
            	   for(int j=NoServerID;j<100;j++){
            		   if(ID[j]==false){
            			   min=j;
            			   break;
            		   }
            	   }
            	   NoServerID=min;
	       		   for(int k=min+1;k<100 && k<=FirstTime && k<=SecondTime ; k++) {//�ҵ��ѵ����������������
	    			   if(ID[k]==true) {
	    				   continue;
	    			   }
	    			   if(ServerTime[min]>ServerTime[k]) {
	    				   min=k;
	    			   }
	    		   }
            	   if(FirstTime<=ArrivedTime[min]){//�����һ�߳̿���
            		   startingTime[min]=FirstTime;
            		   FirstTime=ArrivedTime[min]+ServerTime[min];
            		   finishingTime[min]=FirstTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }else if(SecondTime<=ArrivedTime[min]){//�����һ�߳������������񣬵ڶ��߳̿���
            		   startingTime[min]=SecondTime;
            		   SecondTime=ArrivedTime[min]+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }else if(FirstTime<=SecondTime){//��һ�̱߳ȵڶ��߳���ǰ����
            		   startingTime[min]=FirstTime;
            		   FirstTime=FirstTime+ServerTime[min];
            		   finishingTime[min]=FirstTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵ�һ�߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);

            	   }else{
            		   startingTime[min]=SecondTime;
            		   SecondTime=SecondTime+ServerTime[min];
            		   finishingTime[min]=SecondTime;
            		   turnAroundTime[min]=finishingTime[min]-ArrivedTime[min];
            		   weightTurnAround[min]=turnAroundTime[min]/ServerTime[min];            		   
            		   System.out.print("���ǵ�"+(min+1)+"�������ڵڶ��߳��н��У���ʼʱ����");
            		   System.out.print(startingTime[min]+",����ʱ����"+finishingTime[min]+",");
            		   System.out.print("��תʱ��"+turnAroundTime[min]+",");
            		   System.out.println("��Ȩ��תʱ����"+weightTurnAround[min]);
            	   }
            	   ID[min]=true;//���������Ѿ����
               }

    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
    
    public void InputData(){  //���������뵽�ļ����� 	 
    	File file = new File("time.txt");//�����ļ�����
    	int[] numbers = {6,2,1,3,9};//�������Χ������������
    	if(file.exists()){//�ж��ļ��Ƿ����
    		try{
    			FileOutputStream out = new FileOutputStream(file);//����FileOutputStream���󣬽�������Ϣд�뵽�ļ���
    			for(int i=0;i<100;i++){
    				TaskId[i]=i+1;//����������
    				out.write(TaskId[i]);
    				
    				arrived_time[i]=i;//��������ﵽʱ��
    				out.write(arrived_time[i]);
    				
    	    		Random random = new Random();//�������������ѡ������ķ���ʱ��
    	    		int index = random.nextInt(numbers.length);
    	    		server_time[i]=numbers[index];
    	    		out.write(server_time[i]);   	    		
    			}
    			out.close();
    		}catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}else{//�����ڵĻ����½��ļ�
    		try{//try���鲶׽���ܳ��ֵ��쳣
    			file.createNewFile();//�������ļ� 
    			InputData();
    		}
    		catch(Exception e){
    			e.printStackTrace();//����쳣��Ϣ
    		}
    	}
    }
}


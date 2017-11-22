package Task;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){//main函数
    	Single_FCFS H =new Single_FCFS();

    	DoubleFCFS X=new DoubleFCFS();
    	SingleSJF L=new SingleSJF();
    	DoubleSJF Y=new DoubleSJF();
    	System.out.println("1、先到先服务(单线程)");
    	System.out.println("2、先到先服务(双线程)");
    	System.out.println("3、短作业优先(单线程)");
    	System.out.println("4、短作业优先(双线程)");
    	System.out.print("请输入你的选择:");
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	switch(input){
    		case 1:
    			H.SingleFCFS();
    			break;
    		case 2:
    			X.doubleFCFS();
    			break;
    		case 3:
    			L.singleSJF();
    			break;
    		case 4:
    			Y.doubleSJF();
    			break;
    		default:
    			System.out.println("选择错误，结束！");
    			break;
    	}

    }
  
}

package test5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class Write {
	public void writetxt(){
		Scanner scan = new Scanner(System.in);
		try {
			File file =new File("src.txt");
	    	if(file.exists()){//判断文件是否存在
	    		try{
	    			BufferedWriter out = new BufferedWriter(new FileWriter(file));//创建FileOutputStream对象，将数据信息写入到文件中
	    			System.out.print("请输入你想输入的话：");
	    			String str = scan.nextLine();
	    			out.write(str);
	    			out.close();
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}	    	
	    	}else{//不存在的话，新建文件
	    		try{//try语句块捕捉可能出现的异常
	    			file.createNewFile();//创建该文件 
	    			writetxt();
	    		}
	    		catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}
	    	}
		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}	
	}
}

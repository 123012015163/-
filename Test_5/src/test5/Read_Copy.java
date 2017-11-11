package test5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Read_Copy {
	public void read_copy(){
		try {
			File file =new File("src.txt");
			File sfile =new File("dest.txt");
	    	if(file.exists()){//判断文件是否存在
	    		try{
	    			if(sfile.exists()){
	    			    BufferedReader in = new BufferedReader(new FileReader(file));//文件读取
	    				BufferedWriter out = new BufferedWriter(new FileWriter(sfile));//文件输入
	    			    BufferedReader sin = new BufferedReader(new FileReader(sfile));//文件读取	    				
		    			String str;
		    			str = in.readLine();
		    			while(str!=null){
		    				out.write(str);
		    				str = in.readLine();
		    			}
		    			in.close();
		    			out.close();
		    			String txt;
		    			txt = sin.readLine();
		    			System.out.print("现在输出文本：");
		    			while(txt!=null){
		    				System.out.println(txt);
		    				txt=sin.readLine();
		    			}
		    			sin.close();
	    			}else{
	    				sfile.createNewFile();//创建该文件 
		    			read_copy();
	    			}
	    		}catch(Exception e){
	    			e.printStackTrace();//输出异常信息
	    		}	    	
	    	}else{//不存在的话，新建文件
	    		return ;
	    	}
		}catch(Exception e){
			e.printStackTrace();//输出异常信息
		}	
	}
}

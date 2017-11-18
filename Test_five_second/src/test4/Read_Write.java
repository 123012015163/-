package test4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Read_Write extends Student{
	public void Read_List(){//从源文件里面读取出来数据
		int i=0;
		File file =new File("E:\\Myeclipse\\workplace\\Test_five_second\\list.txt");
    	if(file.exists()){//判断文件是否存在
    		try{
    			Scanner scan =new Scanner(new FileInputStream(file));//用scan读取string信息(遇到空格,换行就自动换)
    			String []StudentId;
    			StudentId=new String[40];
    			String [] Name;
    			Name=new String[40];
    			String []Sex;
    			Sex = new String[40];
    			while(scan.hasNext()){
    				StudentId[i]=scan.next();
//   				System.out.println(StudentId[i]);
    				Name[i]=scan.next();
//   				System.out.println(Name[i]);
    				Sex[i]=scan.next();
//  				System.out.println(Sex[i]);
    				i=i+1;
    			}
    			scan.close();
    			write(StudentId,Name,Sex);//将读取出来的信息传给另一边进行写入新的文件夹
    		}catch(Exception e){
    			e.printStackTrace();//输出异常信息
    		}	    	
    	}else{
    		return ;
    	}
	}
	
	public void write(String[] StudentID,String[] Name,String[]Sex)throws FileNotFoundException,IOException{//这个是写的函数，同时承担着序列化的责任
		int j;
		int compare;//用来字符串比较大小
		int i;
		String tempID;
		String tempSex;
		String tempName;
		for(i=0;i<40;i++){
			for(j=i+1;j<40;j++){
				compare = StudentID[i].compareTo(StudentID[j]);//判断第i个是不是比j个位置的ID大，小的放在前面(更换位置)
				if(compare>0){
					tempID=StudentID[j];
					tempName=Name[j];
					tempSex=Sex[j];
					
					StudentID[j]=StudentID[i];
					Name[j]=Name[i];
					Sex[j]=Sex[i];
					
					StudentID[i]=tempID;
					Name[i]=tempName;
					Sex[i]=tempSex;
				}
			}
		}
/*		for(i=0;i<40;i++){//测试是否按照学号大小输出
			System.out.println(StudentID[i]+"  "+Name[i]+"  "+Sex[i]);
		}*/
		Student[] I =new Student[40];//定义对象
		for(j=0;j<40;j++){//初始化对象
			I[j] =new Student();
		}
		for(i=0;i<40;i++){//对象赋值
			I[i].SetStudentID(StudentID[i]);
			I[i].SetName(Name[i]);
			I[i].SetSex(Sex[i]);
		}
		File file=new File("student.bin");
		if(file.exists()){
			ObjectOutputStream WriteOb = new ObjectOutputStream(new FileOutputStream(file));
			for(i=0;i<40;i++){
				WriteOb.writeObject(I[i]);
			}
        }else{
        	file.createNewFile();
        	Read_List();
        }
	}
	
	public void ReadFromNewFile()throws FileNotFoundException,IOException, ClassNotFoundException{//重新的文件里面读取出每个人的数据
		ObjectInputStream ReadOb = new ObjectInputStream(new FileInputStream(new File("student.bin")));
		Student [] ST;
		ST=new Student[40];
		for(int i=0;i<40;i++){
			ST[i] = new Student();
		}
		for(int i=0;i<40;i++){
			ST[i]=(Student)ReadOb.readObject();
			System.out.print(ST[i].getStudentID()+"  ");
			System.out.print(ST[i].getName()+"  ");
			System.out.println(ST[i].getSex());
		}
	}
}

package ReadFolder;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class Readfolder  {
	
	public void filetree () throws IOException {
		String file;
		Scanner sc =new Scanner(System.in);
		System.out.print("请输入文件夹地址：");
		file = sc.next();
		Path dir = Paths.get(file);
	    try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){	    	
	        for(Path e : stream){
	        	if(!Files.isDirectory(e)) {
	        		System.out.print("文件名称："+e.getFileName());
	        		System.out.print("  文件最后修改时间:"+Files.getLastModifiedTime(e)); 
	        		System.out.println("  文件大小:" +Files.size(e)+"字节");
	            }else {
	            	System.out.print("文件夹名称："+e.getFileName());
	            	System.out.println("  文件夹最后修改时间："+Files.getLastModifiedTime(e));
	            }	        	   	
	        }
	    }
    }
	
	public static void main(String []args) throws IOException {
		Readfolder I=new Readfolder();
		I.filetree();		
	}
}
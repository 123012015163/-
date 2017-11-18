package BufferRead;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

	public static void main(String []args) throws IOException, ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");//将时间精确到毫秒
		
		String res = sdf.format(new Date());//获取无缓冲区的开始时间
		TestNoBuffered I =new TestNoBuffered();
		I.ReadWriteFile();	
		String res2=sdf.format(new Date());//获取无缓冲区的结束时间
		
		String res3=sdf.format(new Date());//获取缓冲区的开始时间
		TestBuffered M=new TestBuffered();
		M.ReadAndWrite();
		String res4=sdf.format(new Date());//获取缓冲区的结束时间
		
		long result = sdf.parse(res2).getTime() - sdf.parse(res).getTime();
		long result2 = sdf.parse(res4).getTime() - sdf.parse(res3).getTime();
	    System.out.println("无缓冲文件读取输入花费的时间："+result+" ms");
	    System.out.println("有缓冲文件读取输入花费的时间："+result2+" ms");
	    long result3=result-result2;
	    System.out.println("有无缓冲的文件读取输入花费的时间差："+result3+" ms");


	}
}

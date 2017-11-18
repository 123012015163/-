package BufferRead;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestNoBuffered {

	/*先来测试一下不用缓冲区的读取写入*/
	public void ReadWriteFile() throws IOException{
		File file=new File("read.txt");
		File sfile=new File("write.txt");
		if(file.exists()){//判断文件是否存在
			FileInputStream in=new FileInputStream(file);//读取文件信息
			FileOutputStream out =new FileOutputStream(sfile);//写入文件信息
			byte[] b = new byte[1024];
			int i;
			if(sfile.exists()){//如果文件存在的话，则继续操作，不存在则建该文件夹
				while((i=in.read())!=-1){
					out.write(i);
				}
				in.close();
				out.close();
			}else{
				sfile.createNewFile();
				ReadWriteFile();
			}
			
		}
	}
}

package BufferRead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestBuffered {

	public void ReadAndWrite() throws IOException{
		File file=new File("read.txt");
		File sfile=new File("write.txt");
		if(file.exists()){
			FileWriter fw=new FileWriter(sfile);
			FileReader fr=new FileReader(file);
			BufferedReader read =new BufferedReader(fr);
			BufferedWriter write=new BufferedWriter(fw);
			if(sfile.exists()){
				String s=null;
				while((s=read.readLine())!=null){
					write.write(s);
				}
			}else{
				sfile.createNewFile();
				ReadAndWrite();
			}
		}else{
			return ;
		}
	}
}

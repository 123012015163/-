package first;
import first.First;
public class Third extends First{
      
      public void print(){
    	  System.out.println("����:"+name+",����:"+age);
      }
      
      public static void main(String[] args){
    	  Third H = new Third();
    	  H.print();
    	  H.printTelepghone();
    	  //�̳е����������û��printSalary�����������Ϊ��˽�е�,ͬһ������Ҳ�޷��̳�
    	  H.printSex();
      }
}

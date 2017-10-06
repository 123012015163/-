package first;
import first.First;
public class Third extends First{
      
      public void print(){
    	  System.out.println("姓名:"+name+",年龄:"+age);
      }
      
      public static void main(String[] args){
    	  Third H = new Third();
    	  H.print();
    	  H.printTelepghone();
    	  //继承的子类里面就没有printSalary这个函数，因为是私有的,同一个包内也无法继承
    	  H.printSex();
      }
}

package first.second;
import first.First;//引用first包里面的First类
public class second extends First {
     public static void main(String[] args){
    	 second M=new second();
    	 M.print();
    	 M.printTelepghone();
    	 //同样在另一个包里面的子类也无法继承private的元素
    	 //同样在另一个包里面的子类也无法继承default的元素
     }
}

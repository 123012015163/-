package first;

public class First {
   public String name="»ÆÐ¡¸Õ";
   public String address="ÆÎÌïÊÐ";
   public int age=11;
   protected String telephone="1234567890";
   private double salary=5000;
   String sex="ÄÐ";
   public void print(){
	   System.out.println(name);
   }
   public void PrintAdress(){
	   System.out.println(address);
   }
   
   public void PrintNameAddress(){
	   PrintAdress();
   }
   protected void printTelepghone(){
	   System.out.println(telephone);
   }
   
   private void printSalary(){
	   System.out.println(salary);
   }
   
   void printSex(){
	   System.out.println(sex);
   }
   
   public static void main(String[] args) {
	   First I = new First();
	   I.print();
	   System.out.println("************************");
	   I.PrintNameAddress();
	   System.out.println("************************");
	   I.printTelepghone();
	   System.out.println("************************");
	   I.printSalary();
	   System.out.println("************************");
	   I.printSex();
   }  
}



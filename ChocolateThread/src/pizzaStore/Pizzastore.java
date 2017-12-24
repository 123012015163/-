package pizzaStore;

import java.util.Scanner;

public class Pizzastore extends Thread{
	private static Thread []PizzaStore = new Thread[4];//这个地方相当于定义了4个线程
	SimplePizzaFactory Factory;
	private String Pizza;
	
	public Pizzastore(SimplePizzaFactory Factory,String pizza){//构造函数
		this.Factory=Factory;
		this.Pizza=pizza;
	}
	
	public synchronized Pizza orderPizza(){
		Pizza pizza=null;
		if(Pizza.equalsIgnoreCase("cheersePizza")){
			 pizza = Factory.createPizza("cheerse");
		}
		else if(Pizza.equalsIgnoreCase("pepperoniPizza")){
			 pizza= Factory.createPizza("pepperoni");
		}
		else if(Pizza.equalsIgnoreCase("clamPizza")){
			 pizza= Factory.createPizza("clam");
		}
		if(pizza==null){
			return null;
		}
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
	
	public void run()
	{
		orderPizza();
	}
	
	public static void main(String[] args) throws InterruptedException{
        SimplePizzaFactory lyz=new SimplePizzaFactory();//定义一个工厂
        String taste;
        for(int i=0;i<PizzaStore.length;i++){
        	Scanner sc = new Scanner(System.in);
        	System.out.print("请输入Pizza名称:");
        	taste = sc.nextLine();	
        	PizzaStore[i] = new Thread(new Pizzastore(lyz,taste));    
        	PizzaStore[i].start();
        	PizzaStore[i].join();
        }
	}
}

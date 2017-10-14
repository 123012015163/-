package pizzaStore;

public class Pizzastore {
	SimplePizzaFactory Factory;
	
	public Pizza orderPizza(String taste){//披萨商店接受订单
		Pizza pizza=null;
		if(taste.equalsIgnoreCase("cheersePizza")){
			 pizza = Factory.createPizza("cheerse");
		}
		else if(taste.equalsIgnoreCase("pepperoniPizza")){
			 pizza= Factory.createPizza("pepperoni");
		}
		else if(taste.equalsIgnoreCase("clamPizza")){
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
	
	public Pizzastore(SimplePizzaFactory Factory){//初始化披萨商店	
		this.Factory=Factory;
	}
	
	public static void main(String[] args){//main函数
        SimplePizzaFactory lyz=new SimplePizzaFactory();
		Pizzastore MY=new Pizzastore(lyz);
		MY.orderPizza("cheersePizza");
	}
	

}

package pizzaStore;

public class SimplePizzaFactory {
	public Pizza createPizza(String taste){//披萨工厂生产披萨
		if(taste==null){
			System.out.println("输入错误，无法生产");
			return null;
		}
		else if(taste.equalsIgnoreCase("cheerse")){
			System.out.println("生产cheerse披萨");
			return new cheersePizza();
		}
		else if(taste.equalsIgnoreCase("pepperoni")){
			System.out.println("生产pepperoni披萨");
			return new pepperoniPizza();
		}
		else if(taste.equalsIgnoreCase("clam")){
			System.out.println("生产clam披萨");
			return new clamPizza();
		}
		return null;		
	}	

}

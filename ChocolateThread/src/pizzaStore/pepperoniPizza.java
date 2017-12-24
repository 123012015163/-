package pizzaStore;

public class pepperoniPizza implements Pizza{
	public void prepare(){
		System.out.println("准备pepperoniPizza披萨");
	}
	public void bake(){
		System.out.println("烘焙pepperoniPizza披萨");
	}
	public void cut(){
		System.out.println("切割pepperoniPizza披萨");
	}
	public void box(){
		System.out.println("包装pepperoniPizza披萨");
	}	
}

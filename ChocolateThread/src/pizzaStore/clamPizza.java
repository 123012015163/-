package pizzaStore;

public class clamPizza implements Pizza{
	public void prepare(){
		System.out.println("准备clamPizza披萨");
	}
	public void bake(){
		System.out.println("烘焙clamPizza披萨");
	}
	public void cut(){
		System.out.println("切割clamPizza披萨");
	}
	public void box(){
		System.out.println("包装clamPizza披萨");
	}
}

package pizzaStore;

public class clamPizza implements Pizza{
	public void prepare(){
		System.out.println("准备clam披萨的材料");
	}
	public void bake(){
		System.out.println("烘焙clam披萨");
	}
	public void cut(){
		System.out.println("分割clam披萨");
	}
	public void box(){
		System.out.println("clam披萨包装");
	}
}

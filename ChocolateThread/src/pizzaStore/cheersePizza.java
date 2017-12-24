package pizzaStore;

public class cheersePizza implements Pizza{
	public void prepare(){
		System.out.println("准备cheerse披萨");
	}
	public void bake(){
		System.out.println("烘焙cheerse披萨");
	}
	public void cut(){
		System.out.println("切割cheerse披萨");
	}
	public void box(){
		System.out.println("包装cheerse披萨");
	}
}

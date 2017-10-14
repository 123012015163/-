package pizzaStore;

public class cheersePizza implements Pizza{
	public void prepare(){
		System.out.println("准备cheerse披萨的材料");
	}
	public void bake(){
		System.out.println("烘焙cheerse披萨");
	}
	public void cut(){
		System.out.println("分割cheerse披萨");
	}
	public void box(){
		System.out.println("cheerse披萨包装");
	}
}

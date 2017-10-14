package pizzaStore;

public class pepperoniPizza implements Pizza{
	public void prepare(){
		System.out.println("×¼±¸À±Ïã³¦ÅûÈøµÄ²ÄÁÏ");
	}
	public void bake(){
		System.out.println("ºæ±ºÀ±Ïã³¦ÅûÈø");
	}
	public void cut(){
		System.out.println("·Ö¸îÀ±Ïã³¦ÅûÈø");
	}
	public void box(){
		System.out.println("À±Ïã³¦ÅûÈø°ü×°");
	}	
}

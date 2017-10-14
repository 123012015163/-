package singleton;

public class test {
	public static void main(String[] args){
		ChocolateBoiler M =ChocolateBoiler.getI();
		ChocolateBoiler H =ChocolateBoiler.getI();
		M.fill();
		M.boil();
		H.fill();
		M.drain();
		H.fill();
		H.drain();
		H.boil();
		H.drain();
		
	}
}

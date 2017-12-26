package Chocolate;

public class test {
	private static Thread []Chocolateboilere = new Thread[4];//这个地方相当于定义了4个线程
	public static void main(String[] args) throws InterruptedException{
		ChocolateBoiler M =ChocolateBoiler.getI();
		for(int i=0;i<Chocolateboilere.length;i++){
			System.out.println("----------------");
			Chocolateboilere[i]=new Thread(M);
			Chocolateboilere[i].run();			
		}
	}
}
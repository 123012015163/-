package numberadd;

public class NumberAdd extends Thread{
private static Thread []Add = new Thread[4];
static int Sum=0;
	int num;
	public NumberAdd(int number){
		num=number;
	}
	
	public void run(){
		int count=0;
		for(int i=0;i<25;i++){
			count=count+num;
			num++;
			
		}
		Sum=Sum+count;
		System.out.print(count);
	}
	
	public static void main(String []args) throws InterruptedException{
		for(int i=0;i<Add.length;i++){//这里定义的i是线程数量
			int k=i*25+1;
			Add[i]= new Thread (new NumberAdd(k));
			System.out.print("第"+(i+1)+"线程计算结果：");
			Add[i].start();
			Add[i].join();
			System.out.println();
		}
		System.out.println("总和："+Sum);
	}
}

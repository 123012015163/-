package myfirstworks;
import java.util.*;
public class myFirstWorks {
    public static void main(String[] args){

    	myFirstWorks I=new myFirstWorks();
        I.leapYear();
        I.goal();
        I.PrintPhoto();
        I.daffodilNumber();
    }
    
    public void leapYear(){
    	System.out.println("���������1990-2007������");
    	for(int i=1990;i<=2007;i++){        		        	
    	     if(i%4==0){
    	    	 if(i%100!=0)
    	    		 System.out.println(i);       	    
    	    	 else if(i%400==0){ 
    	    		 System.out.println(i); 
    	         }
    	     } 
    	} 
    	System.out.println("***********************************");
    }
    
    public void goal(){

    	System.out.println("�������һ��ѧ���ĵȼ��ɼ�");
    	int[]a={99,70,50,88,92};
    	for(int i=0;i<a.length;i++){
    		if(a[i]>=90 && a[i]<=100){       		
    			System.out.println("��"+ (++i) +"λѧ������");
    		}
    		else if(a[i]>=80 && a[i]<=89){       		
    			System.out.println("��"+ (++i) +"λѧ������");
    		}
    		else if(a[i]>=70 && a[i]<=79){       		
    			System.out.println("��"+ (++i) +"λѧ���е�");
    		}
    		else if(a[i]>=60 && a[i]<=69){       		
    			System.out.println("��"+ (++i) +"λѧ������");
    		}
    		else{
    			System.out.println("��"+ (++i) +"λѧ��������");
    		}
    		i=i-1;
    	}
    	System.out.println("***********************************");
    }
    
    public void PrintPhoto(){
    	Scanner cout = new Scanner(System.in);
    	System.out.print("�����������ӡͼƬ������(����):");
    	int a = cout.nextInt();
    	if(a%2==0){
    		PrintPhoto();
    	}
    	else{
    		int k=0;
    		for(int i=0;i<a;i++){
    			if(i<(a/2)){
		    	for(k=i;k<(a/2);k++){
		    		System.out.print(' ');
		    		}
		    	for(k=0;k<(2*i+1);k++){
		    		System.out.print("*");
		    		}
		    	}
    			else if(i==(a/2)){
    				for(k=0;k<a;k++){
    					System.out.print("*");
    					}
    			}
    			else{
    				for(k=a/2;k<i;k++){
    					System.out.print(' ');
    				    }
    				for(k=1;k<(a-i)*2;k++){
    					System.out.print("*");
    					}
    				}
    			System.out.println();
    			}
    		System.out.println("***********************************");
    		}
    	}
    
    public void daffodilNumber(){
    	System.out.println("�����������ˮ�ɻ���");
    	for(int i=100;i<1000;i++){
    		int k;
    		int j;
    		int z;
    		k=i/100;
    		j=i/10-k*10;
    		z=i-k*100-j*10;
    		int sum=k*k*k+j*j*j+z*z*z;
    		if(sum==i)
    		{
    			System.out.println(i);
    		}
    	}
    	System.out.println("***********************************");
    }
}
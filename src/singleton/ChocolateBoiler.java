package singleton;

public class ChocolateBoiler {
	private ChocolateBoiler(){}
	private boolean empty = true;
	private boolean boiled = false;
	private static ChocolateBoiler I;
	
	public static ChocolateBoiler getI(){
		if(I==null){
			I=new ChocolateBoiler();
		}
		return I;
	}
	
	public void fill(){
		if(empty==true){
			System.out.println("��������ɿ�����ţ�̵Ļ����");
			empty=false;
			return;
		}
		System.out.println("�Բ�����������ʹ����");
	}
	
	public void boil(){
		if(empty==false && boiled==false){
			System.out.println("���ڿ�ʼ������");
			boiled=true;
			return;
		}
		System.out.println("�Բ�������Ϊ�ջ��������еĶ���δ��");
	}
	
	public void drain(){
		if(empty==false && boiled==true){
			System.out.println("���ڵ��������");
			empty=true;
			boiled=false;
			return;
		}
		System.out.println("�Բ���,����ﻹû�����������������Ʒ");
	}
	
	public int isEmpty(){
		if(empty==true)
		{
			return 1;
		}
		return 0;
	}
	
	public int isBoiled(){
		if(boiled==false){		
			return 1;
		}
		return 0;
	}
	
}

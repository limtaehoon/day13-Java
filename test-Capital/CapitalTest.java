package com.exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

 

public class CapitalTest {
	public static Scanner sc = new Scanner(System.in);//�������� ��ĵ����
	private HashMap<String,String> map = new HashMap<String, String>();//HashMap���� string ��
	File cdir, cfile;	//File �̸� ����

	public CapitalTest(){		
		cdir = new File("src\\com\\exam02");//�������� �ּ�
		cfile = new File(cdir, "capitalTest.txt");//������ ���� �̸�
		map.clear(); //map �����ϰ� �����ֱ�
		try {//����ó�� try catch ��
			if(!cfile.exists()){//������ ���ٸ� 
				cfile.createNewFile(); //���ϻ���
				return;
			}
			Scanner scanner = new Scanner(cfile);//����ͼ��� �Է¹޴� ��ĵ
			while (scanner.hasNext()){
				String country = scanner.next(); //����
				String capital = scanner.next(); //����
				map.put(country, capital);//�ʿ� ���� key�� ������ value������ ����
			}
			scanner.close();//����
			}
			catch (IOException e) {
			e.printStackTrace();//����ó�� catch
			}		
		}
	public  static void showMenu() {//�޴����
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		System.out.println("1. �Է�, 2.����, 3. �������� �� ����");
		System.out.println("���� >> ");
	}
	private void input() {

		while(true) {
			System.out.println("����� ���� �Է�(�����  x)>>");
			String cont = CapitalTest.sc.next(); //����
			if(cont.toUpperCase().equals("X")) break;//�ʿ� �Է��� ���� �ִ��� Ȯ��
				
			if(map.containsKey(cont)) { //map �� �Է��� ���� ������
				System.out.println("�̹� �Է��� �����Դϴ�.");
				continue; //�ݺ��� �ٽ� ���� �ض�
				}
			String sudo = CapitalTest.sc.next(); //����
			map.put(cont, sudo);

		}

	}
	private void quiz() {//�������� 
		Set<String>  set = map.keySet();//������ set�� ȣ��
		
		Object[] arr = set.toArray(); // set�� �迭 ���·� ��ȯ(������ �˱�����)
		while(true) {
			int n = (int)(Math.random()*map.size());//map�� ũ��ȿ��� ���� 
			String city =(String) arr[n];//���� �̸�
			String dosi = map.get(city);//�����̸�(��)

		    System.out.println(city +" �� ������ ? ����� x >>");
		    String answer = sc.next();//������ �Է¹ޱ�
		    if(answer.toLowerCase().equals("x")) break;//x��ҹ��� ������� ���� ���ڸ� ����
			if(answer.equals(dosi)) {//���� dosi���� ������ ���ٸ� 
				System.out.println("����");//"����"���
			}else {//�ƴϸ�
				System.out.println("Ʋ�Ƚ��ϴ�.");//"Ʋ��"���
			}		    
		}		
	}
 private void save(){//�����ϱ�
		   FileWriter fw=null;//File���°��� fw������ �ΰ�

		 try {    	//����ó�� try
			 fw = new FileWriter(cfile);//fw�� cfile�� ��
		     Set<String> set =map.keySet();
		     Iterator<String> it = set.iterator();
		    	  while(it.hasNext()) {//���ڰ� �ٲ���������
		    		  String key = it.next();
		    		  String value = map.get(key);
		    		  fw.write(key+"  ");
		    		  fw.write(value+"\n");
		    	  }
		    	  fw.close();
		    	  System.out.println("����");
		    	  System.exit(0);
		 } catch (IOException e) {//����ó�� catch ��
			  	e.printStackTrace();
			  		System.out.println("�������� ����");

		}

	}	  
public static void main(String[] args) {
			   CapitalTest ct = new CapitalTest();
			   while(true){
			CapitalTest.showMenu();
			int choice = CapitalTest.sc.nextInt();
		switch (choice){
			case 1: ct.input(); break;//���� �ֱ�
			case 2: ct.quiz(); break;//����
			case 3: ct.save(); break;//����
			default: System.out.println("�Է¿���");//�ƴϸ� "�Է¿���
			}
		}
	}		
}
	  

	

		

		

		

			

			

			

			

		

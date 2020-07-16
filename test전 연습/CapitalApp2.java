package IoTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import utilTest.CapitalApp;

public class CapitalApp2 {
	private HashMap<String,String> map    = new HashMap<String, String>();
    File dir, file;
    public CapitalApp2() {
    	dir = new File("src\\IoTest");
    	file = new File(dir, "myCapital.txt");
    	map.clear();
    	try {
	    	if(!file.exists()) { //���� ����
	    			file.createNewFile(); //���ϻ���
					return;
		   	} 
	    	Scanner scanner = new Scanner(file);
	    	while(scanner.hasNext()) {
	    		String country = scanner.next();  //����
	    		String capital = scanner.next() ;//����
	    		map.put(country, capital);
	    	}
	    	scanner.close();
		}catch (IOException e) {
			e.printStackTrace();
    	}
    }
	private void input() {
	  System.out.println("���� " +map.size() +" �� ����� ���� �Է�");
	
	  while(true) {
			System.out.println("����� ���� �Է�(�����  x)>>");
			String cont = CapitalApp.sc.next(); //����
			if(cont.toUpperCase().equals("X")) break;
				if(map.containsKey(cont)) { //map �� �Է��� ���� ����
				System.out.println("�̹� �Է��� �����Դϴ�.");
				continue;
			}
			String sudo = CapitalApp.sc.next(); //����
			 map.put(cont, sudo);
		}
  }
  private void quiz() {
		Set<String>  set = map.keySet();
		//System.out.println(map);
		//�迭�� ��ȯ
		Object[] arr = set.toArray(); // set�� �迭 ���·� ��ȯ(������ �˱�����)
		while(true) {
			int n = (int)(Math.random()*map.size());
			if(map.isEmpty()) return;
			String 	city=(String) arr[n];//���� �̸�
			String dosi = map.get(city);//�����̸�(��)
		    
		    //��������
		    System.out.println(city +" �� ������ ? ����� x >>");
		    String answer =CapitalApp. sc.next();
		    if(answer.toLowerCase().equals("x")) break;
		    if(answer.equals(dosi)) {
		    	System.out.println("����");
		    }else {
		    	System.out.println("Ʋ�Ƚ��ϴ�.");
		    }
		    
  		}
  }
  //�ؽ����� ���Ͽ� �����ϰ� �����ϴ� �޼ҵ�
  private void save() {
	  FileWriter fw=null;
	  //System.out.println(map);
	  try {
		 fw = new FileWriter(file);
		 Set<String> set =map.keySet();  // ���� ������
		 Iterator<String> it = set.iterator();//���� �湮�ϱ� ����
		   while(it.hasNext()) {
			   String key = it.next(); //��������
			   String value = map.get(key) ;// ���� ������
			   fw.write(key+"  "); //���� ���
			   fw.write(value+"\n"); //�������
		   }
		   fw.close();
		   System.out.println("����");
		   System.exit(0);
		
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("�������� ����");
	}
	  
	  
	  
  }
	public static void main(String[] args) {
		CapitalApp2 ca2 = new CapitalApp2();
		while(true) {
			CapitalApp.showMenu();
			int choice = CapitalApp.sc.nextInt();
			switch (choice) {
			case 1 : ca2.input();	break;
			case 2 : ca2.quiz(); break;
			case 3 : ca2.save(); break;
			default: System.out.println("�Է¿���");
			}
			
		}
	}

}

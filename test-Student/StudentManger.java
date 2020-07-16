package com.exam01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManger {//Main


static Scanner sc=new Scanner(System.in);//Scanner�� ���� �Է� ����
ArrayList<Student>arr=new ArrayList<Student>();
File sdir,sfile;//�����̸�

public StudentManger() throws FileNotFoundException, IOException, ClassNotFoundException {
	sdir=new File("src\\com\\exam01");//������ �޴°�
	sfile=new File(sdir,"student.txt");//���� ������ txt����
	if(sfile.exists()) {
		ObjectInputStream ois=new ObjectInputStream
							(new FileInputStream(sfile));//sfile�� ����
		arr=(ArrayList<Student>)ois.readObject();
	}else {
		sfile.createNewFile();//������ sfile����
	}
	
}


public static void showMenu() {//�޴����̱�
	System.out.println("�����ϼ���");
	System.out.println("1.������ �Է�");//inputData
	System.out.println("2.��ü����");//viewData
	System.out.println("3.�л�ã��"); //searchData
	System.out.println("4.����/����");//saveData
	System.out.println("����>>");
	}
//
public void inputData() {//�����Է�
	
	while (true) {
	System.out.println("�л� �̸�,�а�,�й�,������� �Է��ϼ��� (,�� ���� ����� x ");//1 ������ �Է�
	System.out.println(">>");
	String text=StudentManger.sc.nextLine();
	if(text.toLowerCase().equals("x")) {//����� x ���ڰ� ������ Ȯ��
		System.out.println("�Է�����");//����� ���
	break;
	}StringTokenizer st=new StringTokenizer(text,",");
	String name=st.nextToken();//�̸�
	String ID=st.nextToken();//�а�
	String num=st.nextToken();//�й�
	double avg=Double.parseDouble(st.nextToken());//����
	arr.add(new Student(name, ID, num, avg));
	}	
}

public void veiwData() {//��ü����
System.out.println("�л�����");
for(Student student:arr) {
	System.out.println("�̸�:"+student.getName());
	System.out.println("�а�:"+student.getID());
	System.out.println("�й�:"+student.getNum());
	System.out.println("������:"+student.getAvg());
	System.out.println("========");
}


}
public void searchData() {//�˻��ϱ�
	System.out.println("����");
	System.out.println("ã�� �л� �̸�");
	String searchName=StudentManger.sc.next();//ã�� �л������͸� 
											//	searchName�� �޾Ƽ�					
	Student s=search(searchName);			//Student s�� ����
	if(s==null) {				//���࿡ s�� �𸦰��
		System.out.println("ã�� �л�����");//���
	return;//�ٽù�ȯ
	}
	System.out.println("�̸�:"+s.getName());
	System.out.println("�а�:"+s.getID());
	System.out.println("�й�:"+s.getNum());
	System.out.println("�������:"+s.getAvg());
}



private Student search(String searhName) {//�˻��ϱ�
	for(int i=0;i<arr.size();i++) {	//�迭������� ã��
		if(searhName.equals(arr.get(i).getName())) {//searhName.equals=�̸����ڿ� 
			return arr.get(i);						//getName�� ���ڰ� ������ �������				
		}
	}
	return null;
	
}

public void saveData() throws FileNotFoundException, IOException, ClassNotFoundException {
	
	
	ObjectOutputStream oos=
			new ObjectOutputStream(new FileOutputStream(sfile));//Object�� sfile������
	oos.writeObject(arr);//�迭������ ��
}



public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
	StudentManger sm=new StudentManger();
	while(true) {
		StudentManger.showMenu();
		int num=sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:sm.inputData();break;//inputData =���� �Է� 
		case 2:sm.veiwData();break;//veiwData=��ü����
		case 3:sm.searchData();break;//searchData=�˻��ϱ�
		case 4:sm.saveData();//saveData=����
				System.out.println("����");
				System.exit(0);
		default:System.out.println("�Է¿���");
		
			
		}
	
	
}
}

}

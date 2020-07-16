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


static Scanner sc=new Scanner(System.in);//Scanner로 문자 입력 받음
ArrayList<Student>arr=new ArrayList<Student>();
File sdir,sfile;//파일이름

public StudentManger() throws FileNotFoundException, IOException, ClassNotFoundException {
	sdir=new File("src\\com\\exam01");//파일을 받는곳
	sfile=new File(sdir,"student.txt");//파일 보내는 txt파일
	if(sfile.exists()) {
		ObjectInputStream ois=new ObjectInputStream
							(new FileInputStream(sfile));//sfile에 저장
		arr=(ArrayList<Student>)ois.readObject();
	}else {
		sfile.createNewFile();//없으면 sfile만듬
	}
	
}


public static void showMenu() {//메뉴보이기
	System.out.println("선택하세요");
	System.out.println("1.데이터 입력");//inputData
	System.out.println("2.전체보기");//viewData
	System.out.println("3.학생찾기"); //searchData
	System.out.println("4.저장/종료");//saveData
	System.out.println("선택>>");
	}
//
public void inputData() {//정보입력
	
	while (true) {
	System.out.println("학생 이름,학과,학번,학점평균 입력하세요 (,로 구분 종료는 x ");//1 데이터 입력
	System.out.println(">>");
	String text=StudentManger.sc.nextLine();
	if(text.toLowerCase().equals("x")) {//종료시 x 문자가 같은지 확인
		System.out.println("입력종료");//종료시 출력
	break;
	}StringTokenizer st=new StringTokenizer(text,",");
	String name=st.nextToken();//이름
	String ID=st.nextToken();//학과
	String num=st.nextToken();//학번
	double avg=Double.parseDouble(st.nextToken());//학점
	arr.add(new Student(name, ID, num, avg));
	}	
}

public void veiwData() {//전체보기
System.out.println("학생보기");
for(Student student:arr) {
	System.out.println("이름:"+student.getName());
	System.out.println("학과:"+student.getID());
	System.out.println("학번:"+student.getNum());
	System.out.println("평군학점:"+student.getAvg());
	System.out.println("========");
}


}
public void searchData() {//검색하기
	System.out.println("보기");
	System.out.println("찾을 학생 이름");
	String searchName=StudentManger.sc.next();//찾을 학생데이터를 
											//	searchName로 받아서					
	Student s=search(searchName);			//Student s에 대입
	if(s==null) {				//만약에 s를 모를경우
		System.out.println("찾을 학생없음");//출력
	return;//다시반환
	}
	System.out.println("이름:"+s.getName());
	System.out.println("학과:"+s.getID());
	System.out.println("학번:"+s.getNum());
	System.out.println("학점평균:"+s.getAvg());
}



private Student search(String searhName) {//검색하기
	for(int i=0;i<arr.size();i++) {	//배열순서대로 찾기
		if(searhName.equals(arr.get(i).getName())) {//searhName.equals=이름문자와 
			return arr.get(i);						//getName의 문자가 같으면 내용출력				
		}
	}
	return null;
	
}

public void saveData() throws FileNotFoundException, IOException, ClassNotFoundException {
	
	
	ObjectOutputStream oos=
			new ObjectOutputStream(new FileOutputStream(sfile));//Object로 sfile내보냄
	oos.writeObject(arr);//배열순으로 씀
}



public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
	StudentManger sm=new StudentManger();
	while(true) {
		StudentManger.showMenu();
		int num=sc.nextInt();
		sc.nextLine();
		switch (num) {
		case 1:sm.inputData();break;//inputData =문자 입력 
		case 2:sm.veiwData();break;//veiwData=전체보기
		case 3:sm.searchData();break;//searchData=검색하기
		case 4:sm.saveData();//saveData=저장
				System.out.println("종료");
				System.exit(0);
		default:System.out.println("입력오류");
		
			
		}
	
	
}
}

}

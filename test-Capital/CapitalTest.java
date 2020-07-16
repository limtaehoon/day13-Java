package com.exam02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

 

public class CapitalTest {
	public static Scanner sc = new Scanner(System.in);//전역으로 스캔받음
	private HashMap<String,String> map = new HashMap<String, String>();//HashMap으로 string 값
	File cdir, cfile;	//File 이름 설정

	public CapitalTest(){		
		cdir = new File("src\\com\\exam02");//받을파일 주소
		cfile = new File(cdir, "capitalTest.txt");//내보낼 파일 이름
		map.clear(); //map 깨끗하게 지워주기
		try {//예외처리 try catch 문
			if(!cfile.exists()){//파일이 없다면 
				cfile.createNewFile(); //파일생성
				return;
			}
			Scanner scanner = new Scanner(cfile);//나라와수도 입력받는 스캔
			while (scanner.hasNext()){
				String country = scanner.next(); //나라
				String capital = scanner.next(); //수도
				map.put(country, capital);//맵에 나라를 key로 수도를 value값으로 받음
			}
			scanner.close();//종료
			}
			catch (IOException e) {
			e.printStackTrace();//예외처리 catch
			}		
		}
	public  static void showMenu() {//메뉴출력
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		System.out.println("1. 입력, 2.퀴즈, 3. 파일저장 및 종료");
		System.out.println("선택 >> ");
	}
	private void input() {

		while(true) {
			System.out.println("나라와 수도 입력(종료는  x)>>");
			String cont = CapitalTest.sc.next(); //나라
			if(cont.toUpperCase().equals("X")) break;//맵에 입력한 나라가 있는지 확인
				
			if(map.containsKey(cont)) { //map 에 입력한 나라 있을때
				System.out.println("이미 입력한 나라입니다.");
				continue; //반복문 다시 실행 해라
				}
			String sudo = CapitalTest.sc.next(); //수도
			map.put(cont, sudo);

		}

	}
	private void quiz() {//문제내기 
		Set<String>  set = map.keySet();//맵으로 set값 호출
		
		Object[] arr = set.toArray(); // set을 배열 형태로 변환(순서를 알기위해)
		while(true) {
			int n = (int)(Math.random()*map.size());//map의 크기안에서 랜덤 
			String city =(String) arr[n];//나라 이름
			String dosi = map.get(city);//수도이름(답)

		    System.out.println(city +" 의 수도는 ? 종료는 x >>");
		    String answer = sc.next();//문제값 입력받기
		    if(answer.toLowerCase().equals("x")) break;//x대소문자 상관없이 같은 문자면 멈춤
			if(answer.equals(dosi)) {//만약 dosi값과 정답이 같다면 
				System.out.println("정답");//"정답"출력
			}else {//아니면
				System.out.println("틀렸습니다.");//"틀림"출력
			}		    
		}		
	}
 private void save(){//저장하기
		   FileWriter fw=null;//File쓰는것을 fw값으로 두고

		 try {    	//예외처리 try
			 fw = new FileWriter(cfile);//fw를 cfile에 씀
		     Set<String> set =map.keySet();
		     Iterator<String> it = set.iterator();
		    	  while(it.hasNext()) {//문자가 다끌날때까지
		    		  String key = it.next();
		    		  String value = map.get(key);
		    		  fw.write(key+"  ");
		    		  fw.write(value+"\n");
		    	  }
		    	  fw.close();
		    	  System.out.println("종료");
		    	  System.exit(0);
		 } catch (IOException e) {//예외처리 catch 문
			  	e.printStackTrace();
			  		System.out.println("파일저장 오류");

		}

	}	  
public static void main(String[] args) {
			   CapitalTest ct = new CapitalTest();
			   while(true){
			CapitalTest.showMenu();
			int choice = CapitalTest.sc.nextInt();
		switch (choice){
			case 1: ct.input(); break;//정보 넣기
			case 2: ct.quiz(); break;//문제
			case 3: ct.save(); break;//저장
			default: System.out.println("입력오류");//아니면 "입력오류
			}
		}
	}		
}
	  

	

		

		

		

			

			

			

			

		

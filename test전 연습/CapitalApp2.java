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
	    	if(!file.exists()) { //파일 없음
	    			file.createNewFile(); //파일생성
					return;
		   	} 
	    	Scanner scanner = new Scanner(file);
	    	while(scanner.hasNext()) {
	    		String country = scanner.next();  //나라
	    		String capital = scanner.next() ;//수도
	    		map.put(country, capital);
	    	}
	    	scanner.close();
		}catch (IOException e) {
			e.printStackTrace();
    	}
    }
	private void input() {
	  System.out.println("현재 " +map.size() +" 개 나라와 수도 입력");
	
	  while(true) {
			System.out.println("나라와 수도 입력(종료는  x)>>");
			String cont = CapitalApp.sc.next(); //나라
			if(cont.toUpperCase().equals("X")) break;
				if(map.containsKey(cont)) { //map 에 입력한 나라 있음
				System.out.println("이미 입력한 나라입니다.");
				continue;
			}
			String sudo = CapitalApp.sc.next(); //수도
			 map.put(cont, sudo);
		}
  }
  private void quiz() {
		Set<String>  set = map.keySet();
		//System.out.println(map);
		//배열로 변환
		Object[] arr = set.toArray(); // set을 배열 형태로 변환(순서를 알기위해)
		while(true) {
			int n = (int)(Math.random()*map.size());
			if(map.isEmpty()) return;
			String 	city=(String) arr[n];//나라 이름
			String dosi = map.get(city);//수도이름(답)
		    
		    //문제출제
		    System.out.println(city +" 의 수도는 ? 종료는 x >>");
		    String answer =CapitalApp. sc.next();
		    if(answer.toLowerCase().equals("x")) break;
		    if(answer.equals(dosi)) {
		    	System.out.println("정답");
		    }else {
		    	System.out.println("틀렸습니다.");
		    }
		    
  		}
  }
  //해쉬맵을 파일에 저장하고 종료하는 메소드
  private void save() {
	  FileWriter fw=null;
	  //System.out.println(map);
	  try {
		 fw = new FileWriter(file);
		 Set<String> set =map.keySet();  // 나라만 가져옴
		 Iterator<String> it = set.iterator();//나라를 방문하기 위해
		   while(it.hasNext()) {
			   String key = it.next(); //나라가져옴
			   String value = map.get(key) ;// 수도 가져옴
			   fw.write(key+"  "); //나라 출력
			   fw.write(value+"\n"); //수도출력
		   }
		   fw.close();
		   System.out.println("종료");
		   System.exit(0);
		
	} catch (IOException e) {
		e.printStackTrace();
		System.out.println("파일저장 오류");
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
			default: System.out.println("입력오류");
			}
			
		}
	}

}

package com.exam01;
import java.io.Serializable;
public class Student implements Serializable  {//직렬화
	private String name;//이름
	private String ID;//학과
	private String num;//학번
	private double avg;//학점평균
public String getName() {//getter
	return name;
}
public void setName(String name) {//setter
	this.name = name;
}
public String getID() {//getter
	return ID;
}
public void setID(String iD) {//setter
	ID = iD;
}
public String getNum() {//getter
	return num;
}
public void setNum(String num) {//setter
	this.num = num;
}
public double getAvg() {//getter
	return avg;
}
public void setAvg(double avg) {//setter
	this.avg = avg;
}
public Student(String name,String ID,String num,double avg) {//학점평균은 double형
	this.name=name;
	this.ID=ID;
	this.num=num;
	this.avg=avg;
}
}


package com.exam01;
import java.io.Serializable;
public class Student implements Serializable  {//����ȭ
	private String name;//�̸�
	private String ID;//�а�
	private String num;//�й�
	private double avg;//�������
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
public Student(String name,String ID,String num,double avg) {//��������� double��
	this.name=name;
	this.ID=ID;
	this.num=num;
	this.avg=avg;
}
}


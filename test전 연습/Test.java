package test;
class Person {
	String name;
	int age;
	public Person(String name, int age) {
		// TODO Auto-generated constructor stub
	this.name=name;
	this.age=age;
	}
	public void show() {
		System.out.println(name+""+age+"");
	}
}
class Student extends Person{
	String major;
	
	public Student(String name, int age,String major) {
		super(name,age);
		this.major=major;
	}
	@Override
	public void show() {
		super.show();
		System.out.println(major);
	}
}
	
	public class Test{
		int y;
	

	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		Person p=new Student("���ڹ�",25,"ȸ���");
 		p.show();//���ڹ� 25 ȸ���
 		int x=10;//���������� �ݵ�� �ʱⰪ�� �־�ߵȴ�
		System.out.println(x);
		Test t=new Test();
		System.out.println(t.y);//��������� int���̸� 0���� �����ȴ�
	
	
	}
	
}

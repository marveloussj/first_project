package one;

public class Person {
	String name;
	String sex;
	int age;
	public  Person(String name,String sex,int age) {
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	public Person()
	{
		
	}
	public String getname() 
	{
		return name;
	}
	public String getsex() 
	{
		return sex;
	}
	public int getage() 
	{
		return age;
	}
}

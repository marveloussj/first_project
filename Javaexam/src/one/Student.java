package one;

public class Student extends Person {
 String id;
 public Student(String id,String name,String sex,int age)
 {
	// super(name,sex,age); 
	 this.id=id;
     super.name=name;
     super.age=age;
     super.sex=sex;
 }
 public String getid()
 {
	 return id;
 }
}

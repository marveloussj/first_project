package one;

public class Cz {

	public static void main(String[] args) {
		Student S1=new Student("001","syy","ÄĞ",20);
		Student S2=new Student("002","sy","ÄĞ",22);
		System.out.println(S1.getid()+S1.getname()+S1.getsex()+S1.age);
		System.out.println(S2.getid()+S2.getname()+S2.getsex()+S2.age);
	}

}

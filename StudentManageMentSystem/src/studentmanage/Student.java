package studentmanage;

public class Student {
String id;
String name;
int math;
int Chinese;
int totalscore;

public Student(String id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public String getId() {
	return id;
}

public String getName() {
	return name;
}

public int getMath() {
	return math;
}
public void setMath(int math) {
	this.math = math;
}
public int getChinese() {
	return Chinese;
}
public void setChinese(int chinese) {
	Chinese = chinese;
}
public int getTotalscore() {
	return totalscore;
}
public void setTotalscore(int totalscore) {
	this.totalscore = totalscore;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", math=" + math
			+ ", Chinese=" + Chinese + ", totalscore=" + totalscore + "]";
}

}

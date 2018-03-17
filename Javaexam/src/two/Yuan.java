package two;

public abstract class Yuan {
 double PI= 3.14;
 int r;
 public Yuan(int r)
 {
	 this.r=r;
 }
 public Yuan()
 {
	 
 }
 public double mj()
 {
	 return PI*r*r;
 }
 public abstract double tj();
}

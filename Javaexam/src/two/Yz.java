package two;

public class Yz extends Yuan {
	double h;
	public Yz(int r,double h) {	
		super(r);
		this.h=h;
		
	}
	public double mj()
	{
		return PI*r*h;
		
	}
	public double tj() {
	
		return PI*r*r*h;
	}

}

package cylinder;

import circle.Circle;

public class Cylinder extends Circle {
	int h;
	public Cylinder(int radius,int h)
	{
		super(radius);
		this.h=h;
	}
	public double area()
	{
		return PI*radius*h;
	}
	public double volume()
	{
		return PI*radius*radius*h;
	}
}

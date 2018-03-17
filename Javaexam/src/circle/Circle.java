package circle;

import Shape.Shape;

public class Circle implements Shape{
	public int radius;
	public Circle()
	{
	}
	public Circle(int radius)
	{
		this.radius=radius;
	}
	public double area() {
		return PI*radius*radius;
	}
	public double perimeter()
	{
		return 2*PI*radius;
		
	}
	
}

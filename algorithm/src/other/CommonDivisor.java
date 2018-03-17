package other;

import java.util.Scanner;

public class CommonDivisor {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c=0;
		if(a>b){
			c=a;
		}else{
			c=b;
		}
		for (int i = c; i <=a*b; i+=c) {
			if(i%a==0&&i%b==0){
				System.out.println(i);
				return;
			}
		}
	}
	
}

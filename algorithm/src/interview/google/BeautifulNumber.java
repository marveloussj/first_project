package interview.google;

import java.util.Scanner;

public class BeautifulNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int size = sc.nextInt();
	for(int i=0;i<size;i++){
		int n=sc.nextInt();
		System.out.println("case #"+n+"=>"+beautiful(n));
	}
}

private static int beautiful(int n) {
	for(int i=2;i<n;i++){
		if(isBeautiful(n,i)){
			return i;
		}
	}
	return n-1;
}

private static boolean isBeautiful(int n, int i) {
	while(n>0){
		int bit=n%i;
		if(bit !=1){
			return false;
		}
		n=n/i;
	}
	return true;
}


}

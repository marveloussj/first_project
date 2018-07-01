package other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PaiLie {
	  
    private ArrayList<String> res = new ArrayList<String>();  
    public void printPermutationResult(String str) {    
        Iterator<String> it = res.iterator();  
        while (it.hasNext()) {  
            System.out.println(it.next());  
        }  
    }  
    public  void strArrange(char[] source, int len, int mark) {  
      
        if (mark == len) {  
            String strTemp = "";  
            for (int x = 0; x <= len; x++) {  
                strTemp += source[x];  
            }  
            res.add(strTemp);   
        } else {  
            for (int i = mark; i <= len; i++) {  
                swap(source, mark, i);  
                strArrange(source, len, mark + 1);  
                swap(source, mark, i);  
            }  
        }  
    }  
  
    private static void swap(char[] source, int pos1, int pos2) {  
        char temp = source[pos1];  
        source[pos1] = source[pos2];  
        source[pos2] = temp;  
    }  
	 public static void main(String[] args) {
		  Scanner s = new Scanner(System.in);
		  int a = s.nextInt();
		  String str = s.next();
		  char[] charArray = str.toCharArray();
		  PaiLie pl=new PaiLie();
		 pl.strArrange(charArray, a-1, 0);  
		 pl.printPermutationResult(str);
		 }

}

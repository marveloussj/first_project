package five;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.ws.WebFault;


public class Inoutput {
public static void main(String[] args) {
	File file=new File("D:/aa/aa.txt");
	try {
		FileInputStream in=new FileInputStream(file);
		byte b[]=new byte[10];
		int n=0;
		FileOutputStream out=new FileOutputStream("D:/bb/dd.txt");
		try {
			while((n=in.read(b))!=-1)
			{
			out.write(b, 0, n);
				System.out.println(n);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

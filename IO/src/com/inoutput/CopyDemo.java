package com.inoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {
public static void main(String[] args) throws IOException {
	File file= new File("file/text");
	File file1= new File("file/text_copy");
	InputStream in= new FileInputStream(file);
	OutputStream out= new FileOutputStream(file1);
	byte [] buffer=new byte[5];
	int len=0;
	while((len=in.read(buffer))!=-1){
		//System.out.println(new String(buffer,0,len));
		out.write(buffer, 0 , len);
	}
	in.close();
}
	
	
}

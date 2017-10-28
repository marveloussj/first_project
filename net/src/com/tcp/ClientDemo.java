package com.tcp;

import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
	public static void main(String[] args) throws Exception{
			Socket client= new Socket("localhost",8888);
			Scanner in = new Scanner(client.getInputStream());
			while(in.hasNextLine()){
				String line =in.nextLine();
				System.out.println(line);	
			}
			in.close();
			client.close();
	}

}

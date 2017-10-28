package com.tcp;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
	public static void main(String[] args) throws Exception {
		String data ="sj是真的猛";
		ServerSocket server =new ServerSocket(8888);
		System.out.println("服务端已经启动....");
		Socket client = server.accept();
		System.out.println(client.getInetAddress());
		PrintStream out=new PrintStream(client.getOutputStream());
		out.println(data);
		out.close();
		server.close();
	}
	
}

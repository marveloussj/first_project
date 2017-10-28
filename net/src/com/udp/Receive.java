package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receive {
public static void main(String[] args) throws Exception {
	DatagramSocket receiver =new DatagramSocket(10086);
	byte[] buffer=new byte[1024];
	DatagramPacket dp =new DatagramPacket(buffer, buffer.length);
	receiver.receive(dp);
	String msg=new String(dp.getData(),0,dp.getLength());
	System.out.println(msg);
	receiver.close();
}
}

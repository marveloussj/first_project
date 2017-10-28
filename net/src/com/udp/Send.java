package com.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
public static void main(String[] args) throws Exception {
	DatagramSocket sender= new DatagramSocket(10010);
	String s="sjÊÇÕæµÄNB";
	DatagramPacket dp= new DatagramPacket(s.getBytes(),s.getBytes().length,InetAddress.getByName("183.144.60.241"), 10086);
			sender.send(dp);
			sender.close();

}


}

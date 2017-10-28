package com.ucl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URlDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https", "www.baidu.com", "/index.php?tn=98012088_3_dg&ch=1");
		
		/*URLConnection con = url.openConnection();
		InputStream in = con.getInputStream();
*/
		InputStream in= url.openStream();
		BufferedReader buffered=new BufferedReader(new InputStreamReader(in,"UTF-8"));
		Scanner sc = new Scanner(buffered);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			System.out.println(line);
		}
		sc.close();
		// Files.copy(in, Paths.get("xx.png"));
		
	}
}

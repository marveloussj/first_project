package loadproperties;

import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class Motherboard  {
	private static Properties p=new Properties();
	static{
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("plugins.properties"));
			Collection<Object> values= p.values();
			for (Object object : values) {
				Class clz=Class.forName((String) object);
				work((USB) clz.newInstance());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public static void work(USB usb){
   usb.swapData(); 	
}
}

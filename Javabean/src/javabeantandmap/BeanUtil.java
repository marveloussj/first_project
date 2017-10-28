package javabeantandmap;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * javabean 和 map 之间的转化
 * @author sj
 * 
 */
public class BeanUtil {
	//把JavaBean转换为Map对象.
	   public static Map<String,Object> bean2map(Object bean) throws Exception{
		  Map<String,Object> map= new HashMap<String,Object>();
		    Class<?> clz = bean.getClass();
		    BeanInfo info = Introspector.getBeanInfo(clz,Object.class);
		    PropertyDescriptor[] pds = info.getPropertyDescriptors();
		    for (PropertyDescriptor pd : pds) {
		    	//获取key
				String key = pd.getName();
				//获取value
				Method method = pd.getReadMethod();
				Object value = method.invoke(bean);
				map.put(key, value);
			}
		   return map;
	   	}
	//把Map对象转换为JavaBean.
	   public static <T> T map2bean(Map<String,Object> beanMap,Class<T> beanType) throws Exception{
		   T obj = beanType.newInstance();
		   BeanInfo info = Introspector.getBeanInfo(beanType,Object.class);
		   PropertyDescriptor[] pds = info.getPropertyDescriptors();
		   for (PropertyDescriptor pd : pds) {
			//获取map
			 String key = pd.getName();
			//获取value
			 Object value = beanMap.get(key);
			Method method = pd.getWriteMethod();
			method.invoke(obj,value);
		}
		 return obj;  
	   }
}

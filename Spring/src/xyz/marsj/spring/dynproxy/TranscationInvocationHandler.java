package xyz.marsj.spring.dynproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TranscationInvocationHandler implements InvocationHandler {
	private IEmployeeService service;
	private TranscationManager tx;
	

	public TranscationInvocationHandler(IEmployeeService service, TranscationManager tx) {
		super();
		this.service = service;
		this.tx = tx;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		tx.begin();
		try {
			Object ret = method.invoke(service, args);
			tx.commit();
			return ret;
		} catch (Exception e) {
			tx.rollback();
		}
		return null;
	}

}

package xyz.marsj.spring.transfer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration

public class TxTest {
	@Autowired
	private IAccountService service;
	@Test
	public void testTx(){
		service.transfer(11L, 22L, 100D);
	}
}

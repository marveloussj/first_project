package xyz.marsj.spring.transfer;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	@Override
	public void transin(Long id, Double amount) {
		this.getJdbcTemplate().update("UPDATE account SET balance=balance+? Where id=?",amount,id );

	}

	@Override
	public void transout(Long id, Double amount) {
		this.getJdbcTemplate().update("UPDATE account SET balance=balance-? Where id=?",amount,id );

	}

}

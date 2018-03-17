package xyz.marsj.spring.transfer;

public class AccountService implements IAccountService {

	private IAccountDao dao;
	
	public void setDao(IAccountDao dao) {
		this.dao = dao;
	}

	@Override
	public void transin(Long id, Double amount) {
		dao.transin(id, amount);
	}

	@Override
	public void transout(Long id, Double amount) {
		dao.transout(id, amount);

	}

	@Override
	public void transfer(Long inid, Long outid, Double amount) {
		this.transin(inid, amount);
		int i=1/0;
		this.transout(outid, amount);
	}

}

package xyz.marsj.spring.transfer;

public interface IAccountDao {
	void transin(Long id,Double amount);
	void transout(Long id,Double amount);

}

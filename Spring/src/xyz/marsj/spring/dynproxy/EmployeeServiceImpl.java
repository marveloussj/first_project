package xyz.marsj.spring.dynproxy;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Override
	public void save(Employee e) {
			System.out.println("save e");
			int i=1/0;
			}

	@Override
	public void update(Employee e) {
		System.out.println("update e");
	}

}

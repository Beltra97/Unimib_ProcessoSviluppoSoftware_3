package worksocialmedia.repository;

import java.util.Optional;

import worksocialmedia.model.Company;
import worksocialmedia.model.Job;
import worksocialmedia.model.User;
import worksocialmedia.model.Work;

public interface WorkRepository extends Repository<Work, Long>{

	public Optional<User> findUserById(Long id);
	
	public Optional<Company> findCompanyById(Long id);
	
	public Optional<Job> findJobById(Long id);
	
	public void deleteWorkById(Long id);

	public void addWork(Work work);
	
	public void updateWork(Long id, Integer salary, String startDate, String endDate);
	
	public Work searchWorkSalary(Integer workSearchSalary);
	
	public Work searchWorkStartDate(String workSearchStartDate);
	
	public int getSize();
	
}

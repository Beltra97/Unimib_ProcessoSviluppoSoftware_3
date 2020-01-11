package worksocialmedia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.Company;
import worksocialmedia.model.Job;
import worksocialmedia.model.User;
import worksocialmedia.model.Work;
import worksocialmedia.repository.CompanyRepository;
import worksocialmedia.repository.CompanyRepositoryImpl;
import worksocialmedia.repository.JobRepository;
import worksocialmedia.repository.JobRepositoryImpl;
import worksocialmedia.repository.UserRepository;
import worksocialmedia.repository.UserRepositoryImpl;
import worksocialmedia.repository.WorkRepository;
import worksocialmedia.repository.WorkRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
public class WorkTest {

	private UserRepository userRepository = new UserRepositoryImpl();
	private CompanyRepository companyRepository = new CompanyRepositoryImpl();
	private JobRepository jobRepository = new JobRepositoryImpl();
	private WorkRepository workRepository = new WorkRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddWork() {
		long ID = 1;
		Optional<User> user = userRepository.findById(ID);
		Optional<Company> company = companyRepository.findById(ID);
		Optional<Job> job = jobRepository.findById(ID);
		int salary = 25000;
		String startDate = "01/01/2018";
		String endDate = "31/12/2018";
		
		user.ifPresent(u -> {
			company.ifPresent(c -> {
				job.ifPresent(j -> {
					Work work = new Work(u, c, j, salary, startDate, endDate);
					workRepository.addWork(work);
				});
			});
		});
		
		int size = workRepository.getSize();
		assertEquals(size, 4);
	}
	
	@Test
	@Order(2)
	void testUpdateWork() {
		long id = 4;
		int salary = 25000;
		String startDate = "01/01/2018";
		String endDate = "31/12/2018";
		
		workRepository.updateWork(id, salary, startDate, endDate);
		
		Optional<Work> work = workRepository.findById(id);
		work.ifPresent(a -> {
			assertEquals(a.getSalary(), salary);
			assertEquals(a.getStartDate(), startDate);
			assertEquals(a.getEndDate(), endDate);
		});
	}
	
	@Test
	@Order(3)
	void testDeleteWork() {
		long ID = 4;
		workRepository.deleteWorkById(ID);
		
		int size = workRepository.getSize();
		assertEquals(size, 3);
	}
}

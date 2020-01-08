package worksocialmedia.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.Job;
import worksocialmedia.repository.JobRepository;
import worksocialmedia.repository.JobRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
public class JobTest {

	private JobRepository jobRepository = new JobRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddAddressJob() {
		String name = "programmatore";
		String category = "programmatore";
		String description = "Lorem ipsum";
		
		Job job = new Job(name, category, description);
		
		jobRepository.addJob(job);
		
		int size = jobRepository.getSize();
		assertEquals(size, 6);
	}
	
	@Test
	@Order(2)
	void testUpdateJob() {
		long id = 6;
		String name = "Pilot";
		String category = "Pilot";
		String description = "Lorem ipsum";
		
		jobRepository.updateJob(id, name, category, description);
		Optional<Job> job = jobRepository.findById(id);

		job.ifPresent(a -> {
			assertEquals(a.getName(), name);
			assertEquals(a.getCategory(), category);
			assertEquals(a.getDescription(), description);
		});
	}
	
	@Test
	@Order(3)
	void testDeleteJob() {
		long ID = 6;
		jobRepository.deleteJobById(ID);
		
		int size = jobRepository.getSize();
		assertEquals(size, 5);
	}
}

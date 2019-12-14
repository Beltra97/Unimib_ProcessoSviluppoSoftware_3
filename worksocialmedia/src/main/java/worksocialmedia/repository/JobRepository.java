package worksocialmedia.repository;

import worksocialmedia.model.Job;

public interface JobRepository extends Repository<Job, Long>{

	public void deleteJobById(Long id);

	public void addJob(Job job);
	
	public void updateJob(Long id, String jobname, Integer jobsalary);
	
	public Job searchJob(String jobSearchName);
	
}

package worksocialmedia.repository;

import worksocialmedia.model.Job;

public interface JobRepository extends Repository<Job, Long>{

	public String deleteById(Long id);

	public String addJob(Job job);
	
	public String updateJob(Long id, String jobname, Integer jobsalary);
	
	public Job searchJob(String jobSearchName);
	
}



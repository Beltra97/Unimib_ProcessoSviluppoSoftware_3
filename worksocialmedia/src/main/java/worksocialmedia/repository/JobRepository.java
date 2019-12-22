package worksocialmedia.repository;

import worksocialmedia.model.Job;

public interface JobRepository extends Repository<Job, Long>{

	public void deleteJobById(Long id);

	public void addJob(Job job);
	
	public void updateJob(Long id, String name, String category, String description);
	
	public Job searchJobName(String jobSearchName);
	
	public Job searchJobDescription(String jobSearchDescription);
	
	public int getSize();
}

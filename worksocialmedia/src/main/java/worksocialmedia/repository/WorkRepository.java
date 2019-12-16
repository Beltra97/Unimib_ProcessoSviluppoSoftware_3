package worksocialmedia.repository;

import worksocialmedia.model.Work;

public interface WorkRepository extends Repository<Work, Long>{

	public void deleteWorkById(Long id);

	public void addWork(Work work);
	
	
}

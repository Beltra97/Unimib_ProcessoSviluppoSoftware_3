package worksocialmedia.repository;

import java.util.Optional;

import worksocialmedia.model.User;
import worksocialmedia.model.Work;

public interface WorkRepository extends Repository<Work, Long>{

	public Optional<User> findUserById(Long id);
	
	public void deleteWorkById(Long id);

	public void addWork(Work work);
	
	
}

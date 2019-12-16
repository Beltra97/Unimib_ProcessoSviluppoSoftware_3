package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.User;
import worksocialmedia.model.Work;

public class WorkRepositoryImpl implements WorkRepository {

  private EntityManagerFactory entityManagerFactory;

  public WorkRepositoryImpl() {
    this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
  }

  @Override
  public Optional<Work> findById(Long id) {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    Work work = entityManager.find(Work.class, id);
    entityManager.close();
    return Optional.ofNullable(work);
  }
  
  public Optional<User> findUserById(Long id) {
	    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	    User user = entityManager.find(User.class, id);
	    entityManager.close();
	    return Optional.ofNullable(user);
  }

  @Override
  public Iterable<Work> findAll() {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    List<Work> works = entityManager.createQuery("FROM Work", Work.class).getResultList();
    entityManager.close();
    return works;
  }
  
  public void deleteWorkById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		Work work = entityManager.find(Work.class, id);
		entityManager.remove(work);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void addWork(Work work) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		entityManager.persist(work);	
		entityManager.getTransaction().commit();
		entityManager.close();
	  }

}
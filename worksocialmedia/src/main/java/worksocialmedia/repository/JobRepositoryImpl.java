package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.Job;

public class JobRepositoryImpl implements JobRepository {

  private EntityManagerFactory entityManagerFactory;

  public JobRepositoryImpl() {
    this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
  }

  @Override
  public Optional<Job> findById(Long id) {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    Job job = entityManager.find(Job.class, id);
    entityManager.close();
    return Optional.ofNullable(job);
  }

  @Override
  public Iterable<Job> findAll() {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    List<Job> jobs = entityManager.createQuery("FROM Job", Job.class).getResultList();
    entityManager.close();
    return jobs;
  }
  
  public void deleteJobById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		Job job = entityManager.find(Job.class, id);
		entityManager.remove(job);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void addJob(Job job) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		entityManager.persist(job);	
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void updateJob(Long id, String name, String category, String description) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		Job job = entityManager.find(Job.class, id);
		job.setName(name);
		job.setCategory(category);
		job.setDescription(description);
		entityManager.persist(job);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public Job searchJob(String jobSearchName) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		  
		Job job = (Job) entityManager.createQuery("FROM Job j WHERE j.name = '" + jobSearchName + "'").getSingleResult();

		entityManager.close();
		  
		return job;
	  }

}
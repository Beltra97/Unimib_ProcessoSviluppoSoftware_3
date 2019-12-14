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
  
  public String deleteById(Long id) {
	    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	    if (!entityManager.getTransaction().isActive()) {
	  		entityManager.getTransaction().begin();
		}
	    Job job = entityManager.find(Job.class, id);
	    entityManager.remove(job);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    
	    return "redirect:jobs";
  }
  
  public String addJob(Job job) {
	  	final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	  	if (!entityManager.getTransaction().isActive()) {
	  		entityManager.getTransaction().begin();
		}
	  	entityManager.persist(job);	
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    
	    return "redirect:jobs";
  }
  
  public String updateJob(Long id, String jobname, Integer jobsalary) {
	    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	    if (!entityManager.getTransaction().isActive()) {
	  		entityManager.getTransaction().begin();
		}
	    Job job = entityManager.find(Job.class, id);
	    job.setJobName(jobname);
	    job.setJobSalary(jobsalary);
	    entityManager.persist(job);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	    
	    return "redirect:http://localhost:8080/jobs";
  }
  
  public Job searchJob(String jobSearchName) {
	  final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
	  
	  Job job = (Job) entityManager.createQuery("FROM Job j WHERE j.jobName = '" + jobSearchName + "'").getSingleResult();

	  entityManager.close();
	  
	  return job;
  }

}
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
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Job job = entityManager.find(Job.class, id);
			entityManager.remove(job);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}

	public void addJob(Job job) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(job);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateJob(Long id, String name, String category, String description) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
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
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public Job searchJobName(String jobSearchName) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Job job = null;
		try {
			job = (Job) entityManager.createQuery("FROM Job j WHERE j.name = '" + jobSearchName + "'")
					.getSingleResult();
			
			entityManager.close();
		} catch (Exception ex) {
			job = null;
		}

		return job;
	}

	public Job searchJobDescription(String jobSearchDescription) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Job job = null;
		try {
			job = (Job) entityManager.createQuery("FROM Job j WHERE j.description = '" + jobSearchDescription + "'")
					.getSingleResult();

			entityManager.close();
		} catch (Exception ex) {
			job = null;
		}
		
		return job;
	}

	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM Job").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}

}
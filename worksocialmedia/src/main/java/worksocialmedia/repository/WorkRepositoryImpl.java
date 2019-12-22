package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.Company;
import worksocialmedia.model.Job;
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

	public Optional<Company> findCompanyById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		Company company = entityManager.find(Company.class, id);
		entityManager.close();
		return Optional.ofNullable(company);
	}

	public Optional<Job> findJobById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		Job job = entityManager.find(Job.class, id);
		entityManager.close();
		return Optional.ofNullable(job);
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
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Work work = entityManager.find(Work.class, id);
			entityManager.remove(work);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void addWork(Work work) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(work);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateWork(Long id, Integer salary, String startDate, String endDate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Work work = entityManager.find(Work.class, id);
			work.setSalary(salary);
			work.setStartDate(startDate);
			work.setEndDate(endDate);
			entityManager.persist(work);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public Work searchWorkSalary(Integer workSearchSalary) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Work work = (Work) entityManager.createQuery("FROM Work w WHERE w.salary = '" + workSearchSalary + "'")
				.getSingleResult();

		entityManager.close();

		return work;
	}
	
	public Work searchWorkStartDate(String workSearchStartDate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Work work = (Work) entityManager.createQuery("FROM Work w WHERE w.start_date = '" + workSearchStartDate + "'")
				.getSingleResult();

		entityManager.close();

		return work;
	}
	
	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM Work").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}

}
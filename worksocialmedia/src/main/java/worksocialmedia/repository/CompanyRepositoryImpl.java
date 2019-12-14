package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.Company;

public class CompanyRepositoryImpl implements CompanyRepository {

  private EntityManagerFactory entityManagerFactory;

  public CompanyRepositoryImpl() {
    this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
  }

  @Override
  public Optional<Company> findById(Long id) {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    Company company = entityManager.find(Company.class, id);
    entityManager.close();
    return Optional.ofNullable(company);
  }

  @Override
  public Iterable<Company> findAll() {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    List<Company> companies = entityManager.createQuery("FROM Company", Company.class).getResultList();
    entityManager.close();
    return companies;
  }
  
  public void deleteCompanyById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		Company company = entityManager.find(Company.class, id);
		entityManager.remove(company);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void addCompany(Company company) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		entityManager.persist(company);	
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void updateCompany(Long id, String name, String CEO, Integer numberEmployees, String foundationYear, String description) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		Company company = entityManager.find(Company.class, id);
		company.setName(name);
		company.setCEO(CEO);
		company.setNumberEmployees(numberEmployees);
		company.setFoundationYear(foundationYear);
		company.setDescription(description);
		entityManager.persist(company);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public Company searchCompany(String CompanySearchName) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		  
		Company company = (Company) entityManager.createQuery("FROM Company c WHERE c.name = '" + CompanySearchName + "'").getSingleResult();

		entityManager.close();
		  
		return company;
	  }

}
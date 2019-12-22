package worksocialmedia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import worksocialmedia.model.AddressCompany;
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

	public Optional<AddressCompany> findCompanyAddressById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		AddressCompany addressCompany = entityManager.find(AddressCompany.class, id);
		entityManager.close();
		return Optional.ofNullable(addressCompany);
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
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Company company = entityManager.find(Company.class, id);
			entityManager.remove(company);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void addCompany(Company company) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(company);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateCompany(Long id, String name, String CEO, Integer numberEmployees, String foundationYear,
			String description) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
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
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public Company searchCompany(String CompanySearchName) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Company company = (Company) entityManager
				.createQuery("FROM Company c WHERE c.name = '" + CompanySearchName + "'").getSingleResult();

		entityManager.close();

		return company;
	}
	
	public Company searchCompanyCEO(String CompanySearchCEO) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Company company = null;
		List<Company> companies = new ArrayList<Company>();
		try {
			companies = entityManager.createQuery("FROM Company c WHERE c.CEO = '" + CompanySearchCEO + "'").getResultList();
			if(companies.size() == 1) 
				company = companies.get(0);
			
			entityManager.close();
		}
		catch(NoResultException ex) {
			company = null;
		}
		return company;
	}
	
	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM Company").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}
}
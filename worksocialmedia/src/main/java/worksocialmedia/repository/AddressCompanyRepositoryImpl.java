package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.AddressCompany;

public class AddressCompanyRepositoryImpl implements AddressCompanyRepository {

	private EntityManagerFactory entityManagerFactory;

	public AddressCompanyRepositoryImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
	}

	@Override
	public Optional<AddressCompany> findById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		AddressCompany addressCompany = entityManager.find(AddressCompany.class, id);
		entityManager.close();
		return Optional.ofNullable(addressCompany);
	}

	@Override
	public Iterable<AddressCompany> findAll() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		List<AddressCompany> addressesCompany = entityManager.createQuery("FROM AddressCompany", AddressCompany.class)
				.getResultList();
		entityManager.close();
		return addressesCompany;
	}

	public void deleteCompanyAddressById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			AddressCompany addressCompany = entityManager.find(AddressCompany.class, id);
			entityManager.remove(addressCompany);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}

	}

	public void addCompanyAddress(AddressCompany addressCompany) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(addressCompany);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateCompanyAddress(Long id, String street, String municipality, String civicNumber, String postalCode,
			String nation) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			AddressCompany addressCompany = entityManager.find(AddressCompany.class, id);
			addressCompany.setStreet(street);
			addressCompany.setMunicipality(municipality);
			addressCompany.setCivicNumber(civicNumber);
			addressCompany.setPostalCode(postalCode);
			addressCompany.setNation(nation);
			entityManager.persist(addressCompany);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public AddressCompany searchCompanyAddress(String jobSearchNameStreet) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		AddressCompany addressCompany = null;
		try {
			addressCompany = (AddressCompany) entityManager
					.createQuery("FROM AddressCompany au WHERE lower(au.street) = '" + jobSearchNameStreet.toLowerCase() + "'")
					.getSingleResult();

			entityManager.close();
		} catch (Exception ex) {
			addressCompany = null;
		}

		return addressCompany;
	}

	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM AddressCompany").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}
}
package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.AddressUser;

public class AddressUserRepositoryImpl implements AddressUserRepository {

  private EntityManagerFactory entityManagerFactory;

  public AddressUserRepositoryImpl() {
    this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
  }

  @Override
  public Optional<AddressUser> findById(Long id) {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    AddressUser addressUser = entityManager.find(AddressUser.class, id);
    entityManager.close();
    return Optional.ofNullable(addressUser);
  }

  @Override
  public Iterable<AddressUser> findAll() {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    List<AddressUser> addressesUser = entityManager.createQuery("FROM AddressUser", AddressUser.class).getResultList();
    entityManager.close();
    return addressesUser;
  }
  
  public void deleteUserAddressById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		AddressUser addressUser = entityManager.find(AddressUser.class, id);
		entityManager.remove(addressUser);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void addUserAddress(AddressUser addressUser) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		entityManager.persist(addressUser);	
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public void updateUserAddress(Long id, String street, String municipality, String civicNumber, String postalCode, String nation) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		if (!entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().begin();
		}
		AddressUser addressUser = entityManager.find(AddressUser.class, id);
		addressUser.setStreet(street);
		addressUser.setMunicipality(municipality);
		addressUser.setCivicNumber(civicNumber);
		addressUser.setPostalCode(postalCode);
		addressUser.setNation(nation);
		entityManager.persist(addressUser);
		entityManager.getTransaction().commit();
		entityManager.close();
	  }
  
  public AddressUser searchUserAddress(String jobSearchNameStreet) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		  
		AddressUser addressUser = (AddressUser) entityManager.createQuery("FROM AddressUser au WHERE au.street = '" + jobSearchNameStreet + "'").getSingleResult();

		entityManager.close();
		  
		return addressUser;
	  }

}
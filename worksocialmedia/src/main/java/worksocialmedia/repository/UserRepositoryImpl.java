package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.AddressUser;
import worksocialmedia.model.User;

public class UserRepositoryImpl implements UserRepository {

	private EntityManagerFactory entityManagerFactory;

	public UserRepositoryImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
	}

	@Override
	public Optional<User> findById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		entityManager.close();
		return Optional.ofNullable(user);
	}

	public Optional<AddressUser> findUserAddressById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		AddressUser addressUser = entityManager.find(AddressUser.class, id);
		entityManager.close();
		return Optional.ofNullable(addressUser);
	}

	@Override
	public Iterable<User> findAll() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
		entityManager.close();
		return users;
	}

	public void deleteUserById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			User user = entityManager.find(User.class, id);
			entityManager.remove(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void addUser(User user) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateUser(Long id, String firstname, String lastname, String gender, String birthdate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			User user = entityManager.find(User.class, id);
			user.setFirstName(firstname);
			user.setLastName(lastname);
			user.setGender(gender);
			user.setBirthDate(birthdate);
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public User searchUser(String userSearchLastName) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		User user = null;
		try {
			user = (User) entityManager.createQuery("FROM User u WHERE u.lastName = '" + userSearchLastName + "'")
					.getSingleResult();

			entityManager.close();
		} catch (Exception ex) {
			user = null;
		}

		return user;
	}

	public User searchUserBirthDate(String userSearchBirthDate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		User user = null;
		try {
			user = (User) entityManager.createQuery("FROM User u WHERE u.birthDate = '" + userSearchBirthDate + "'")
					.getSingleResult();

			entityManager.close();
		} catch (Exception ex) {
			user = null;
		}

		return user;
	}

	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM User").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}
}

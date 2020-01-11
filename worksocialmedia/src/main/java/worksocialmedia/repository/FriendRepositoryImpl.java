package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import worksocialmedia.model.Friend;
import worksocialmedia.model.User;

public class FriendRepositoryImpl implements FriendRepository {

	private EntityManagerFactory entityManagerFactory;

	public FriendRepositoryImpl() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("worksocialmedia");
	}

	@Override
	public Optional<Friend> findById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		Friend friend = entityManager.find(Friend.class, id);
		entityManager.close();
		return Optional.ofNullable(friend);
	}

	public Optional<User> findUserById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		User user = entityManager.find(User.class, id);
		entityManager.close();
		return Optional.ofNullable(user);
	}

	@Override
	public Iterable<Friend> findAll() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		List<Friend> friends = entityManager.createQuery("FROM Friend", Friend.class).getResultList();
		entityManager.close();
		return friends;
	}

	public void deleteFriendById(Long id) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Friend friend = entityManager.find(Friend.class, id);
			entityManager.remove(friend);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}

	}

	public void addFriend(Friend friend) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			entityManager.persist(friend);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public void updateFriend(Long id, String creationDate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		try {
			if (!entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().begin();
			}
			Friend friend = entityManager.find(Friend.class, id);
			friend.setCreationDate(creationDate);
			entityManager.persist(friend);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
		}
	}

	public Friend searchFriend(String friendSearchDate) {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();

		Friend friend = null;
		try {
			friend = (Friend) entityManager
					.createQuery("FROM Friend f WHERE f.creationDate = '" + friendSearchDate + "'").getSingleResult();

			entityManager.close();
		} catch (Exception ex) {
			friend = null;
		}

		return friend;
	}

	public int getSize() {
		final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		int size = 0;
		try {
			size = entityManager.createQuery("FROM Friend").getResultList().size();

			entityManager.close();
		} catch (Exception ex) {
			size = 0;
		}
		return size;
	}
}
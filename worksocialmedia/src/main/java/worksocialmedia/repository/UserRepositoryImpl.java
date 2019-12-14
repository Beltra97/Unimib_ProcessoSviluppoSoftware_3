package worksocialmedia.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

  @Override
  public Iterable<User> findAll() {
    final EntityManager entityManager = this.entityManagerFactory.createEntityManager();
    List<User> users = entityManager.createQuery("FROM User", User.class).getResultList();
    entityManager.close();
    return users;
  }

}

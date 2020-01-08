package worksocialmedia.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.Friend;
import worksocialmedia.model.User;
import worksocialmedia.repository.FriendRepository;
import worksocialmedia.repository.FriendRepositoryImpl;
import worksocialmedia.repository.UserRepository;
import worksocialmedia.repository.UserRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
class FriendTest {

	private UserRepository userRepository = new UserRepositoryImpl();
	private FriendRepository friendRepository = new FriendRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddFriendship() {
		long idUser1 = 2;
		long idUser2 = 3;
		
		Optional<User> user1 = userRepository.findById(idUser1);
		Optional<User> user2 = userRepository.findById(idUser2);
		
		user1.ifPresent(u1 -> {
			user2.ifPresent(u2 -> {
				Friend f = new Friend(u1, u2, "31/12/2019");
				friendRepository.addFriend(f);
			});
		});
		
		int size = userRepository.getSize();
		assertEquals(size, 3);
	}

	@Test
	@Order(2)
	void testUpdateFriendship() {
		long idFriendship = 4;
		String creationDate = "01/01/2020";
		
		friendRepository.updateFriend(idFriendship, creationDate);
		Optional<Friend> friendship = friendRepository.findById(idFriendship);
		friendship.ifPresent(a -> {
			assertEquals(a.getCreationDate(), creationDate);
		});
	}
	
	@Test
	@Order(3)
	void testDeleteFriendship() {
		long idFriendship = 4;
		friendRepository.deleteFriendById(idFriendship);
		
		int size = friendRepository.getSize();
		assertEquals(size, 3);
	}
}

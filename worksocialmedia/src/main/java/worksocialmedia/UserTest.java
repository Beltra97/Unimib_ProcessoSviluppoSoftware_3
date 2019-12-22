package worksocialmedia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.AddressUser;
import worksocialmedia.model.Company;
import worksocialmedia.model.User;
import worksocialmedia.repository.AddressCompanyRepository;
import worksocialmedia.repository.AddressCompanyRepositoryImpl;
import worksocialmedia.repository.AddressUserRepository;
import worksocialmedia.repository.AddressUserRepositoryImpl;
import worksocialmedia.repository.UserRepository;
import worksocialmedia.repository.UserRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
class UserTest {

	private UserRepository userRepository = new UserRepositoryImpl();
	private AddressUserRepository addressUserRepository = new AddressUserRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddUser() {
		
		String firstName = "Paolo";
		String lastName = "Verdi";
		String gender = "M";
		String birthDate = "01/01/1997";
	
		long idAddress = 1;
		Optional<AddressUser> addressUser = addressUserRepository.findById(idAddress);
		addressUser.ifPresent(a -> {
			User user = new User(firstName, lastName, gender, birthDate, a);
			userRepository.addUser(user);
		});
		
		int size = userRepository.getSize();
		assertEquals(size, 4);
	}

	@Test
	@Order(2)
	void testUpdateCompany() {
		long id = 4;
		String firstName = "Paolo";
		String lastName = "Verdi";
		String gender = "M";
		String birthDate = "01/01/1997";
		
		userRepository.updateUser(id, firstName, lastName, gender, birthDate);
		
		Optional<User> user = userRepository.findById(id);
		user.ifPresent(a -> {
			assertEquals(a.getFirstName(), firstName);
			assertEquals(a.getLastName(), lastName);
			assertEquals(a.getGender(), gender);
			assertEquals(a.getBirthDate(), birthDate);
		});
	}
	
	@Test
	@Order(3)
	void testDeleteUser() {
		long ID = 4;
		userRepository.deleteUserById(ID);
		
		int size = userRepository.getSize();
		assertEquals(size, 3);
	}
}

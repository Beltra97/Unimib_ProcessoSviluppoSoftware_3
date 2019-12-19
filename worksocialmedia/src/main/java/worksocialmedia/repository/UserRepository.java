package worksocialmedia.repository;

import java.util.Optional;

import worksocialmedia.model.AddressUser;
import worksocialmedia.model.User;

public interface UserRepository extends Repository<User, Long>{
	
	public Optional<AddressUser> findUserAddressById(Long id);

	public void deleteUserById(Long id);

	public void addUser(User user);
	
	public void updateUser(Long id, String firstname, String lastname, String gender, String birthdate);
	
	public User searchUser(String userSearchLastName);
	
}

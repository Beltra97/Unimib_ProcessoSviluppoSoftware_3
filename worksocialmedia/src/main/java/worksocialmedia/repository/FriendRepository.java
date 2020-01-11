package worksocialmedia.repository;

import java.util.Optional;

import worksocialmedia.model.Friend;
import worksocialmedia.model.User;

public interface FriendRepository extends Repository<Friend, Long>{

	public Optional<User> findUserById(Long id);
	
	public void deleteFriendById(Long id);

	public void addFriend(Friend friend);
	
	public void updateFriend(Long id, String creationDate);
	
	public Friend searchFriend(String friendSearchDate);
	
	public int getSize();
}

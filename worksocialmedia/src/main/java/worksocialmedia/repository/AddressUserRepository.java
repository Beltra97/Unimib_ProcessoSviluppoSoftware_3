package worksocialmedia.repository;

import worksocialmedia.model.AddressUser;

public interface AddressUserRepository extends Repository<AddressUser, Long>{

	public void deleteUserAddressById(Long id);

	public void addUserAddress(AddressUser addressUser);
	
	public void updateUserAddress(Long id, String street, String municipality, String civicNumber, String postalCode, String nation);
	
	public AddressUser searchUserAddress(String jobSearchNameStreet);
	
	public int getSize();
}

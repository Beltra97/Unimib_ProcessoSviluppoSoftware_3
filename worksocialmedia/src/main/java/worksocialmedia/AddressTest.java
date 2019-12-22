package worksocialmedia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.AddressCompany;
import worksocialmedia.model.AddressUser;
import worksocialmedia.repository.AddressCompanyRepository;
import worksocialmedia.repository.AddressCompanyRepositoryImpl;
import worksocialmedia.repository.AddressUserRepository;
import worksocialmedia.repository.AddressUserRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
public class AddressTest {

	private AddressUserRepository addressUserRepository = new AddressUserRepositoryImpl();
	private AddressCompanyRepository addressCompanyRepository = new AddressCompanyRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddAddressCompany() {
		String street = "Via Bicocca";
		String municipality = "Milano";
		String civicNumber = "30";
		String postalCode = "24005";
		String nation = "Italy";
		
		AddressCompany addressCompany = new AddressCompany(street, municipality, civicNumber, postalCode, nation);
		
		addressCompanyRepository.addCompanyAddress(addressCompany);
		
		int size = addressCompanyRepository.getSize();
		assertEquals(size, 3);
	}
	
	@Test
	@Order(2)
	void testAddAddressUser() {
		String street = "Via Bicocca";
		String municipality = "Milano";
		String civicNumber = "30";
		String postalCode = "24005";
		String nation = "Italy";
		
		AddressUser addressUser = new AddressUser(street, municipality, civicNumber, postalCode, nation);
		
		addressUserRepository.addUserAddress(addressUser);
		
		int size = addressUserRepository.getSize();
		assertEquals(size, 4);
	}
	
	@Test
	@Order(3)
	void testUpdateAddressCompany() {
		long id = 3;
		String street = "Via bicocca";
		String municipality = "Milano";
		String civicNumber = "30";
		String postalCode = "23040";
		String nation = "Italia";
		
		addressCompanyRepository.updateCompanyAddress(id, street, municipality, civicNumber, postalCode, nation);
		
		Optional<AddressCompany> addressCompany = addressCompanyRepository.findById(id);
		addressCompany.ifPresent(a -> {
			assertEquals(a.getStreet(), street);
			assertEquals(a.getMunicipality(), municipality);
			assertEquals(a.getCivicNumber(), civicNumber);
			assertEquals(a.getPostalCode(), postalCode);
			assertEquals(a.getNation(), nation);
		});
	}
	
	@Test
	@Order(4)
	void testUpdateAddressUser() {
		long id = 4;
		String street = "Via bicocca";
		String municipality = "Milano";
		String civicNumber = "30";
		String postalCode = "23040";
		String nation = "Italia";
		
		addressUserRepository.updateUserAddress(id, street, municipality, civicNumber, postalCode, nation);
		
		Optional<AddressUser> addressUser = addressUserRepository.findById(id);
		addressUser.ifPresent(a -> {
			assertEquals(a.getStreet(), street);
			assertEquals(a.getMunicipality(), municipality);
			assertEquals(a.getCivicNumber(), civicNumber);
			assertEquals(a.getPostalCode(), postalCode);
			assertEquals(a.getNation(), nation);
		});
	}

	@Test
	@Order(5)
	void testDeleteAddressCompany() {
		long ID = 3;
		addressCompanyRepository.deleteCompanyAddressById(ID);
		
		int size = addressCompanyRepository.getSize();
		assertEquals(size, 2);
	}
	
	@Test
	@Order(6)
	void testDeleteAddressUser() {
		long ID = 4;
		addressUserRepository.deleteUserAddressById(ID);

		int size = addressUserRepository.getSize();
		assertEquals(size, 3);
	}
}

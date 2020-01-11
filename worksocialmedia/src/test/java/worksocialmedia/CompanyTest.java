package worksocialmedia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import worksocialmedia.model.AddressCompany;
import worksocialmedia.model.Company;
import worksocialmedia.repository.AddressCompanyRepository;
import worksocialmedia.repository.AddressCompanyRepositoryImpl;
import worksocialmedia.repository.CompanyRepository;
import worksocialmedia.repository.CompanyRepositoryImpl;

@TestMethodOrder(OrderAnnotation.class)
public class CompanyTest {

	private CompanyRepository companyRepository = new CompanyRepositoryImpl();
	private AddressCompanyRepository addressCompanyRepository = new AddressCompanyRepositoryImpl();
	
	@Test
	@Order(1)
	void testAddCompany() {
		long id = 1;
		String name = "Prova";
		String CEO = "CEO1";
		Integer numberEmployees = 200;
		String foundationYear = "2018";
		String description = "Lorem ipsum";
		Optional<AddressCompany> addressCompany = addressCompanyRepository.findById(id);
		addressCompany.ifPresent(a -> {
			Company company = new Company(name, CEO, numberEmployees, foundationYear, description, a);
			companyRepository.addCompany(company);
		});
		
		int size = companyRepository.getSize();
		assertEquals(size, 3);
	}
	
	@Test
	@Order(2)
	void testUpdateCompany() {
		long id = 4;
		String name = "Prova";
		String CEO = "CEO1";
		Integer numberEmployees = 200;
		String foundationYear = "2018";
		String description = "Lorem ipsum";
		
		companyRepository.updateCompany(id, name, CEO, numberEmployees, foundationYear, description);
		
		Optional<Company> company = companyRepository.findById(id);
		company.ifPresent(a -> {
			assertEquals(a.getName(), name);
			assertEquals(a.getCEO(), CEO);
			assertEquals(a.getNumberEmployees(), numberEmployees);
			assertEquals(a.getFoundationYear(), foundationYear);
			assertEquals(a.getDescription(), description);
		});
	}
	
	@Test
	@Order(3)
	void testDeleteCompany() {
		long ID = 4;
		companyRepository.deleteCompanyById(ID);
		
		int size = companyRepository.getSize();
		assertEquals(size, 3);
	}
}

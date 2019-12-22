package worksocialmedia.repository;

import java.util.Optional;

import worksocialmedia.model.AddressCompany;
import worksocialmedia.model.Company;

public interface CompanyRepository extends Repository<Company, Long>{
	
	public Optional<AddressCompany> findCompanyAddressById(Long id);

	public void deleteCompanyById(Long id);

	public void addCompany(Company company);
	
	public void updateCompany(Long id, String name, String CEO, Integer numberEmployees, String foundationYear, String description);
	
	public Company searchCompany(String jobSearchName);
	
	public Company searchCompanyCEO(String jobSearchCEO);
	
	public int getSize();
}

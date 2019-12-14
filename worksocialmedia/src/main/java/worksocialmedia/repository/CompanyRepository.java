package worksocialmedia.repository;

import worksocialmedia.model.Company;

public interface CompanyRepository extends Repository<Company, Long>{

	public void deleteCompanyById(Long id);

	public void addCompany(Company company);
	
	public void updateCompany(Long id, String name, String CEO, Integer numberEmployees, String foundationYear, String description);
	
	public Company searchCompany(String jobSearchName);
	
}

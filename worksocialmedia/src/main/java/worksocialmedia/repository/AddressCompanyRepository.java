package worksocialmedia.repository;

import worksocialmedia.model.AddressCompany;

public interface AddressCompanyRepository extends Repository<AddressCompany, Long>{

	public void deleteCompanyAddressById(Long id);

	public void addCompanyAddress(AddressCompany addressCompany);
	
	public void updateCompanyAddress(Long id, String street, String municipality, String civicNumber, String postalCode, String nation);
	
	public AddressCompany searchCompanyAddress(String jobSearchNameStreet);
	
	public int getSize();
	
}

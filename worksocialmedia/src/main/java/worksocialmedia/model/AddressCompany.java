package worksocialmedia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address_company")
public class AddressCompany extends Address {

  private static final long serialVersionUID = -5124436115031696628L;
  
  protected AddressCompany() {
  }
  
  public AddressCompany(String street, String municipality, String civicNumber, String postalCode, String nation) {
	 super(street, municipality, civicNumber, postalCode, nation);
  }
  
}

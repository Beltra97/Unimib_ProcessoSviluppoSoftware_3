package worksocialmedia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AddressUser extends Address {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @OneToMany(mappedBy = "residentialAddress", cascade = CascadeType.ALL) 
  private List<User> users;
  
  protected AddressUser() {
  }
  
  public AddressUser(String street, String municipality, String civicNumber, String postalCode, String nation) {
	 super(street, municipality, civicNumber, postalCode, nation);
  }
  
}

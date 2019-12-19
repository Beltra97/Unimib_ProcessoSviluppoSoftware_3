package worksocialmedia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

@Inheritance
@Entity
@Table(name = "address")
public class Address implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "street", nullable = false)
  private String street;
  @Column(name = "municipality", nullable = true)
  private String municipality;
  @Column(name = "civic_number", nullable = true)
  private String civicNumber;
  @Column(name = "postal_code", nullable = true)
  private String postalCode;
  @Column(name = "nation", nullable = true)
  private String nation;
   
  protected Address() {
  }

  public Address(String street, String municipality, String civicNumber, String postalCode, String nation) {
    this.street = street;
    this.municipality = municipality;
    this.civicNumber = civicNumber;
    this.postalCode = postalCode;
    this.nation = nation;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, street='%s', municipality='%s', civicNumber='%s', postalCode='%s', nation='%s']", id, street, municipality, civicNumber, postalCode, nation);
  }

  public Long getId() {
    return id;
  }

  public String getStreet() {
    return street;
  }

  public String getMunicipality() {
    return municipality;
  }

  public String getCivicNumber() {
	return civicNumber;
  }

  public String getPostalCode() {
	return postalCode;
  }
  
  public String getNation() {
	return nation;
  }
  
  public void setStreet(String street){
	    this.street = street;
  }
  
  public void setMunicipality(String municipality){
	    this.municipality = municipality;
  }
  
  public void setCivicNumber(String civicNumber){
	    this.civicNumber = civicNumber;
  }
  
  public void setPostalCode(String postalCode){
	    this.postalCode = postalCode;
  }
  
  public void setNation(String nation){
	    this.nation = nation;
  }

}

package worksocialmedia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "first_name", nullable = false)
  private String firstName;
  @Column(name = "last_name", nullable = true)
  private String lastName;
  @Column(name = "gender", nullable = true)
  private String gender;
  @Column(name = "birth_date", nullable = true)
  private String birthDate;
  
  
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) 
  private List<Work> works;
  
  @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL) 
  private List<Friend> Friends1;
  
  @OneToMany(mappedBy = "user2", cascade = CascadeType.ALL) 
  private List<Friend> Friends2;
  
  @ManyToOne
  @JoinColumn(name="residential_address") 
  private AddressUser residentialAddress;
	 
  
  protected User() {
  }

  public User(String firstName, String lastName, String gender, String birthDate, AddressUser residentialAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.birthDate = birthDate;
    this.residentialAddress = residentialAddress;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, firstName='%s', lastName='%s', gender='%s', birthDate='%s', residentialAddress=%d]", id, firstName, lastName, gender, birthDate, residentialAddress);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGender() {
	    return gender;
  }

  public String getBirthDate() {
	    return birthDate;
  }
  
  public AddressUser getResidentialAddress() {
	    return residentialAddress;
  }
  
  public void setFirstName(String firstName){
	    this.firstName = firstName;
  }
  
  public void setLastName(String lastName){
	    this.lastName = lastName;
  }
  
  public void setGender(String gender){
	    this.gender = gender;
  }
  
  public void setBirthDate(String birthDate){
	    this.birthDate = birthDate;
  }
  
  public void setResidentialAddress(AddressUser residentialAddress){
	    this.residentialAddress = residentialAddress;
  }

}

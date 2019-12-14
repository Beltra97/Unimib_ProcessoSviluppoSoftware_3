package worksocialmedia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="job_id") private Job job;
	 */
  
  protected User() {
  }

  public User(String firstName, String lastName, String gender, String birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, firstName='%s', lastName='%s', gender='%s', birthDate='%s']", id, firstName, lastName, gender, birthDate);
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

}

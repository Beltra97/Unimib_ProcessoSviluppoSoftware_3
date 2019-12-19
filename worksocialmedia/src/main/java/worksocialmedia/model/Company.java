package worksocialmedia.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "CEO", nullable = true)
  private String CEO;
  @Column(name = "number_employees", nullable = true)
  private Integer numberEmployees;
  @Column(name = "foundation_year", nullable = true)
  private String foundationYear;
  @Column(name = "description", nullable = true)
  private String description;
  
  @OneToMany(mappedBy = "company", cascade = CascadeType.ALL) 
  private List<Work> works;
  
  protected Company() {
  }

  public Company(String name, String CEO, Integer numberEmployees, String foundationYear, String description) {
    this.name = name;
    this.CEO = CEO;
    this.numberEmployees = numberEmployees;
    this.foundationYear = foundationYear;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("User[id=%d, name='%s', CEO='%s', numberEmployees='%d', foundationYear='%s', description='%s']", id, name, CEO, numberEmployees, foundationYear, description);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCEO() {
    return CEO;
  }

  public Integer getNumberEmployees() {
	    return numberEmployees;
  }

  public String getFoundationYear() {
	    return foundationYear;
  }
  
  public String getDescription() {
	    return description;
}
  
  public void setName(String name){
	    this.name = name;
  }
  
  public void setCEO(String CEO){
	    this.CEO = CEO;
  }
  
  public void setNumberEmployees(Integer numberEmployees){
	    this.numberEmployees = numberEmployees;
  }
  
  public void setFoundationYear(String foundationYear){
	    this.foundationYear = foundationYear;
  }
  
  public void setDescription(String description){
	    this.description = description;
  }

}

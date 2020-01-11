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
@Table(name = "job")
public class Job implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "category", nullable = false)
  private String category;
  @Column(name = "description", nullable = false)
  private String description;
  
  
  @OneToMany(mappedBy = "job", cascade = CascadeType.ALL) 
  private List<Work> works;
  
  
  protected Job() {
  }

  public Job(String name, String category, String description) {
    this.name = name;
    this.category = category;
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("Job[id=%d, name='%s', category='%s', description='%s']", id, name, category, description);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public String getCategory() {
	    return category;
  }
  
  public String getDescription() {
	    return description;
  }
  
  public void setName(String name){
	    this.name = name;
  }
  
  public void setCategory(String category){
	    this.category = category;
  }
  
  public void setDescription(String description){
	    this.description = description;
  }

}

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
@Table(name = "friend")
public class Friend implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "creation_date", nullable = false)
  private String creationDate;
  
  
  @ManyToOne
  @JoinColumn(name="user1") 
  private User user1;

  @ManyToOne
  @JoinColumn(name="user2") 
  private User user2;

  
  protected Friend() {
  }

  public Friend(User user1, User user2, String creationDate) {
    this.user1 = user1;
    this.user2 = user2;
    this.creationDate = creationDate;
  }

  @Override
  public String toString() {
    return String.format("Job[id=%d, user1='%d', user2='%d', creationDate='%s']", id, user1, user2, creationDate);
  }

  public Long getId() {
    return id;
  }

  public User getUser1() {
    return user1;
  }
  
  public User getUser2() {
	    return user2;
  }
  
  public String getCreationDate() {
	    return creationDate;
  }
  
  public void setUser1(User user1){
	    this.user1 = user1;
  }
  
  public void setUser2(User user2){
	    this.user2 = user2;
  }
  
  public void setCreationDate(String creationDate){
	    this.creationDate = creationDate;
  }

}

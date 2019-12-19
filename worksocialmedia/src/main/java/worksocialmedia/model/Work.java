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
@Table(name = "work")
public class Work implements Serializable {

  private static final long serialVersionUID = -5124436115031696628L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;
  @Column(name = "salary", nullable = false)
  private Integer salary;
  @Column(name = "start_date", nullable = false)
  private String startDate;
  @Column(name = "end_date", nullable = false)
  private String endDate;
  
  
  @ManyToOne
  @JoinColumn(name="user") 
  private User user;
  
  @ManyToOne
  @JoinColumn(name="company") 
  private Company company;
  
  @ManyToOne
  @JoinColumn(name="job") 
  private Job job;

  
  protected Work() {
  }

  public Work(User user, Company company, Job job, Integer salary, String startDate, String endDate) {
    this.user = user;
    this.company = company;
    this.job = job;
    this.salary = salary;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return String.format("Job[id=%d, user='%d', company='%d', job='%d', salary='%d', startDate='%s', endDate='%s']", id, user, company, job, salary, startDate, endDate);
  }

  public Long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }
  
  public Company getCompany() {
	    return company;
	  }
  
  public Job getJob() {
	    return job;
  }
  
  public Integer getSalary() {
	    return salary;
  }
  
  public String getStartDate() {
	    return startDate;
  }
  
  public String getEndDate() {
	    return endDate;
  }
  
  public void setUser(User user){
	    this.user = user;
  }
  
  public void setCompany(Company company){
	    this.company = company;
  }
  
  public void setJob(Job job){
	    this.job = job;
  }

  public void setSalary(Integer salary){
	    this.salary = salary;
  }
  
  public void setStartDate(String startDate){
	    this.startDate = startDate;
  }
  
  public void setEndDate(String endDate){
	    this.endDate = endDate;
  }

}

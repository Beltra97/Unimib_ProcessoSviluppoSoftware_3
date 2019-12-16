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
	/*
	 * @Column(name = "user", nullable = false) private Integer user;
	 */
  @Column(name = "company", nullable = false)
  private Integer company;
  @Column(name = "job_type", nullable = false)
  private Integer jobType;
  @Column(name = "salary", nullable = false)
  private Integer salary;
  @Column(name = "start_date", nullable = false)
  private String startDate;
  @Column(name = "end_date", nullable = false)
  private String endDate;
  
  
  @ManyToOne
  @JoinColumn(name="user") 
  private User user;
  
  
  protected Work() {
  }

  public Work(User user, Integer company, Integer jobType, Integer salary, String startDate, String endDate) {
    this.user = user;
    this.company = company;
    this.jobType = jobType;
    this.salary = salary;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return String.format("Job[id=%d, user='%d', company='%d', jobType='%d', salary='%d', startDate='%s', endDate='%s']", id, user, company, jobType, salary, startDate, endDate);
  }

  public Long getId() {
    return id;
  }

  public User getUser() {
    return user;
  }
  
  public Integer getCompany() {
	    return company;
	  }
  
  public Integer getJobType() {
	    return jobType;
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
  
  public void setCompany(Integer company){
	    this.company = company;
  }
  
  public void setJobType(Integer jobType){
	    this.jobType = jobType;
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

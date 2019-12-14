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
  @Column(name = "job_name", nullable = false)
  private String jobName;
  @Column(name = "job_salary", nullable = false)
  private Integer jobSalary;
  
  @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
  private List<User> users;
  
  protected Job() {
  }

  public Job(String jobName, Integer jobSalary) {
    this.jobName = jobName;
    this.jobSalary = jobSalary;
  }

  @Override
  public String toString() {
    return String.format("Job[id=%d, jobName='%s', jobSalary='%d']", id, jobName, jobSalary);
  }

  public Long getId() {
    return id;
  }

  public String getJobName() {
    return jobName;
  }
  
  public Integer getJobSalary() {
	    return jobSalary;
  }
  
  public void setJobName(String jobname){
	    this.jobName = jobname;
  }
  
  public void setJobSalary(Integer jobsalary){
	    this.jobSalary = jobsalary;
}

}

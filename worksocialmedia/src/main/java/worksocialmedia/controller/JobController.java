package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.JobNotFoundException;
import worksocialmedia.model.Job;
import worksocialmedia.repository.JobRepository;
import worksocialmedia.repository.JobRepositoryImpl;

@Controller
public class JobController {
  private JobRepository jobRepository;

  public JobController() {
    this.jobRepository = new JobRepositoryImpl();
  }

  @GetMapping("jobs")
  public ModelAndView jobs() {
    ModelAndView modelAndView = new ModelAndView();

    Iterable<Job> jobs = jobRepository.findAll();

    modelAndView.addObject("jobs", jobs);
    modelAndView.setViewName("jobs");

    return modelAndView;
  }

	
  @GetMapping("jobs/{id}") 
  public ModelAndView job(@PathVariable("id") Long id) { 
	  ModelAndView modelAndView = new ModelAndView();
	  
	  Optional<Job> job = jobRepository.findById(id);
	  job.orElseThrow(JobNotFoundException::new);
	  
	  modelAndView.addObject("job", job.get()); 
	  modelAndView.setViewName("job");
	  
	  return modelAndView; 
  }
	  
  
  @GetMapping("deletejob{id}")
  public String jobDelete(@PathVariable("id") Long id) {
	  
    jobRepository.deleteById(id);
    
    return "redirect:jobs";
  }
  
  
  @PostMapping("addjob")
  public String jobAdd(@RequestParam(value="addName") String name, @RequestParam(value="addSalary") Integer salary) {

	Job job = new Job(name, salary);
	  
	jobRepository.addJob(job);
	
	return "redirect:jobs";
  }
  
  
  @PostMapping("jobs/updatejob{id}")
  public String jobUpdate(@PathVariable("id") Long id, @RequestParam(value="updateName") String name, @RequestParam(value="updateSalary") Integer salary) {

	jobRepository.updateJob(id, name, salary);
	
	return "redirect:http://localhost:8080/jobs";
  }
  
  @PostMapping("searchJob")
  public ModelAndView jobSearch(@RequestParam("jobSearchName") String jobSearchName) {
	
	ModelAndView modelAndView = new ModelAndView();
	  
	Job job = jobRepository.searchJob(jobSearchName);
	  
	modelAndView.addObject("job", job); 
	modelAndView.setViewName("job");
	  
	return modelAndView; 
  }

  
}

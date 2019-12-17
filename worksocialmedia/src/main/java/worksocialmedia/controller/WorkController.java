package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.WorkNotFoundException;
import worksocialmedia.model.Company;
import worksocialmedia.model.Job;
import worksocialmedia.model.User;
import worksocialmedia.model.Work;
import worksocialmedia.repository.WorkRepository;
import worksocialmedia.repository.WorkRepositoryImpl;

@Controller
public class WorkController {
  private WorkRepository workRepository;

  public WorkController() {
    this.workRepository = new WorkRepositoryImpl();
  }

  @GetMapping("/works")
  public ModelAndView companies() {
    ModelAndView modelAndView = new ModelAndView();

    Iterable<Work> work = workRepository.findAll();

    modelAndView.addObject("works", work);
    modelAndView.setViewName("works");

    return modelAndView;
  }

  @GetMapping("/works/{id}")
  public ModelAndView user(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView();

    Optional<Work> work = workRepository.findById(id);
    work.orElseThrow(WorkNotFoundException::new);

    modelAndView.addObject("work", work.get());
    modelAndView.setViewName("work");

    return modelAndView;
  }
  
  @GetMapping("deletework{id}")
  public String workDelete(@PathVariable("id") Long id) {
	  
    workRepository.deleteWorkById(id);
    
    return "redirect:http://localhost:8080/works";
    
  }
  
  @PostMapping("addwork")
  public String workAdd(@RequestParam(value="addUser") Long userId, @RequestParam(value="addCompany") Long companyId, @RequestParam(value="addJobType") Long jobId, @RequestParam(value="addSalary") Integer salary, @RequestParam(value="addStartDate") String startDate, @RequestParam(value="addEndDate") String endDate) {
	  
	Optional<User> user = workRepository.findUserById(userId);
	Optional<Company> company = workRepository.findCompanyById(companyId);
	Optional<Job> jobType = workRepository.findJobById(jobId);
	Work work = new Work(user.get(), company.get(), jobType.get(), salary, startDate, endDate);
	  
	workRepository.addWork(work);
	
	return "redirect:works";
  }
  
  @PostMapping("works/updatework{id}")
  public String userUpdate(@PathVariable("id") Long id, @RequestParam(value="updateSalary") Integer salary, @RequestParam(value="updateStartDate") String startDate, @RequestParam(value="updateEndDate") String endDate) {

	workRepository.updateWork(id, salary, startDate, endDate);
	
	return "redirect:http://localhost:8080/works";
  }
  
  @PostMapping("searchwork")
  public ModelAndView companySearch(@RequestParam("workSearchSalary") Integer workSearchSalary) {
	
	ModelAndView modelAndView = new ModelAndView();
	  
	Work work = workRepository.searchWork(workSearchSalary);
	  
	modelAndView.addObject("work", work); 
	modelAndView.setViewName("work");
	  
	return modelAndView; 
  }
  
}

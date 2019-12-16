package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.WorkNotFoundException;
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
  public String workAdd(@RequestParam(value="addUser") User user, @RequestParam(value="addCompany") Integer company, @RequestParam(value="addJobType") Integer jobType, @RequestParam(value="addSalary") Integer salary, @RequestParam(value="addStartDate") String startDate, @RequestParam(value="addEndDate") String endDate) {
	  
	Work work = new Work(user, company, jobType, salary, startDate, endDate);
	  
	workRepository.addWork(work);
	
	return "redirect:works";
  }
  
}

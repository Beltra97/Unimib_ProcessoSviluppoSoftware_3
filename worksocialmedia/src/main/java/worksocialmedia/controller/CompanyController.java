package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.CompanyNotFoundException;
import worksocialmedia.model.AddressCompany;
import worksocialmedia.model.Company;
import worksocialmedia.repository.CompanyRepository;
import worksocialmedia.repository.CompanyRepositoryImpl;

@Controller
public class CompanyController {
  private CompanyRepository companyRepository;

  public CompanyController() {
    this.companyRepository = new CompanyRepositoryImpl();
  }

  @GetMapping("/companies")
  public ModelAndView companies() {
    ModelAndView modelAndView = new ModelAndView();

    Iterable<Company> company = companyRepository.findAll();

    modelAndView.addObject("companies", company);
    modelAndView.setViewName("companies");

    return modelAndView;
  }

  @GetMapping("/companies/{id}")
  public ModelAndView user(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView();

    Optional<Company> company = companyRepository.findById(id);
    company.orElseThrow(CompanyNotFoundException::new);

    modelAndView.addObject("company", company.get());
    modelAndView.setViewName("company");

    return modelAndView;
  }
  
  @GetMapping("deletecompany{id}")
  public String companyDelete(@PathVariable("id") Long id) {
	  
    companyRepository.deleteCompanyById(id);
    
    return "redirect:http://localhost:8080/companies";
    
  }
  
  @PostMapping("addcompany")
  public String companyAdd(@RequestParam(value="addName") String name, @RequestParam(value="addCEO") String CEO, @RequestParam(value="addNumberEmployees") Integer numberEmployees, @RequestParam(value="addFoundationYear") String foundationYear, @RequestParam(value="addDescription") String description, @RequestParam(value="addLegalAddressId") Long companyAddressId) {

	Optional<AddressCompany> addressCompany = companyRepository.findCompanyAddressById(companyAddressId);
	Company company = new Company(name, CEO, numberEmployees, foundationYear, description, addressCompany.get());
	  
	companyRepository.addCompany(company);
	
	return "redirect:companies";
  }
  
  @PostMapping("companies/updatecompany{id}")
  public String userUpdate(@PathVariable("id") Long id, @RequestParam(value="updateName") String name, @RequestParam(value="updateCEO") String CEO, @RequestParam(value="updateNumberEmployees") Integer numberEmployees, @RequestParam(value="updateFoundationYear") String foundationYear, @RequestParam(value="updateDescription") String description) {

	companyRepository.updateCompany(id, name, CEO, numberEmployees, foundationYear, description);
	
	return "redirect:http://localhost:8080/companies";
  }
  
  @PostMapping("searchcompany")
  public ModelAndView companySearch(@RequestParam("companySearchName") String companySearchName) {
	
	ModelAndView modelAndView = new ModelAndView();
	  
	Company company = companyRepository.searchCompany(companySearchName);
	  
	modelAndView.addObject("company", company); 
	modelAndView.setViewName("company");
	  
	return modelAndView; 
  }
  
}

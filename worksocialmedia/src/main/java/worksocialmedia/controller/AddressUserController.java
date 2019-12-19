package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.AddressUserNotFoundException;
import worksocialmedia.model.Address;
import worksocialmedia.model.AddressUser;
import worksocialmedia.repository.AddressUserRepository;
import worksocialmedia.repository.AddressUserRepositoryImpl;

@Controller
public class AddressUserController {
  private AddressUserRepository addressUserRepository;

  public AddressUserController() {
    this.addressUserRepository = new AddressUserRepositoryImpl();
  }

  @GetMapping("/uaddresses")
  public ModelAndView companies() {
    ModelAndView modelAndView = new ModelAndView();

    Iterable<AddressUser> addressesUser = addressUserRepository.findAll();

    modelAndView.addObject("uaddresses", addressesUser);
    modelAndView.setViewName("uaddresses");

    return modelAndView;
  }

  @GetMapping("/uaddresses/{id}")
  public ModelAndView user(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView();

    Optional<AddressUser> addressUser = addressUserRepository.findById(id);
    addressUser.orElseThrow(AddressUserNotFoundException::new);

    modelAndView.addObject("uaddress", addressUser.get());
    modelAndView.setViewName("uaddress");

    return modelAndView;
  }
  
  @GetMapping("deleteuaddress{id}")
  public String userAddressDelete(@PathVariable("id") Long id) {
	  
    addressUserRepository.deleteUserAddressById(id);
    
    return "redirect:http://localhost:8080/uaddresses";
    
  }
  
  @PostMapping("adduaddress")
  public String userAddressAdd(@RequestParam(value="addStreet") String street, @RequestParam(value="addMunicipality") String municipality, @RequestParam(value="addCivicNumber") String civicNumber, @RequestParam(value="addPostalCode") String postalCode, @RequestParam(value="addNation") String nation) {

	AddressUser addressUser = new AddressUser(street, municipality, civicNumber, postalCode, nation);
	  
	addressUserRepository.addUserAddress(addressUser);
	
	return "redirect:uaddresses";
  }
  
  @PostMapping("uaddresses/updateuaddress{id}")
  public String userUpdate(@PathVariable("id") Long id, @RequestParam(value="updateStreet") String street, @RequestParam(value="updateMunicipality") String municipality, @RequestParam(value="updateCivicNumber") String civicNumber, @RequestParam(value="updatePostalCode") String postalCode, @RequestParam(value="updateNation") String nation) {

	addressUserRepository.updateUserAddress(id, street, municipality, civicNumber, postalCode, nation);
	
	return "redirect:http://localhost:8080/uaddresses";
  }
  
  @PostMapping("searchuaddress")
  public ModelAndView userAddressSearch(@RequestParam("jobSearchNameStreet") String jobSearchNameStreet) {
	
	ModelAndView modelAndView = new ModelAndView();
	  
	AddressUser addressUser = addressUserRepository.searchUserAddress(jobSearchNameStreet);
	  
	modelAndView.addObject("uaddress", addressUser); 
	modelAndView.setViewName("uaddress");
	  
	return modelAndView; 
  }
  
}

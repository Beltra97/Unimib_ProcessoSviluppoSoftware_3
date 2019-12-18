package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.UserNotFoundException;
import worksocialmedia.model.User;
import worksocialmedia.repository.UserRepository;
import worksocialmedia.repository.UserRepositoryImpl;

@Controller
public class UserController {
  private UserRepository userRepository;

  public UserController() {
    this.userRepository = new UserRepositoryImpl();
  }

  @GetMapping("/users")
  public ModelAndView users() {
    ModelAndView modelAndView = new ModelAndView();

    Iterable<User> users = userRepository.findAll();

    modelAndView.addObject("users", users);
    modelAndView.setViewName("users");

    return modelAndView;
  }

  @GetMapping("/users/{id}")
  public ModelAndView user(@PathVariable("id") Long id) {
    ModelAndView modelAndView = new ModelAndView();

    Optional<User> user = userRepository.findById(id);
    user.orElseThrow(UserNotFoundException::new);

    modelAndView.addObject("user", user.get());
    modelAndView.setViewName("user");

    return modelAndView;
  }
  
  @GetMapping("deleteuser/{id}")
  public String userDelete(@PathVariable("id") Long id) {
	  
    userRepository.deleteUserById(id);
    
    return "redirect:http://localhost:8080/users";
    
  }
  
  @PostMapping("adduser")
  public String userAdd(@RequestParam(value="addFirstName") String firstName, @RequestParam(value="addLastName") String lastName, @RequestParam(value="addGender") String gender, @RequestParam(value="addBirthDate") String birthDate) {

	User user = new User(firstName, lastName, gender, birthDate);
	  
	userRepository.addUser(user);
	
	return "redirect:users";
  }
  
  @PostMapping("users/updateuser{id}")
  public String userUpdate(@PathVariable("id") Long id, @RequestParam(value="updateFirstName") String firstName, @RequestParam(value="updateLastName") String lastName, @RequestParam(value="updateGender") String gender, @RequestParam(value="updateBirthDate") String birthDate) {

	userRepository.updateUser(id, firstName, lastName, gender, birthDate);
	
	return "redirect:http://localhost:8080/users";
  }
  
  @PostMapping("searchuser")
  public ModelAndView jobSearch(@RequestParam("userSearchLastName") String userSearchLastName) {
	
	ModelAndView modelAndView = new ModelAndView();
	  
	User user = userRepository.searchUser(userSearchLastName);
	  
	modelAndView.addObject("user", user); 
	modelAndView.setViewName("user");
	  
	return modelAndView; 
  }
  
}

package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}

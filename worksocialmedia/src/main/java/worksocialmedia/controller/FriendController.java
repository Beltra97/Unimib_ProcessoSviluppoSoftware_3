package worksocialmedia.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import worksocialmedia.exception.FriendNotFoundException;
import worksocialmedia.model.Friend;
import worksocialmedia.model.User;
import worksocialmedia.repository.FriendRepository;
import worksocialmedia.repository.FriendRepositoryImpl;
import worksocialmedia.repository.UserRepository;
import worksocialmedia.repository.UserRepositoryImpl;

@Controller
public class FriendController {
	private FriendRepository friendRepository;
	private UserRepository userRepository;

	public FriendController() {
		this.friendRepository = new FriendRepositoryImpl();
		this.userRepository = new UserRepositoryImpl();
	}

	@GetMapping("/friends")
	public ModelAndView friends() {
		ModelAndView modelAndView = new ModelAndView();

		Iterable<User> users = userRepository.findAll();

		modelAndView.addObject("users", users);
		modelAndView.setViewName("users");

		Iterable<Friend> friend = friendRepository.findAll();

		modelAndView.addObject("friends", friend);
		modelAndView.setViewName("friends");

		return modelAndView;
	}

	@GetMapping("/friends/{id}")
	public ModelAndView friend(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView();

		Optional<Friend> friend = friendRepository.findById(id);
		friend.orElseThrow(FriendNotFoundException::new);

		modelAndView.addObject("friend", friend.get());
		modelAndView.setViewName("friend");

		return modelAndView;
	}

	@GetMapping("deletefriend{id}")
	public String friendDelete(@PathVariable("id") Long id) {

		friendRepository.deleteFriendById(id);

		return "redirect:http://localhost:8080/friends";

	}

	@PostMapping("addfriend")
	public String friendAdd(@RequestParam(value = "addUser1") Long user1Id,
			@RequestParam(value = "addUser2") Long user2Id,
			@RequestParam(value = "addCreationDate") String creationDate) {

		Optional<User> user1 = friendRepository.findUserById(user1Id);
		Optional<User> user2 = friendRepository.findUserById(user2Id);
		Friend friend = new Friend(user1.get(), user2.get(), creationDate);
		friendRepository.addFriend(friend);

		return "redirect:friends";
	}

	@PostMapping("friends/updatefriend{id}")
	public String friendUpdate(@PathVariable("id") Long id,
			@RequestParam(value = "updateCreationDate") String creationDate) {

		friendRepository.updateFriend(id, creationDate);

		return "redirect:http://localhost:8080/friends";
	}

	@PostMapping("searchfriend")
	public ModelAndView friendSearch(@RequestParam("friendSearchDate") String friendSearchDate) {

		ModelAndView modelAndView = new ModelAndView();

		Friend friend = friendRepository.searchFriend(friendSearchDate);

		if (friend == null) {
			throw new FriendNotFoundException();
		}

		modelAndView.addObject("friend", friend);
		modelAndView.setViewName("friend");

		return modelAndView;
	}

}

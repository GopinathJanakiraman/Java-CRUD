package com.example.democrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

@RequestMapping({"/users"})
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping(path = {"/{id}"})
	public User findOne(@PathVariable("id") int id) {
		return userService.findById(id);
	}
	@PutMapping(path = {"/{id}"})
	public User update(@PathVariable("id") int id, @RequestBody User user) {
		user.setId(id);
		return userService.update(user);
	}
	@DeleteMapping(path = {"/{id}"})
	public User delete(@PathVariable("id") int id) {
		return userService.delete(id);
	}
	@GetMapping
	public List<UserDTO> findAll(){
		return userService.findAll();
	}
}

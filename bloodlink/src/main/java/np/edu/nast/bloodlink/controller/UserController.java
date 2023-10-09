package np.edu.nast.bloodlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import np.edu.nast.bloodlink.entity.User;
import np.edu.nast.bloodlink.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserRepository userRepo;
		//find all
		@GetMapping
		public List<User> allRole(){
			return userRepo.findAll();

		}



	//create
	@PostMapping
	public User createRole(@RequestBody User user) {
		return userRepo.save(user);

	}

	// read
	@GetMapping("/{id}")
	public User findUser(@PathVariable("id") Long id) {
		return userRepo.findById(id).get();
	}


	// delete
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id")Long id) {
		User oldUser= userRepo.findById(id).get();
		userRepo.delete(oldUser);
		return "Deleted Successfully";
	}
}

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

import np.edu.nast.bloodlink.entity.Role;
import np.edu.nast.bloodlink.repository.RoleRepository;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleRepository roleRepo;
	//find all
	@GetMapping
	public List<Role> allRole(){
		return roleRepo.findAll();

	}

	//create
	@PostMapping
	public Role createRole(@RequestBody Role role) {
		return roleRepo.save(role);
		
	}

	// read
	@GetMapping("/{id}")
	public Role findRole(@PathVariable("id") Long id) {
		return roleRepo.findById(id).get();
	}


	// delete
	@DeleteMapping("/{id}")
	public String deleteRole(@PathVariable("id")Long id) {
		Role oldROle= roleRepo.findById(id).get();
		roleRepo.delete(oldROle);
		return "Deleted Successfully";
	}

}

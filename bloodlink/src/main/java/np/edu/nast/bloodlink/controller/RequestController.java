package np.edu.nast.bloodlink.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import np.edu.nast.bloodlink.entity.Requester;
import np.edu.nast.bloodlink.repository.RequesterRepository;



@RestController 
@RequestMapping("/requester")
public class RequestController {


	@Autowired
	private RequesterRepository requesterRepo;

	@GetMapping
	public List<Requester> displayAll()
	{
		return requesterRepo.findAll();
	}
	@PostMapping
	public Requester createRequester(@RequestBody Requester requester)
	{
		return requesterRepo.save(requester);
	}
	@DeleteMapping("/{id}")
	public String deleteRequester (@PathVariable("id") Long id)
	{
		Optional<Requester> requester = requesterRepo.findById(id);
		if(requester.isPresent())
		{
			requesterRepo.deleteById(id);
			return "requester is deleted with id" +id ;// this is just for 
		}
		else {
			return "sorry not deleted";
		}
	}
}


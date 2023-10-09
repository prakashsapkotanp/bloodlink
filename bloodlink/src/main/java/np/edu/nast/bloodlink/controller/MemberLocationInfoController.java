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
import np.edu.nast.bloodlink.entity.MemberLocationInfo;
import np.edu.nast.bloodlink.repository.MemberLocationInfoRepository;


@RestController
@RequestMapping("/memberLocationInfo")
public class MemberLocationInfoController {
	@Autowired
	private MemberLocationInfoRepository memberLocationInfoRepo;
	//find all
	@GetMapping
	public List<MemberLocationInfo> allMember(int id){
		return memberLocationInfoRepo.allMember(id);
	}

	//create
	@PostMapping
	public MemberLocationInfo createRole(@RequestBody MemberLocationInfo memberLocationInfo) {
		return memberLocationInfoRepo.save(memberLocationInfo);

	}

	// read
	@GetMapping("/{id}")
	public MemberLocationInfo findMemberLocationInfo(@PathVariable("id") Long id) {
		return memberLocationInfoRepo.findById(id).get();

	}


	//delete
	@DeleteMapping("/{id}")
	public String deleteMemberLocationInfo(@PathVariable("id")Long id) {
		MemberLocationInfo oldMemberLocationInfo= memberLocationInfoRepo.findById(id).get();
		memberLocationInfoRepo.delete(oldMemberLocationInfo);
		return "Deleted Successfully";
	}
}

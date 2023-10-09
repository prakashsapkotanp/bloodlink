package np.edu.nast.bloodlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import np.edu.nast.bloodlink.entity.Member;
import np.edu.nast.bloodlink.repository.MemberRepository;

@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberRepository memberRepo;

////create
@PostMapping
public Member createRole(@RequestBody Member member) {
	return memberRepo.save(member);

}

@GetMapping

public List<Member> getMembersWithDonationGreaterThan90Days() {
    return memberRepo.findMembersWithDonationGreaterThan90Days();
}


}




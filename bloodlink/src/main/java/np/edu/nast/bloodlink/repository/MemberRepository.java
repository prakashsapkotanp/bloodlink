package np.edu.nast.bloodlink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import np.edu.nast.bloodlink.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long >{
	@Query("SELECT m FROM Member m WHERE DATEDIFF(CURRENT_DATE(), m.last_date_of_donation) > 90 " 
+ "ORDER BY DATEDIFF(CURRENT_DATE, m.last_date_of_donation) DESC")
	//List<Member> findMembersWithDonationGreaterThan90Days();

	List<Member> findMembersWithDonationGreaterThan90Days();
}





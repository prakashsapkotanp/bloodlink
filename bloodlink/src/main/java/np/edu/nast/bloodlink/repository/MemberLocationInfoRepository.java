package np.edu.nast.bloodlink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import np.edu.nast.bloodlink.entity.MemberLocationInfo;

public interface MemberLocationInfoRepository extends JpaRepository<MemberLocationInfo, Long>{
	@Query(value = "select * from tbl_MemberLocationInfo where id = ?",nativeQuery = true)
	public List<MemberLocationInfo> allMember(int id);

}

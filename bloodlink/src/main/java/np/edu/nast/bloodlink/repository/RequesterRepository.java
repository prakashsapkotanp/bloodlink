package np.edu.nast.bloodlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import np.edu.nast.bloodlink.entity.Requester;

public interface RequesterRepository  extends JpaRepository<Requester,Long> {


}

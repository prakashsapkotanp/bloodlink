package np.edu.nast.bloodlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import np.edu.nast.bloodlink.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

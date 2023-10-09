package np.edu.nast.bloodlink.repository;

import np.edu.nast.bloodlink.entity.Donor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
}

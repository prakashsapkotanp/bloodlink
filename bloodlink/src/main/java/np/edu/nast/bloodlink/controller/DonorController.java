package np.edu.nast.bloodlink.controller;

import jakarta.transaction.Transactional;
import np.edu.nast.bloodlink.entity.Donor;
import np.edu.nast.bloodlink.repository.DonorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {

    private final DonorRepository donorRepository;

    @Autowired
    public DonorController(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @GetMapping
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @GetMapping("/{donorId}")
    public Donor getDonorById(@PathVariable Long donorId) {
        return donorRepository.findById(donorId)
                .orElse(null);
    }

    @PostMapping
    public Donor createDonor( @RequestBody Donor donor) {
        return donorRepository.save(donor);
    }

    @PutMapping("/{donorId}")
    public Donor updateDonor(@PathVariable Long donorId, @RequestBody Donor donor) {
        donor.setDonorId(donorId);
        return donorRepository.save(donor);
    }

    @DeleteMapping("/{donorId}")
    @Transactional
    public void deleteDonor(@PathVariable Long donorId) {
        donorRepository.deleteById(donorId);
    }
}

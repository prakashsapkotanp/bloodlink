package np.edu.nast.bloodlink.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.edu.nast.bloodlink.controller.GeoCalculationService;
import np.edu.nast.bloodlink.entity.MemberLocationInfo;
import np.edu.nast.bloodlink.entity.Requester;
import np.edu.nast.bloodlink.repository.MemberLocationInfoRepository;
import np.edu.nast.bloodlink.repository.RequesterRepository;

@Service
public class DonationService {
	@Autowired
	private MemberLocationInfoRepository memberLocationInfoRepository;

	@Autowired
	private RequesterRepository requesterRepository;

	@Autowired
	private GeoCalculationService geoCalculationService;

	public List<MemberLocationInfo> findDonorsByDistance(Requester requester) {
		List<MemberLocationInfo> donors = memberLocationInfoRepository.findAll();

		// Sort the donors list in ascending order based on distance
		donors.sort(Comparator.comparing(donor ->
		geoCalculationService.calculateDistance(
				requester.getLatitude(),
				requester.getLongitude(),
				donor.getLatitude(),
				donor.getLongitude()
				)
				));

		return donors;
	}

}

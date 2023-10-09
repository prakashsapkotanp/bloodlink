package np.edu.nast.bloodlink.controller;

import org.springframework.stereotype.Service;

@Service
public class GeoCalculationService {

	private static final double EARTH_RADIUS = 6371; // Earth's radius in kilometers

	public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		// Convert latitude and longitude from degrees to radians
		double lat1Rad = Math.toRadians(lat1);
		double lon1Rad = Math.toRadians(lon1);
		double lat2Rad = Math.toRadians(lat2);
		double lon2Rad = Math.toRadians(lon2);

		// Haversine formula
		double dLat = lat2Rad - lat1Rad;
		double dLon = lon2Rad - lon1Rad;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad)
				* Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = EARTH_RADIUS * c;

		return distance; // Distance in kilometers
	}

}




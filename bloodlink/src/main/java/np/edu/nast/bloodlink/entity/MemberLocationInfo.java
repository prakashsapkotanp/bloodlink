package np.edu.nast.bloodlink.entity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_MemberLocationInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberLocationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "location", length = 30,nullable = false)
	private String location;
	@Column(name = "latitude", length = 20,nullable = false)
	private double latitude;
	@Column(name = "longitude", length = 20,nullable = false)
	private double longitude;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
    private Member member;
	
	  public double getLatitude() {
	        return latitude;
	    }

	    public double getLongitude() {
	        return longitude;
	    }

	
}

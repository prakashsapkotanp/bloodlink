package np.edu.nast.bloodlink.entity;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reqester")

public class Requester {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long requesterId;
	@Column(nullable = false)
	private Long phoneNo;
	@Column(nullable = false)
	private int pints;
	@Column(nullable = false, length = 5)
	String bloodGroup;
	@Column(nullable = false, length = 15)
	double latitude;
	@Column(nullable = false, length = 15)
	double longitude;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
}

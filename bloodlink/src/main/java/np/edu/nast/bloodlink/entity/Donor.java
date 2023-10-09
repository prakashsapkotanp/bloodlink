package np.edu.nast.bloodlink.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "donor")
public class Donor {
	 @Id
	    private Long donorId;
	 
	 @ManyToOne
	    @JoinColumn(name = "member_id", referencedColumnName = "member_id")
	    private Member member;

	    @ManyToOne
	    @JoinColumn(name = "requesterId", referencedColumnName = "requesterId") // Assuming "requesterId" is the primary key of the Requester entity
	    private Requester requester;

	    private boolean status;

}

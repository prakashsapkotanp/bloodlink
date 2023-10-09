package np.edu.nast.bloodlink.entity;

import java.util.Date;

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
@Table(name = "tbl_members")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long member_id;
	 @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private User user;
	 @Column(name = "first_name",length= 20, nullable = false)
	 private String first_name;
	 
	 @Column(name = "middle_name",length= 20)
	 private String middle_name;
	 @Column(name = "last_name",length= 20, nullable = false)
	 private String last_name;
	 @Column(name = "gender",length= 8, nullable = false)
	 private String gender;
	 @Column(name = "dob",nullable = false)
	 private Date dob;
	 @Column(name = "email",length= 40)
	 private String email;
	 @Column(name = "reg_date", nullable = false)
	 private Date reg_date;
	 @Column(name = "last_date_of_donation")
	 private Date last_date_of_donation;
	 @Column(name = "blood_group",length= 4, nullable = false)
	 private String blood_group;
	 
	 
}

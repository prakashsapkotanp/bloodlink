package np.edu.nast.bloodlink.entity;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long role_id;
	@Column(name = "code", length = 15,nullable = false)
	private String code;
	@Column(name = "name", length = 15,nullable = false)
	private String name;

	@ManyToMany(fetch= FetchType.LAZY, cascade = { CascadeType.ALL })  
	@JoinTable(name = "user_role",   
	            joinColumns = { @JoinColumn(name = "role_id",referencedColumnName = "role_id") },   
	            inverseJoinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "user_id") })  
	private List<User> user;  
	
}
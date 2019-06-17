package pl.air.hr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@NoArgsConstructor @Getter @Setter
public class Department {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dep_id")
	private Integer id;
	
	private String name;
	
	private String location;

}

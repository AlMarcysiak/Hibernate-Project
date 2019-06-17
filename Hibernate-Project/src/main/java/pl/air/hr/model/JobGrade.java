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
@Table(name = "job_grades")
@NoArgsConstructor @Getter @Setter
public class JobGrade {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jg_id")
	private Integer id;
	
	private String name;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;

}

package pl.air.hr.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@NoArgsConstructor @Getter @Setter
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer id;
		
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "hire_date")
	private LocalDate hireDate;
	
	private double salary;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="dep_id")
	private Department department;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pos_id")
	private Position position;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="jg_id")
	private JobGrade jobGrade;
	
}

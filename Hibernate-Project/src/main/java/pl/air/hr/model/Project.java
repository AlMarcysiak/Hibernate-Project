package pl.air.hr.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@NoArgsConstructor @Getter @Setter
public class Project {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private Integer id;
	
	private String name;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToMany
	@JoinTable(name = "proj_emp",		
		joinColumns = @JoinColumn(name = "proj_id"),
		inverseJoinColumns = @JoinColumn(name = "emp_id")
	)
	private List<Employee> participants = new ArrayList<>();
	
	
	
	/* *************** Business methods *************** */
	
	public void addParticipant(Employee employee) {
		if (! participants.contains(employee)) {
			participants.add(employee);
		}
	}
	
	public void addParticipants(Employee... employees) {
		for (Employee e : employees) {
			addParticipant(e);
		}
	}

	public void removeParticipant(Employee employee) {
		participants.remove(employee);
	}
	
}

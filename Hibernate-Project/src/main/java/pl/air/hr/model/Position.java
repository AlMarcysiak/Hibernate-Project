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
@Table(name = "positions")
@NoArgsConstructor @Getter @Setter
public class Position {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pos_id")
	private Integer id;
	
	private String name;

}

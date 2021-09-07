package acme.entities.tasks;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.datatypes.Visibility;
import acme.entities.roles.Manager;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Task extends DomainEntity{
	
	// Serialisation identifier --------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	// Atributtes ----------------------------------------------------
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	protected Manager manager;
	
	@NotNull
	protected Visibility visibility;
	
	@NotBlank
	@Length(min = 1, max = 79)
	protected String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date executionStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date executionEnd;
	
	@NotNull
	@Min(0)
	@Digits(integer=2, fraction = 2)
	protected Double workload;
	
	@NotBlank
	@Length(min = 1, max = 499)
	protected String description;
	
	@URL
	protected String link;
	


}


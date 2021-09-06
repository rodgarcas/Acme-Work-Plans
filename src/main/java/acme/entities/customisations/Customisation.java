package acme.entities.customisations;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customisation extends DomainEntity {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

		// Attributes -------------------------------------------------------------

		@NotBlank
		protected String spamwordsEng;
		
		@NotBlank
		protected String spamwordsSpa;

		@Range(min = 0, max = 100)
		@NotNull
		protected Double threshold;

		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------


}

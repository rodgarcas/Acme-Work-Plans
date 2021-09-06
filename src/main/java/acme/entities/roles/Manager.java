package acme.entities.roles;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import acme.entities.tasks.Task;
import acme.framework.entities.UserRole;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Manager extends UserRole {
	
		// Serialisation identifier -----------------------------------------------

		protected static final long serialVersionUID = 1L;

		// Attributes -------------------------------------------------------------
		
		// Derived attributes -----------------------------------------------------

		// Relationships ----------------------------------------------------------
		@OneToMany(mappedBy = "manager", fetch = FetchType.EAGER)
	    Set<Task> tasks;
}


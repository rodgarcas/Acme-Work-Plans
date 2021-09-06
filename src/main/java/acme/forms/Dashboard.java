package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {
	
	// Serialisation identifier -----------------------------------------------

		protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
		
		Integer numPublicTasks;
		Integer numPrivateTasks;
		Integer numFinishedTasks;
		Integer numNotFinishedTasks;
		Double	avgTaskExecutionPeriods;
		Double	devTaskExecutionPeriods;
		Double	minTaskExecutionPeriods;
		Double	maxTaskExecutionPeriods;
		Double	avgTaskWorkloads;
		Double	devTaskWorkloads;
		Double	minTaskWorkloads;
		Double	maxTaskWorkloads;


}

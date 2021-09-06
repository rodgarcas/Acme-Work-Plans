package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {
	
	@Query("SELECT COUNT(t) FROM Task t WHERE (t.visibility = 0)")
	Integer numPublicTasks();
	
	@Query("SELECT COUNT(t) FROM Task t WHERE (t.visibility = 1)")
	Integer numPrivateTasks();
	
	@Query("SELECT COUNT(t) FROM Task t WHERE (t.executionEnd < :today)")
	Integer numFinishedTasks(Date today);
	
	@Query("SELECT COUNT(t) FROM Task t WHERE (t.executionEnd > :today)")
	Integer numNotFinishedTasks(Date today);
	
	@Query("SELECT AVG(DATEDIFF(t.executionEnd,t.executionStart)) FROM Task t")
	Double avgTaskExecutionPeriods();
	
	@Query("SELECT STDDEV(DATEDIFF(t.executionEnd,t.executionStart)) FROM Task t")
	Double devTaskExecutionPeriods();
	
	@Query("SELECT MIN(DATEDIFF(t.executionEnd,t.executionStart)) FROM Task t")
	Double minTaskExecutionPeriods();
	
	@Query("SELECT MAX(DATEDIFF(t.executionEnd,t.executionStart)) FROM Task t")
	Double maxTaskExecutionPeriods();
	
	@Query("SELECT AVG(t.workload) FROM Task t")
	Double avgTaskWorkloads();
	
	@Query("SELECT STDDEV(t.workload) FROM Task t")
	Double devTaskWorkloads();
	
	@Query("SELECT MIN(t.workload) FROM Task t")
	Double minTaskWorkloads();
	
	@Query("SELECT MAX(t.workload) FROM Task t")
	Double maxTaskWorkloads();

}

package acme.features.authenticated.task;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.datatypes.Visibility;
import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.executionEnd < current_timestamp() and t.visibility = ?1"
		+ " ORDER BY t.workload DESC")
	Collection<Task> findPublicFinishedTasks(Visibility visibility);
	
	@Query("select t from Task t where t.id = ?1")
	Task findTaskById(int id);

}

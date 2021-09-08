package acme.features.anonymous.task;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTaskListPublicNonFinished implements AbstractListService<Anonymous, Task> {

	// Internal state
	
	@Autowired
	protected AnonymousTaskRepository repository;
	
	// AbstractListService<Anonymous, Task> interface
	
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "visibility", "title", "executionStart", 
				"executionEnd", "description", "link", "workload");
		
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		assert request != null;
		
		Collection<Task> result;
		
		result = this.repository.findPublicNonFinished();
		return result;
	}
	
	

}

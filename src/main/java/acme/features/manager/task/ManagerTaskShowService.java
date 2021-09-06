package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerTaskShowService implements AbstractShowService<Manager, Task> {
	
		// Internal state
	
		@Autowired
		protected ManagerTaskRepository repository;
		
		// AbstractShowService<Anonymous, Task> interface
		
		@Override
		public boolean authorise(final Request<Task> request) {
			assert request != null;
			
			int taskId;
			Task task;
			final Manager manager;
			Principal principal;
			
			final Integer managerId = request.getPrincipal().getActiveRoleId();
	        manager = this.repository.findOneManagerById(managerId);
			taskId = request.getModel().getInteger("id");
			task = this.repository.findOneTaskById(taskId);
			assert task != null;
			principal = request.getPrincipal();
			
			return manager.getUserAccount().getId() == principal.getAccountId() &&
				manager.getTasks().contains(task);
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
		public Task findOne(final Request<Task> request) {
			assert request != null;
			
			Task result;
			int id;
			
			id = request.getModel().getInteger("id");
			result = this.repository.findOneTaskById(id);
			
			return result;
			
		}

}

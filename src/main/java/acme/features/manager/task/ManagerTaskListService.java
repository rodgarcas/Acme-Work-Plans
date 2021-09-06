package acme.features.manager.task;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListService implements AbstractListService<Manager, Task> {
	
		// Internal state ---------------------------------------------------------

		@Autowired
		protected ManagerTaskRepository repository;


		// AbstractListService<Administrator, Shout> interface --------------

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


			final Integer managerId = request.getPrincipal().getActiveRoleId();
			final Manager manager = this.repository.findOneManagerById(managerId);

			assert manager != null;

			return manager.getTasks();
		}

}

package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class ManagerTaskDeleteService implements AbstractDeleteService<Manager,Task> {
	
			// Internal state ---------------------------------------------------------

			@Autowired
			protected ManagerTaskRepository repository;

			// AbstractDeleteService<Manager,Task> interface -----------------


			@Override
			public boolean authorise(final Request<Task> request) {
				assert request != null;

				return true;
			}

			@Override
			public void validate(final Request<Task> request, final Task entity, final Errors errors) {
				assert request != null;
				assert entity != null;
				assert errors != null;
			}

			@Override
			public void bind(final Request<Task> request, final Task entity, final Errors errors) {
				assert request != null;
				assert entity != null;
				assert errors != null;

				request.bind(entity, errors);
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

				final int id = request.getModel().getInteger("id");
				return this.repository.findOneTaskById(id);
			}

			@Override
			public void delete(final Request<Task> request, final Task entity) {
				assert request != null;
				assert entity != null;

				this.repository.delete(entity);
			}

}

package acme.features.manager.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.features.administrator.customisation.AdministratorCustomisationRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;
import acme.modules.Spam;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {
	
		// Internal state ---------------------------------------------------------

		@Autowired
		protected ManagerTaskRepository repository;
		
		@Autowired
		protected AdministratorCustomisationRepository customisationRepository;

		// AbstractCreateService<Administrator, Shout> interface --------------

		@Override
		public boolean authorise(final Request<Task> request) {
			assert request != null;

			return true;
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
				"executionEnd", "description", "link","workload");
		}

		@Override
		public Task instantiate(final Request<Task> request) {
			assert request != null;

			Task result;
			Manager manager;
			
			manager= this.repository.findOneManagerById(request.getPrincipal().getActiveRoleId());
			result= new Task();
			result.setManager(manager);

			return result;
		}

		@Override
		public void validate(final Request<Task> request, final Task entity, final Errors errors) {
			assert request != null;
			assert entity != null;
			assert errors != null;
			
			request.getLocale();
			
			if(!errors.hasErrors("executionEnd")) {
				errors.state(request, entity.getExecutionEnd().after(entity.getExecutionStart()), "executionEnd", "manager.task.form.error.end");
			}
			
			if(!errors.hasErrors("executionStart")) {
				final Date today = Calendar.getInstance().getTime();
				errors.state(request, entity.getExecutionStart().after(today), "executionStart", "manager.task.form.error.start");
			}
			
			if(!errors.hasErrors("workload")) {
				final Double workload = entity.getWorkload();			
				final Integer horas = workload.intValue();
				final Double minutos = workload - horas;
				errors.state(request, minutos<0.6, "workload", "manager.task.form.error.workloadmin");
				
				if (!errors.hasErrors("executionStart") && !errors.hasErrors("executionEnd")) {
					final long executionStart = entity.getExecutionStart().getTime();
					final long executionEnd = entity.getExecutionEnd().getTime();
					final long diferencia = executionEnd - executionStart;
					final Integer minutosdif = (int) (diferencia/(1000*60));
					final Integer minutosWorkload = (int) (horas*60 + minutos*100);
					errors.state(request, minutosdif>=minutosWorkload, "workload", "manager.task.form.error.workload");
				}
			}
			
			if(!errors.hasErrors("title")) {
				final Customisation custom = this.customisationRepository.findMany().stream().collect(Collectors.toList()).get(0);

				final String spamwords = request.getLocale().equals(Locale.ENGLISH) ? custom.getSpamwordsEng() : custom.getSpamwordsSpa();
				final Double threshold = custom.getThreshold();
				errors.state(request, !Spam.isSpam(entity.getTitle(), spamwords, threshold), "title", "manager.task.form.error.spam");
			}
			
			if(!errors.hasErrors("description")) {
				final Customisation custom = this.customisationRepository.findMany().stream().collect(Collectors.toList()).get(0);

				final String spamwords = request.getLocale().equals(Locale.ENGLISH) ? custom.getSpamwordsEng() : custom.getSpamwordsSpa();
				final Double threshold = custom.getThreshold();
				errors.state(request, !Spam.isSpam(entity.getDescription(), spamwords, threshold), "description", "manager.task.form.error.spam");
			}
			
			if(!errors.hasErrors("link")) {
				final Customisation custom = this.customisationRepository.findMany().stream().collect(Collectors.toList()).get(0);

				final String spamwords = request.getLocale().equals(Locale.ENGLISH) ? custom.getSpamwordsEng() : custom.getSpamwordsSpa();
				final Double threshold = custom.getThreshold();
				errors.state(request, !Spam.isSpam(entity.getLink(), spamwords, threshold), "link", "manager.task.form.error.spam");
			}
		}

		@Override
		public void create(final Request<Task> request, final Task entity) {
			assert request != null;
			assert entity != null;

			this.repository.save(entity);
		}


}

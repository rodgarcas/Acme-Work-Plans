package acme.features.administrator.dashboard;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {
	
		// Internal state ---------------------------------------------------------

		@Autowired
		protected AdministratorDashboardRepository repository;

		// AbstractShowService<Administrator, Dashboard> interface ----------------


		@Override
		public boolean authorise(final Request<Dashboard> request) {
			assert request != null;

			return true;
		}

		@Override
		public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, //
				"numPublicTasks", "numPrivateTasks", // 
				"numFinishedTasks", "numNotFinishedTasks", //
				"avgTaskExecutionPeriods", "devTaskExecutionPeriods",
				"minTaskExecutionPeriods", "maxTaskExecutionPeriods",
				"avgTaskWorkloads", "devTaskWorkloads",
				"minTaskWorkloads", "maxTaskWorkloads");
		}

		@Override
		public Dashboard findOne(final Request<Dashboard> request) {
			assert request != null;
			
			final Date today = new Date(System.currentTimeMillis());
			
			Dashboard result;
			Integer numPublicTasks;
			Integer numPrivateTasks;
			final Integer numFinishedTasks;
			final Integer numNotFinishedTasks;
			final Double	avgTaskExecutionPeriods;
			final Double	devTaskExecutionPeriods;
			final Double	minTaskExecutionPeriods;
			final Double	maxTaskExecutionPeriods;
			final Double	avgTaskWorkloads;
			final Double	devTaskWorkloads;
			final Double	minTaskWorkloads;
			final Double	maxTaskWorkloads;
			
			numPublicTasks = this.repository.numPublicTasks();
			numPrivateTasks = this.repository.numPrivateTasks();
			numFinishedTasks = this.repository.numFinishedTasks(today);
			numNotFinishedTasks = this.repository.numNotFinishedTasks(today);
			avgTaskExecutionPeriods = this.repository.avgTaskExecutionPeriods();
			devTaskExecutionPeriods = this.repository.devTaskExecutionPeriods();
			minTaskExecutionPeriods = this.repository.minTaskExecutionPeriods();
			maxTaskExecutionPeriods = this.repository.maxTaskExecutionPeriods();
			avgTaskWorkloads = this.repository.avgTaskWorkloads();
			devTaskWorkloads = this.repository.devTaskWorkloads();
			minTaskWorkloads = this.repository.minTaskWorkloads();
			maxTaskWorkloads = this.repository.maxTaskWorkloads();
			

			result = new Dashboard();
			result.setNumPublicTasks(numPublicTasks);
			result.setNumPrivateTasks(numPrivateTasks);
			result.setNumFinishedTasks(numFinishedTasks);
			result.setNumNotFinishedTasks(numNotFinishedTasks);
			result.setAvgTaskExecutionPeriods(avgTaskExecutionPeriods);
			result.setDevTaskExecutionPeriods(devTaskExecutionPeriods);
			result.setMinTaskExecutionPeriods(minTaskExecutionPeriods);
			result.setMaxTaskExecutionPeriods(maxTaskExecutionPeriods);
			result.setAvgTaskWorkloads(avgTaskWorkloads);
			result.setDevTaskWorkloads(devTaskWorkloads);
			result.setMinTaskWorkloads(minTaskWorkloads);
			result.setMaxTaskWorkloads(maxTaskWorkloads);
			

			return result;
		}

	
}

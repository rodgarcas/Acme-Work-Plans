package acme.features.administrator.customisation;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCustomisationShowService implements AbstractShowService<Administrator, Customisation>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		private AdministratorCustomisationRepository repository;

		@Override
		public boolean authorise(final Request<Customisation> request) {
			// TODO Auto-generated method stub
			assert request != null;
			return true;
		}

		@Override
		public void unbind(final Request<Customisation> request, final Customisation entity, final Model model) {
			// TODO Auto-generated method stub
			assert request != null;
			assert entity != null;
			assert model != null;
			request.unbind(entity, model,"spamwordsEng", "spamwordsSpa", "threshold");
			model.setAttribute("readonly", true);
			Boolean locale = request.getLocale().equals(Locale.ENGLISH);
			model.setAttribute("locale", locale);
			
		}

		@Override
		public Customisation findOne(final Request<Customisation> request) {
			// TODO Auto-generated method stub
			assert request != null;
			final List<Customisation> res = (List<Customisation>) this.repository.findMany();
			final Customisation result = res.get(0);
			return result;
		}

}

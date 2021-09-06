package acme.features.administrator.customisation;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Administrator;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCustomisationUpdateService implements AbstractUpdateService <Administrator, Customisation> {

	@Autowired
	protected AdministratorCustomisationRepository repository;
	
	@Override
	public boolean authorise(final Request<Customisation> request) {
		// TODO Auto-generated method stub
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Customisation> request, final Customisation entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(final Request<Customisation> request, final Customisation entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "spamwordsEng", "spamwordsSpa", "threshold");
		model.setAttribute("readonly", false);
		Boolean locale = request.getLocale().equals(Locale.ENGLISH);
		model.setAttribute("locale", locale);
	}

	@Override
	public Customisation findOne(final Request<Customisation> request) {
		// TODO Auto-generated method stub
		assert request != null;

		final Customisation result;
		
		final List<Customisation> res = (List<Customisation>) this.repository.findMany();
		result = res.get(0);

		return result;
	}

	@Override
	public void validate(final Request<Customisation> request, final Customisation entity, final Errors errors) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert errors != null;
		
	}

	@Override
	public void update(final Request<Customisation> request, final Customisation entity) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}
	
	@Override
	public void onSuccess(final Request<Customisation> request, final Response<Customisation> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}

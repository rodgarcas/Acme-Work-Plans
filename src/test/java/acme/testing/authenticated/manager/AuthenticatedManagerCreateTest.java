package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.AcmeWorkPlansTest;

public class AuthenticatedManagerCreateTest extends AcmeWorkPlansTest {
	
	/* Caso positivo
	 Un autenticado puede convertirse correctamente a manager en el caso que no lo sea
	 */
	@Test
	@Order(10)
	public void createManagerPositive() {
		super.navigateHome();
		super.signIn("authenticated1", "authenticated1");
		super.clickOnMenu("Account", "Become a manager");
		super.clickOnSubmitButton("Become a manager");
		
		super.clickOnMenu("Manager", "List tasks");
		super.checkSimplePath("/manager/task/list");
	}
	
	/* Caso negativo
	 Un usuario sin registrarse no puede convertirse en manager
	 */
	@Test
	@Order(10)
	public void createManagerNegative() {
		super.driver.get("http://localhost:8080/Acme-WorkPlans/authenticated/manager/create");
		super.checkErrorsExist();
	}
}

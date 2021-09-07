package acme.testing.administrator.customisation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorCustomisationListTest extends AcmeWorkPlansTest{
	
	/*
	Feature: B-Task-004: Manage customisation parameters & AdministratorCustomisationShowService
	Authorisation required: Administrator
	Imposed constraints: None
	Violated constraints: None
	Expected result: Visualisation of the unique instance of Customisation Parameter
	*/
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisation/positive-list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void list(final int recordIndex, final String spamwordsEng, final String threshold) {		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "default customisation");
		
		super.checkInputBoxHasValue("spamwordsEng", spamwordsEng);
		super.checkInputBoxHasValue("threshold", threshold);
		super.signOut();
	}	

}

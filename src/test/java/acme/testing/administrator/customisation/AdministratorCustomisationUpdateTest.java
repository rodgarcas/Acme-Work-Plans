package acme.testing.administrator.customisation;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorCustomisationUpdateTest extends AcmeWorkPlansTest {
	
	/*
	Feature: B-Task-004: Manage customisation parameters & AdministratorCustomisationUpdateService
	Authorisation required: Administrator
	Imposed constraints: spamwordEng (NotBlank)
						  threshold (NotBlank, size(min = 0, max 100))
	Violated constraints: None
	Expected result: Actualisation of the unique instance of Customisation Parameter
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisation/positive-update.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdate(final int recordIndex, final String spamwordsEng, final String threshold) {		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "update customisation");
		
		super.fillInputBoxIn("spamwordsEng", spamwordsEng);
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Update");
		
		super.clickOnMenu("Administrator", "default customisation");
		super.checkInputBoxHasValue("spamwordsEng", spamwordsEng);
		super.checkInputBoxHasValue("threshold", threshold);
		super.signOut();
	}	
	
	/*
	Feature: B-Task-004: Manage customisation parameters & AdministratorCustomisationUpdateService
	Authorisation required: Administrator
	Imposed constraints: spamwordEng (NotBlank)
						  threshold (NotBlank, size(min = 0, max 100))
	Violated constraints: spamwordEng (NotBlank)
						   threshold (NotBlank, size(min = 0, max 100))
	Expected result: Error in each attribute constraint
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/customisation/negative-update.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdate(final int recordIndex, final String spamwordsEng, final String threshold) {		
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "update customisation");
		
		super.fillInputBoxIn("spamwordsEng", spamwordsEng);
		super.fillInputBoxIn("threshold", threshold);
		super.clickOnSubmitButton("Update");
		super.clickOnSubmitButton("Update");
		
		super.checkErrorsExist();
		
		super.signOut();
	}	

}

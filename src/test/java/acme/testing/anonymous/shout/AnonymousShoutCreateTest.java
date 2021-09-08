package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousShoutCreateTest extends AcmeWorkPlansTest{
	
	
	/*
	Feature: C-Task-006: Write & publish shout & AnonymousShoutCreateService
	Authorisation required: Anonymous
	Imposed constraints: None
	Violated constraints: None
	Expected result: Create and publish a new shout with the given data
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/positive-create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveCreate(final int recordIndex, final String author, final String text, final String info) {		

		super.clickOnMenu("Anonymous","Shout!");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		
		super.clickOnSubmitButton("Shout!");
		
		super.clickOnMenu("Anonymous", "List recents shouts");
		
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
	}
	
	/*
	Feature: C-Task-006: Write & publish shout & AnonymousShoutCreateService
	Authorisation required: None
	Imposed constraints: author (NotBlank, Size(min = 5, max = 25)
						 text (NotEmpty, Size(max = 100)
						 info (URL)
						 Spam
	Violated constraints: author (NotBlank, Size(min = 5, max = 25)
						 text (NotEmpty, Size(max = 100)
						 info (URL)
						 Spam
	Expected result: Error in each attribute constraint
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/negative-create.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeCreate(final int recordIndex, final String author, final String text, final String info) {		

		super.clickOnMenu("Anonymous","Shout!");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		
		super.clickOnSubmitButton("Shout!");
		
		super.checkErrorsExist();
	

	}

}

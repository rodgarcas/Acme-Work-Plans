package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class ManagerTaskUpdateTest extends AcmeWorkPlansTest {

	/*
	Feature: B-Task-003: Manage tasks & ManagerTaskUpdateService & ManagerTaskListService & ManagerTaskShowService
	Authorisation required: Manager
	Imposed constraints: None
	Violated constraints: None
	Expected result: Updating a specific task with the given data
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)	
	public void updatePositive(final int recordIndex, final String visibility, final String title, final String executionStart, final String executionEnd, final String description, final String link, final String workload) {		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");		
		
		super.checkColumnHasValue(recordIndex, 0, visibility);
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("visibility", visibility);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("executionStart", executionStart);
		super.fillInputBoxIn("executionEnd", executionEnd);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("workload", workload);		
		
		super.clickOnSubmitButton("Update task");
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("visibility", visibility);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("executionStart", executionStart);
		super.checkInputBoxHasValue("executionEnd", executionEnd);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("workload", workload);
		
		super.signOut();
	}
	
	/*
	Feature: B-Task-003: Manage tasks & ManagerTaskUpdateService & ManagerTaskListService & ManagerTaskShowService
	Authorisation required: Manager
	Imposed constraints: Visibility (NotNull)
						 title (NotBlank, Length(min = 1, max = 79))
						 executionStart (NotNull)
						 executionEnd (NotNull)
						 workload (NotNull, Min(0))
						 description (NotBlank, Length(min =1, max = 499))
						 link (URL)
						 
	Violated constraints: Visibility (NotNull)
						 title (NotBlank, Length(min = 1, max = 79))
						 executionStart (NotNull)
						 executionEnd (NotNull)
						 workload (NotNull, Min(0))
						 description (NotBlank, Length(min =1, max = 499))
						 link (URL)
	Expected result: Error in each attribute constraint
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)	
	public void updateNegative(final int recordIndex, final String visibility, final String title, final String executionStart, final String executionEnd, final String description, final String link, final String workload) {		
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");		
		
		super.checkColumnHasValue(recordIndex, 0, visibility);
		
		super.clickOnListingRecord(recordIndex);
		
		super.fillInputBoxIn("visibility", visibility);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("executionStart", executionStart);
		super.fillInputBoxIn("executionEnd", executionEnd);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("workload", workload);		
		
		super.clickOnSubmitButton("Update task");
		
		super.checkErrorsExist();
		
		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------


}
package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class ManagerTaskDeleteTest extends AcmeWorkPlansTest {
	
	/*
	Feature: B-Task-003: Manage tasks & ManagerTaskDeleteServce
	Authorisation required: Manager
	Imposed constraints: None
	Violated constraints: None
	Expected result: Elimination of task entity
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/list-all.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void delete(final int recordIndex) {
		super.signIn("manager", "manager");
		
		super.clickOnMenu("Manager", "List tasks");
		
		super.clickOnListingRecord(0);
		
		super.clickOnSubmitButton("Delete task");
		super.isSimplePath("/manager/task/list");
		
		super.signOut();
	}

}

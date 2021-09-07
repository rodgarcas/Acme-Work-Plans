package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AdministratorDashboardTest extends AcmeWorkPlansTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void showPositive(final int recordIndex,
		final String numPublicTasks, final String numPrivateTasks,final String numFinishedTasks, final String numNotFinishedTasks, 
		final String avgTaskExecutionPeriods, final String devTaskExecutionPeriods, final String minTaskExecutionPeriods,
		final String maxTaskExecutionPeriods, final String avgTaskWorkloads, final String devTaskWorkloads, 
		final String minTaskWorkloads, final String maxTaskWorkloads) {
		
	super.signIn("administrator", "administrator");
	super.clickOnMenu("Administrator", "Dashboard");
	
	super.checkInputBoxHasValue("numPublicTasks", numPublicTasks);
	super.checkInputBoxHasValue("numPrivateTasks", numPrivateTasks);
	super.checkInputBoxHasValue("numFinishedTasks", numFinishedTasks);
	super.checkInputBoxHasValue("numNotFinishedTasks", numNotFinishedTasks);
	super.checkInputBoxHasValue("avgTaskExecutionPeriods", avgTaskExecutionPeriods);
	super.checkInputBoxHasValue("devTaskExecutionPeriods", devTaskExecutionPeriods);
	super.checkInputBoxHasValue("minTaskExecutionPeriods", minTaskExecutionPeriods);
	super.checkInputBoxHasValue("maxTaskExecutionPeriods", maxTaskExecutionPeriods);
	super.checkInputBoxHasValue("avgTaskWorkloads", avgTaskWorkloads);
	super.checkInputBoxHasValue("devTaskWorkloads", devTaskWorkloads);
	super.checkInputBoxHasValue("minTaskWorkloads", minTaskWorkloads);
	super.checkInputBoxHasValue("maxTaskWorkloads", maxTaskWorkloads);
	
	super.signOut();
	}
	
}

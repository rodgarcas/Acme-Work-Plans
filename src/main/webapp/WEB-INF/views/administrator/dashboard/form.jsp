<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">
	<caption>
	 <acme:message code="administrator.dashboard.form.title.general-indicators"/>
	 </caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numPublicTasks"/>
		</th>
		<td>
		<acme:form-textbox readonly="true" code="" path="numPublicTasks" />
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numPrivateTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="numPrivateTasks" />
		</td>
	
	</tr>	

	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numFinishedTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="numFinishedTasks" />
		</td>
	
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numNotFinishedTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="numNotFinishedTasks" />
		</td>
	
	</tr>
</table>
<h2>
	<acme:message code="administrator.dashboard.form.title.executionPeriods"/>
</h2>

<table class="table table-sm">
	<caption>
	 <acme:message code="administrator.dashboard.form.title.executionPeriods"/>
	 </caption>	

	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="avgTaskExecutionPeriods" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.devTasks"/>
		</th>
		<td>
		<acme:form-textbox readonly="true" code="" path="devTaskExecutionPeriods" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="minTaskExecutionPeriods" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="maxTaskExecutionPeriods" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	
</table>

<h2>
	<acme:message code="administrator.dashboard.form.title.taskWorkloads"/>
</h2>

<table class="table table-sm">	
	<caption>
	 <acme:message code="administrator.dashboard.form.title.taskWorkloads"/>
	 </caption>	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="avgTaskWorkloads" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.devTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="devTaskWorkloads" /> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="minTaskWorkloads" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxTasks"/>
		</th>
		<td>
			<acme:form-textbox readonly="true" code="" path="maxTaskWorkloads" />
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	
</table>
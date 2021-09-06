<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<h2>
	<acme:message code="administrator.dashboard.form.title.general-indicators"/>
</h2>

<table class="table table-sm">	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numPublicTasks"/>
		</th>
		<td>
			<acme:print value="${numPublicTasks}"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numPrivateTasks"/>
		</th>
		<td>
			<acme:print value="${numPrivateTasks}"/>
		</td>
	
	</tr>	

	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numFinishedTasks"/>
		</th>
		<td>
			<acme:print value="${numFinishedTasks}"/>
		</td>
	
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.numNotFinishedTasks"/>
		</th>
		<td>
			<acme:print value="${numNotFinishedTasks}"/>
		</td>
	
	</tr>
</table>
<h2>
	<acme:message code="administrator.dashboard.form.title.executionPeriods"/>
</h2>

<table class="table table-sm">	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgTasks"/>
		</th>
		<td>
			<acme:print value="${avgTaskExecutionPeriods}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.devTasks"/>
		</th>
		<td>
			<acme:print value="${devTaskExecutionPeriods}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minTasks"/>
		</th>
		<td>
			<acme:print value="${minTaskExecutionPeriods}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxTasks"/>
		</th>
		<td>
			<acme:print value="${maxTaskExecutionPeriods}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	
</table>

<h2>
	<acme:message code="administrator.dashboard.form.title.taskWorkloads"/>
</h2>

<table class="table table-sm">	
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.avgTasks"/>
		</th>
		<td>
			<acme:print value="${avgTaskWorkloads}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.devTasks"/>
		</th>
		<td>
			<acme:print value="${devTaskWorkloads}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.minTasks"/>
		</th>
		<td>
			<acme:print value="${minTaskWorkloads}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	<tr>
		<th scope="row">
			<acme:message code="administrator.dashboard.form.label.maxTasks"/>
		</th>
		<td>
			<acme:print value="${maxTaskWorkloads}"/> 
			<acme:message code="administrator.dashboard.form.result.days"/>
		</td>
	</tr>
	
</table>
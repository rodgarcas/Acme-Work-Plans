<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="${readonly}">

	<jstl:if test="${locale}">
		<acme:form-textbox code="administrator.customisation.form.label.spamwords" path="spamwordsEng"/>
	</jstl:if>
	
	<jstl:if test="${!locale}">
		<acme:form-textbox code="administrator.customisation.form.label.spamwords" path="spamwordsSpa"/>
	</jstl:if>
	
	<acme:form-double code="administrator.customisation.form.label.threshold" path="threshold"/>
	
	<jstl:if test="${!readonly}">
		<acme:form-submit code = "administrator.customisation.button.update" action = "/administrator/customisation/update"/>
	</jstl:if>
	<acme:form-return  code="administrator.customisation.form.button.return"/>
</acme:form>
<%@ include file="init.jsp" %>

<%
	Services services = null;
	long serviceId = ParamUtil.getLong(request, "serviceId");
	if (serviceId > 0) {
		services = ServicesLocalServiceUtil.getServices(serviceId);
	}
	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= services %>" model="<%= Services.class %>" />
<portlet:renderURL var="viewServicesURL" />
<portlet:actionURL name='<%= services == null ? "addServices" : "updateServices" %>' var="editServicesURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewServicesURL %>"
	title='<%= (services != null) ? services.getServiceName() : "New Service" %>'
/>

<aui:form action="<%= editServicesURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="serviceId" type="hidden" value='<%= services == null ? "" : services.getServiceId() %>'/>
		<aui:input name="serviceName" />
		<aui:input name="serviceDescription" />
		<aui:input name="servicePrice" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%= viewServicesURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>
<%@ include file="init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addServicesURL">
		<portlet:param name="mvcPath"
			value="/updateService.jsp" />
		<portlet:param name="redirect" value="<%=redirect%>" />
	</portlet:renderURL>

	<aui:button onClick="<%=addServicesURL.toString()%>"
		value="New Service" />
</aui:button-row>

<%
	String displayStyle = GetterUtil.getString(portletPreferences.getValue("displayStyle", StringPool.BLANK));
	long displayStyleGroupId = GetterUtil.getLong(portletPreferences.getValue("displayStyleGroupId", null),
			scopeGroupId);
	boolean showServiceName_view = GetterUtil
			.getBoolean(portletPreferences.getValue("showServiceName", StringPool.TRUE));
%>


<liferay-ui:search-container total="<%=ServicesLocalServiceUtil.getServicesCountByGroupId(scopeGroupId)%>" >
	<liferay-ui:search-container-results
		results="<%=ServicesLocalServiceUtil.getServicesByGroupId(scopeGroupId, searchContainer.getStart(),
						searchContainer.getEnd())%>"
		/>

	<liferay-ui:search-container-row
		className="AAACustomerServices.model.Services" keyProperty="serviceId"
		modelVar="services" escapedModel="<%=true%>">

		<c:choose>
			<c:when test="<%=showServiceName_view == true%>">
				<liferay-ui:search-container-column-text name="Service Name"
					value="<%=services.getServiceName()%>" />

			</c:when>
		</c:choose>

		<liferay-ui:search-container-column-text name="Service Description"
			property="serviceDescription" />


		<liferay-ui:search-container-column-text name="Service Price"
			property="servicePrice" />



		<liferay-ui:search-container-column-jsp align="right" path="/ServiceActions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

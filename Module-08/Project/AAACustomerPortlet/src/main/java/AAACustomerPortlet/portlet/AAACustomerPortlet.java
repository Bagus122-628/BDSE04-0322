package AAACustomerPortlet.portlet;

import AAACustomerPortlet.constants.AAACustomerPortletKeys;

import java.util.Calendar;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import AAACustomerServices.model.Customer;
import AAACustomerServices.model.Services;
import AAACustomerServices.service.CustomerLocalService;
import AAACustomerServices.service.CustomerLocalServiceUtil;
import AAACustomerServices.service.ServicesLocalService;
import AAACustomerServices.service.ServicesLocalServiceUtil;

/**
 * @author User
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.AAA",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AAACustomer",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AAACustomerPortletKeys.AAACUSTOMER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AAACustomerPortlet extends MVCPortlet {
	
	//CustomerPortlet
	public void addCustomer(ActionRequest request, ActionResponse response)
            throws Exception {

        _updateCustomer(request);

        sendRedirect(request, response);
    }

    public void deleteCustomer(ActionRequest request, ActionResponse response)
        throws Exception {

        long customerId = ParamUtil.getLong(request, "customerId");

        CustomerLocalServiceUtil.deleteCustomer(customerId);

        sendRedirect(request, response);
    }

    public void updateCustomer(ActionRequest request, ActionResponse response)
        throws Exception {

        _updateCustomer(request);

        sendRedirect(request, response);
    }

    private Customer _updateCustomer(ActionRequest request)
        throws PortalException, SystemException {

    	// Collect all information from JSP
        long customerId = ParamUtil.getLong(request, "customerId");
        String name = ParamUtil.getString(request, "name");
        String email = ParamUtil.getString(request, "email");
        String address = ParamUtil.getString(request, "address");
        String national_Id = ParamUtil.getString(request, "national_Id");
        String contact = ParamUtil.getString(request, "contact");
        long serviceId = ParamUtil.getLong(request, "serviceId");

        int year = ParamUtil.getInteger(request, "start_dateYear");
        int month = ParamUtil.getInteger(request, "start_dateMonth");
        int day = ParamUtil.getInteger(request, "start_dateDay");
        int hour = ParamUtil.getInteger(request, "start_dateHour");
        int minute = ParamUtil.getInteger(request, "start_dateMinute");
        int amPm = ParamUtil.getInteger(request, "start_dateAmPm");

        if (amPm == Calendar.PM) {
            hour += 12;
        }

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            Customer.class.getName(), request);

        Customer customer = null;
        
        //Check old customer or new Customer
        if (customerId <= 0) {
        	System.out.println("Add Customer ");
        	//  add Customer Method 
        	customer = CustomerLocalServiceUtil.addCustomer(
                serviceContext.getUserId(), serviceContext.getScopeGroupId(),
                name, email, address, national_Id, contact, month, day, year, hour, minute, serviceId,
                serviceContext);
        }
        else {
        	System.out.println("Update Customer ");
        	customer = CustomerLocalServiceUtil.getCustomer(customerId);
        	//Call update method
        	customer = CustomerLocalServiceUtil.updateCustomer(
                serviceContext.getUserId(), customerId, name, email, address, national_Id, contact, month,
                day, year, hour, minute, serviceId, serviceContext);
        }
        
        return customer;
    }

    //ServicePortlet
    
    public void addServices(ActionRequest request, ActionResponse response)
            throws Exception {

        _updateServices(request);

        sendRedirect(request, response);
    }

    public void deleteServices(ActionRequest request, ActionResponse response)
        throws Exception {

        long serviceId = ParamUtil.getLong(request, "serviceId");

        ServicesLocalServiceUtil.deleteServices(serviceId);

        sendRedirect(request, response);
    }

    public void updateServices(ActionRequest request, ActionResponse response)
        throws Exception {

        _updateServices(request);

        sendRedirect(request, response);
    }

    private Services _updateServices(ActionRequest request)
            throws PortalException, SystemException {

        long serviceId = (ParamUtil.getLong(request, "serviceId"));
        String serviceName = (ParamUtil.getString(request, "serviceName"));
        String serviceDescription = (ParamUtil.getString(request, "serviceDescription"));
        String servicePrice = (ParamUtil.getString(request, "servicePrice"));
       
        ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Services.class.getName(), request);

        Services services = null;

        if (serviceId <= 0) {

            services = ServicesLocalServiceUtil.addServices(
                serviceContext.getUserId(), serviceContext.getScopeGroupId(), serviceName, serviceDescription, servicePrice, serviceContext);
        }
        else {
            services = ServicesLocalServiceUtil.getServices(serviceId);

            services = ServicesLocalServiceUtil.updateServices(
                    serviceContext.getUserId(), serviceId, serviceName, serviceDescription, servicePrice,
                    serviceContext);
        }

        return services;
    }

    private static Log _log = LogFactoryUtil.getLog(AAACustomerPortlet.class);
    
@Reference
private CustomerLocalService _customerEntryLocalService;

@Reference
private ServicesLocalService _servicesLocalService;
}
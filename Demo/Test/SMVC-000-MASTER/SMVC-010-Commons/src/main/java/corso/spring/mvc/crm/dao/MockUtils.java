package corso.spring.mvc.crm.dao;

import java.util.Date;
import java.util.List;

import corso.spring.mvc.crm.services.beans.BusinessContact;
import corso.spring.mvc.crm.services.beans.Contact;
import corso.spring.mvc.crm.services.beans.ContactTypeEnum;
import corso.spring.mvc.crm.services.beans.Customer;
import corso.spring.mvc.crm.services.beans.Group;
import corso.spring.mvc.crm.services.beans.TechnicalContact;

public class MockUtils {

	public static final String[] groups = { "Hosted Solutions", "Feeds",
			"System Administrators", "Help Desk", "Sales", "Human resources" };

	public static final String [] customers={
		"Fiat",
		"Mercedes",
		"BMW",
		"Skoda",
		"Audi",
		"Renault",
		"Opel",
		"Toyota"	
	};

	public static Contact createMockContact(int mockIndex) {
		int indexType = mockIndex % 2;
		switch (indexType) {
		case 1:
			return mockTechContact(mockIndex);
		default:
			return mockBusinessContact(mockIndex);
		}
	}

	public static TechnicalContact mockTechContact(int mockIndex) {
		TechnicalContact techContact = new TechnicalContact();
		techContact.setId(new Long(mockIndex));
		techContact.setName("MockName" + mockIndex);
		techContact.setTelephone("65456546455553" + mockIndex);
		techContact.setJoinDate(new Date());
		techContact.setActive(true);
		techContact.setCustomer(mockCustomer(mockIndex));
		techContact.setType(createMockContactType(mockIndex));
		techContact.getGroups().add(mockGroup(mockIndex));
		techContact.getGroups().add(mockGroup(mockIndex+1));
		techContact.getGroups().add(mockGroup(mockIndex+2));
		return techContact;
	}

	public static BusinessContact mockBusinessContact(int mockIndex) {
		BusinessContact bContact = new BusinessContact();
		bContact.setId(new Long(mockIndex));
		bContact.setName("MockName" + mockIndex);
		bContact.setTelephone("65456546455553" + mockIndex);
		bContact.setJoinDate(new Date());
		bContact.setActive(false);
		bContact.setType(createMockContactType(mockIndex));
		bContact.setDepartment("A Mock Department" + mockIndex);
		bContact.getGroups().add(mockGroup(mockIndex));	
		bContact.setCustomer(mockCustomer(mockIndex));
		return bContact;

	}

	public static ContactTypeEnum createMockContactType(int index) {
		int indexType = index % 2;
		switch (indexType) {
		case 1:
			return ContactTypeEnum.TECHNICAL;
		default:
			return ContactTypeEnum.BUSINESS;
		}
	}
	
	public static Customer mockCustomer(int customerMockIndex) {
		Customer customer = new Customer();
		customer.setName(nextElement(customerMockIndex, groups));
		return customer;
	}
	
	public static Group mockGroup(int groupMockIndex) {
		Group group = new Group();
		group.setName(nextElement(groupMockIndex, groups));
		return group;
	}

	private static String nextElement(int index, String[] data) {
		if (index < data.length) {
			return data[index];
		} else {
			return data[index % data.length];
		}
	}

	public static <T> T nextElement(int index, List<T> data, Class<T> dataClass) {
		if (index < data.size()) {
			return data.get(index);
		} else {
			return data.get(index % data.size());
		}
	}
}

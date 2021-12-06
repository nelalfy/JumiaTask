package com.jumia.task.service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jumia.task.entity.Customer;
import com.jumia.task.repository.CustomerRepo;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepository;

	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	public ArrayList<Boolean> validatePhone() {
		List<Customer> customers = customerRepository.findAll();
		ArrayList<Boolean> validatePhone = new ArrayList<Boolean>();
		for (Customer customer : customers) {

			String cameroonPhoneno = "\\(237\\)\\ ?[2368]\\d{7,8}$";
			String ethiopiaPhoneno = "\\(237\\)\\ ?[2368]\\d{7,8}$";
			String moroccoPhoneno = "\\(212\\)\\ ?[5-9]\\d{8}$";
			String mozambiquePhoneno = " \\(258\\)\\ ?[28]\\d{7,8}$";
			String ugandaPhoneno = "\\(256\\)\\ ?\\d{9}$";

			Pattern cameroonPhonenoPattern = Pattern.compile(cameroonPhoneno);
			Pattern ethiopiaPhonenoPattern = Pattern.compile(ethiopiaPhoneno);
			Pattern moroccoPhonenoPattern = Pattern.compile(moroccoPhoneno);
			Pattern mozambiquePhonenoPattern = Pattern.compile(mozambiquePhoneno);
			Pattern ugandaPhonenoPattern = Pattern.compile(ugandaPhoneno);

			boolean m = cameroonPhonenoPattern.matcher(customer.getPhone()).matches();

			if ((cameroonPhonenoPattern.matcher(customer.getPhone()).matches())
					|| (ethiopiaPhonenoPattern.matcher(customer.getPhone()).matches())
					|| (moroccoPhonenoPattern.matcher(customer.getPhone()).matches())
					|| (mozambiquePhonenoPattern.matcher(customer.getPhone()).matches())
					|| (ugandaPhonenoPattern.matcher(customer.getPhone()).matches())) {
				validatePhone.add(true);
			} else {
				validatePhone.add(false);
			}
		}
		return validatePhone;
	}

	public TreeMap<String, ArrayList<Customer>> getCustomersByCountryCode() {
		List<Customer> allCust = customerRepository.findAll();
		TreeMap<String, ArrayList<Customer>> filteredCustomers = new TreeMap<String, ArrayList<Customer>>();
		for (Customer customer : allCust) {
			String countryCode = (customer.getPhone().split("\\)", 3))[0];
			countryCode = countryCode.substring(1);
			if (filteredCustomers.containsKey(countryCode) == true) {
				ArrayList<Customer> customerArrayList = filteredCustomers.get((String) countryCode);
				filteredCustomers.put(countryCode, customerArrayList).add(customer);
			} else {
				ArrayList<Customer> cust = new ArrayList<Customer>();
				cust.add(customer);
				filteredCustomers.put((String) countryCode, (ArrayList<Customer>) cust);
			}

		}
		return filteredCustomers;
	}


}

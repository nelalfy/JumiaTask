package com.jumia.task.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumia.task.entity.Customer;
import com.jumia.task.repository.CustomerRepo;

@Service
public interface CustomerService {

	public  List<Customer> getCustomers() ;
	public ArrayList<Boolean> validatePhone() ;
	public TreeMap<String, ArrayList<Customer>> getCustomersByCountryCode() ;

}

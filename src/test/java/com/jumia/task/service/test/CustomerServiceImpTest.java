package com.jumia.task.service.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.jumia.task.entity.Customer;
import com.jumia.task.repository.CustomerRepo;
import com.jumia.task.service.CustomerService;
import com.jumia.task.service.CustomerServiceImp;

@ExtendWith(SpringExtension.class)
class CustomerServiceImpTest {

	@TestConfiguration
    static class CustomerServiceImplTestContextConfiguration {
 
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImp();
        }
    }
	
	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepo customerRepository;

	@Test
	public void getCustomersTest() {
		List<Customer> custList = customerRepository.findAll();
		assertNotNull(custList);
	}

	@Test
	public void getCustomersByCountryCodeTest() {
		assertNotNull(customerService.getCustomersByCountryCode());
	}

	@Test
	public void validatePhoneTest() {
		assertNotNull(customerService.validatePhone());
	}
}

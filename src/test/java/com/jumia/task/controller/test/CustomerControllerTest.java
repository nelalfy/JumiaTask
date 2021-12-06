package com.jumia.task.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URL;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CustomerControllerTest {
	
	@LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
	private MockMvc mockMvc;
    
	
  @Test
  public void getHello() throws Exception {
	  ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/customers/hello").toString(), String.class);
      assertEquals("Hello to Customer db", response.getBody());
  }
  
  @Test
	public void getCustomersText() throws Exception {
		this.mockMvc.perform(get("/customers/getCustomers")).andDo(print()).andExpect(status().isOk());
  }
	
  @Test
	public void getFilteredCustomersTest() throws Exception {
		this.mockMvc.perform(get("/customers/Countryfilter")).andDo(print()).andExpect(status().isOk());
}
	
}

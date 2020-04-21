package com.zem.jorge.ws.portfolioserv.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.zem.jorge.ws.portfolioserv.service.PortfolioService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PortfolioRestControllerTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    PortfolioService portfolioService;
	
	@Test
    public void getAllApplications() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8085/ws/portfolios")
                .contentType(MediaType.APPLICATION_JSON);
    	
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    	
	}
	
	@Test
    public void getApplicationById() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8085/ws/portfolio/555")
                .contentType(MediaType.APPLICATION_JSON);
    	
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
    public void createPortfolio() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8085/ws/createportfolio/2000/Soccer Player/image/Cristiano Ronaldo/@CR7Official")
                .contentType(MediaType.APPLICATION_JSON);
    	
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
    public void updatePortfolioDescription() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("http://localhost:8085/ws/updateportfoliodescription/2000/Soccer Player")
                .contentType(MediaType.APPLICATION_JSON);
    	
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        
        assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
}

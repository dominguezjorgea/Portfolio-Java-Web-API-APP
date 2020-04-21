package com.zem.jorge.portfolio.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zem.jorge.portfolio.model.Portfolio;
import com.zem.jorge.portfolio.repository.PortfolioRepository;
import com.zem.jorge.portfolio.service.PortfolioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PortfolioViewTest {
	
	@Autowired
	private PortfolioView controller;
	
	@Autowired
	private PortfolioService portfolioService;
	
	@Autowired
	private PortfolioRepository portfolioRepository;
	
    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
    
    @Test
    public void getPortfolios() throws Exception {
    	
    	List<Portfolio> listaPortfolios = controller.getPortfolios();
        assertThat(controller).isNotNull();
        assertEquals(listaPortfolios.size(), StreamSupport.stream(listaPortfolios.spliterator(), false).count());
    }
    
    @Test
    public void getPortfoliosFromService() throws Exception {
    	
    	List<Portfolio> listaPortfolios = portfolioService.listPortfolios();
        assertThat(controller).isNotNull();
        assertEquals(listaPortfolios.size(), StreamSupport.stream(listaPortfolios.spliterator(), false).count());
    }
    
    @Test
    public void getPortfoliosFromRepo() throws Exception {
    	
    	List<Portfolio> listaPortfolios = portfolioRepository.findAll();
        assertThat(controller).isNotNull();
        assertEquals(listaPortfolios.size(), StreamSupport.stream(listaPortfolios.spliterator(), false).count());
    }
    
    @Test
    public void getPortfolioById() throws Exception {
    	
    	List<Portfolio> listaPortfolios = controller.getPortfolios();
        assertThat(controller).isNotNull();
        
        for (Iterator<Portfolio> iterator = listaPortfolios.iterator(); iterator.hasNext();) {
			Portfolio portfolio = (Portfolio) iterator.next();
			Portfolio portfolio2 = portfolioService.findPortfolio(portfolio.getIdportfolio());
			assertThat(portfolio).isNotNull();
			assertThat(portfolio2).isNotNull();
		}
    }

}

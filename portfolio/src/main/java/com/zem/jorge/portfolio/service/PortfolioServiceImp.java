/**
 * 
 */
package com.zem.jorge.portfolio.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zem.jorge.portfolio.exception.PortfolioNotFoundException;
import com.zem.jorge.portfolio.model.Portfolio;
import com.zem.jorge.portfolio.repository.PortfolioRepository;

/**
 * @author Jorge A. Dominguez M
 *
 */

@Service
public class PortfolioServiceImp implements PortfolioService{
	
	@Autowired
	private PortfolioRepository portfolioRepository;

	@Override
	public List<Portfolio> listPortfolios() {
		return portfolioRepository.findAll();
	}

	@Override
	public Portfolio findPortfolio(Long id) {
		//Optional<Portfolio> opPortfolio = portfolioRepository.findOne(id);
		Portfolio portfolio = portfolioRepository.findOne(id);
		if(portfolio != null) {
			return portfolio;
		}else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}
}

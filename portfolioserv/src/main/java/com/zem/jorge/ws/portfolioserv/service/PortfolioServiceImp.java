/**
 * 
 */
package com.zem.jorge.ws.portfolioserv.service;

import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zem.jorge.ws.portfolioserv.exception.PortfolioNotFoundException;
import com.zem.jorge.ws.portfolioserv.model.Portfolio;
import com.zem.jorge.ws.portfolioserv.reporitory.PortfolioRepository;

/**
 * @author Jorge A. Dominguez M
 *
 */

@Service
public class PortfolioServiceImp implements PortfolioService {

	@Autowired
	private PortfolioRepository portfolioRepository;

	@Override
	public List<Portfolio> listPortfolios() {
		return portfolioRepository.findAll();
	}

	public Portfolio findPortfolio(long id) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(id);
		if (optionalPortfolio.isPresent()) {
			return optionalPortfolio.get();
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio updateCompletePortfolio(Long idportfolio, String description, String imageUrl, String title,
			String twitterUserName) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(idportfolio);

		if (optionalPortfolio.isPresent()) {
			Portfolio portfolio = optionalPortfolio.get();
			portfolio.setDescription(description);
			portfolio.setImageUrl(imageUrl);
			portfolio.setTitle(title);
			portfolio.setTwitterUserName(twitterUserName);
			portfolioRepository.save(portfolio);
			return portfolio;
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio updatePortfolioDescription(Long idportfolio, String description) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(idportfolio);

		if (optionalPortfolio.isPresent()) {
			Portfolio portfolio = optionalPortfolio.get();
			portfolio.setDescription(description);
			portfolioRepository.save(portfolio);
			return portfolio;
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio updatePortfolioImageUrl(Long idportfolio, String imageUrl) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(idportfolio);

		if (optionalPortfolio.isPresent()) {
			Portfolio portfolio = optionalPortfolio.get();
			portfolio.setImageUrl(imageUrl);
			portfolioRepository.save(portfolio);
			return portfolio;
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio updatePortfolioTitle(Long idportfolio, String title) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(idportfolio);

		if (optionalPortfolio.isPresent()) {
			Portfolio portfolio = optionalPortfolio.get();
			portfolio.setTitle(title);
			portfolioRepository.save(portfolio);
			return portfolio;
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio updatePortfolioTwitterUserName(Long idportfolio, String twitterUserName) {
		Optional<Portfolio> optionalPortfolio = portfolioRepository.findById(idportfolio);

		if (optionalPortfolio.isPresent()) {
			Portfolio portfolio = optionalPortfolio.get();
			portfolio.setTwitterUserName(twitterUserName);
			portfolioRepository.save(portfolio);
			return portfolio;
		} else {
			throw new PortfolioNotFoundException("Portfolio Not Found");
		}
	}

	public Portfolio createPorfolio(Long idportfolio, String description, String imageUrl, String title, String twitterUserName) {
		try {
			Portfolio portfolio = new Portfolio(idportfolio, description, imageUrl, title, twitterUserName);
			portfolioRepository.save(portfolio);
			return portfolio;
		} catch (Exception e) {
			throw new PortfolioNotFoundException("Error creating the Portfolio");
		}
	}
	
    public boolean deletePortfolio(Long id) {
    	try {
        	portfolioRepository.deleteById(id);
            return true;
			
		} catch (Exception e) {
			return false;
		}
    }

}

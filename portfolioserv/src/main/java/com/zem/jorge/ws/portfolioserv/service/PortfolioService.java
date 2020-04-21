package com.zem.jorge.ws.portfolioserv.service;

import java.util.List;

import com.zem.jorge.ws.portfolioserv.model.Portfolio;

/**
 * @author Jorge A. Dominguez M
 *
 */

public interface PortfolioService {
	
	//Search Portfolios
	List<Portfolio> listPortfolios();
	Portfolio findPortfolio(long id);
	
	//Update Portfolio
	Portfolio updateCompletePortfolio(Long idportfolio, String description, String imageUrl, String title, String twitterUserName);
	Portfolio updatePortfolioDescription(Long idportfolio, String description);
	Portfolio updatePortfolioImageUrl(Long idportfolio, String imageUrl);
	Portfolio updatePortfolioTitle(Long idportfolio, String title);
	Portfolio updatePortfolioTwitterUserName(Long idportfolio, String twitterUserName);
	
	//Create Portfolio
	Portfolio createPorfolio(Long idportfolio, String description, String imageUrl, String title, String twitterUserName);
	
	//Delete Portfolio
	boolean deletePortfolio(Long id);
	
}

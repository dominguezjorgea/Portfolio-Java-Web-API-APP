package com.zem.jorge.portfolio.service;

import java.util.List;

import com.zem.jorge.portfolio.model.Portfolio;

/**
 * @author Jorge A. Dominguez M
 *
 */

public interface PortfolioService {
	List<Portfolio> listPortfolios();
	Portfolio findPortfolio(Long id);

}

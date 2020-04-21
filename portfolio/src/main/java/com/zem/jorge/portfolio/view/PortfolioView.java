package com.zem.jorge.portfolio.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.zem.jorge.portfolio.model.Portfolio;
import com.zem.jorge.portfolio.service.PortfolioService;
import com.zem.jorge.portfolio.service.TwitterService;

import twitter4j.TwitterException;

@Named
public class PortfolioView implements Serializable {

	private static final long serialVersionUID = 1L;

	private PortfolioService portfolioService;
	
	private List<Portfolio> portfolios;
	private Portfolio portfolioSelected;
	private Portfolio portfolioQueried;
	
	
	private TwitterService twitterService;
	private List<String> twittersTimeLine;
	
    @Autowired
    public void setPortfolioService(PortfolioService portFolioService) {
        this.portfolioService = portFolioService;
    }

	@PostConstruct
	public void init() {
		portfolios = portfolioService.listPortfolios();
		twitterService = new TwitterService();
		
	}

	public List<Portfolio> getPortfolios() {
		return portfolios;
	}

	public String viewDetailSelectedPortfolio() {
		if (portfolioSelected != null) {
			setPortfolioQueried(portfolioService.findPortfolio(Long.valueOf(portfolioSelected.getIdportfolio().toString())));
			try {
				setTwittersTimeLine(twitterService.getTimeLine());
			} catch (TwitterException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Twitter", "Error getting the twitters timeline"));
			}
			return "/portfolio?faces-redirect=true";
		} else {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Potfolios", "Please select a portfolio"));
			return null;
		}
	}
	
	public String refreshPortfolios() {
		//FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(":menu-form:tableProfiles");
		this.portfolios = portfolioService.listPortfolios();
		this.portfolioQueried = null;
		this.portfolioSelected = null;
		RequestContext.getCurrentInstance().update(":menu-form:tableProfiles");
		return "/portfolios?faces-redirect=true";
	}

	public Portfolio getPortfolioSelected() {
		return portfolioSelected;
	}

	public void setPortfolioSelected(Portfolio portfolioSelected) {
		this.portfolioSelected = portfolioSelected;
	}

	public Portfolio getPortfolioQueried() {
		return portfolioQueried;
	}

	public void setPortfolioQueried(Portfolio portfolioQueried) {
		this.portfolioQueried = portfolioQueried;
	}

	public List<String> getTwittersTimeLine() {
		return twittersTimeLine;
	}

	public void setTwittersTimeLine(List<String> twittersTimeLine) {
		this.twittersTimeLine = twittersTimeLine;
	}
	
}

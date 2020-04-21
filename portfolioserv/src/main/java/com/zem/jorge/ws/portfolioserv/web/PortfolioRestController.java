/**
 * 
 */
package com.zem.jorge.ws.portfolioserv.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.zem.jorge.ws.portfolioserv.exception.PortfolioNotFoundException;
import com.zem.jorge.ws.portfolioserv.model.Portfolio;
import com.zem.jorge.ws.portfolioserv.service.PortfolioService;

/**
 * @author Jorge A. Dominguez M
 *
 */

@RestController
@RequestMapping("/ws")
public class PortfolioRestController {

	private PortfolioService portfolioService;

	@Autowired
	public void setPortfolioService(PortfolioService portFolioService) {
		this.portfolioService = portFolioService;
	}

	@GetMapping("/portfolios")
	public ResponseEntity<List<Portfolio>> getAllPortfolios() {
		List<Portfolio> list = portfolioService.listPortfolios();
		return new ResponseEntity<List<Portfolio>>(list, HttpStatus.OK);
	}
	
    @GetMapping("/portfolio/{id}")
    public ResponseEntity<Portfolio> getPortfolio(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.findPortfolio(id), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
   
    @GetMapping("/updatecompleteportfolio/{id}/{desc}/{img}/{title}/{twitterUserName}")
    public ResponseEntity<Portfolio> updateCompletePortfolio(@PathVariable("id") long idportfolio, 
    														 @PathVariable("desc") String description,
    														 @PathVariable("img") String imageUrl,
    														 @PathVariable("title") String title,
    														 @PathVariable("twitterUserName") String twitterUserName) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.updateCompletePortfolio(idportfolio, description, imageUrl, title, twitterUserName), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
    
    @GetMapping("/updateportfoliodescription/{id}/{desc}")
    public ResponseEntity<Portfolio> updatePortfolioDescription(@PathVariable("id") long idportfolio, 
    														 @PathVariable("desc") String description) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.updatePortfolioDescription(idportfolio, description), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
    
    @GetMapping("/updateportfolioimg/{id}/{img}")
    public ResponseEntity<Portfolio> updatePortfolioImg(@PathVariable("id") long idportfolio, 
    														 @PathVariable("img") String imageUrl) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.updatePortfolioImageUrl(idportfolio, imageUrl), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
    
    @GetMapping("/updateportfoliotitle/{id}/{title}")
    public ResponseEntity<Portfolio> updatePortfolioTitle(@PathVariable("id") long idportfolio, 
    														 @PathVariable("title") String title) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.updatePortfolioTitle(idportfolio, title), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
    
    @GetMapping("/updateportfoliotwitter/{id}/{twitterUserName}")
    public ResponseEntity<Portfolio> updatePortfolioTwitter(@PathVariable("id") long idportfolio, 
    														 @PathVariable("twitterUserName") String twitterUserName) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.updatePortfolioTwitterUserName(idportfolio, twitterUserName), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
    
    @GetMapping("/createportfolio/{id}/{desc}/{img}/{title}/{twitterUserName}")
    public ResponseEntity<Portfolio> createePortfolio(@PathVariable("id") long idportfolio, 
    														 @PathVariable("desc") String description,
    														 @PathVariable("img") String imageUrl,
    														 @PathVariable("title") String title,
    														 @PathVariable("twitterUserName") String twitterUserName) {
        try {
            return new ResponseEntity<Portfolio>(portfolioService.createPorfolio(idportfolio, description, imageUrl, title, twitterUserName), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creating the portofio, check the parameters");
        }
    }
    
    @GetMapping("/deleteportfolio/{id}")
    public ResponseEntity<Boolean> deletePortfolio(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<Boolean>(portfolioService.deletePortfolio(id), HttpStatus.OK);
        } catch (PortfolioNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Portfolio Not Found");
        }
    }
}

/**
 * 
 */
package com.zem.jorge.portfolio.service;

import java.util.List;
import java.util.stream.Collectors;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
//import twitter4j.conf.ConfigurationBuilder;

/**
 * @author Jorge A. Dominguez M
 *
 */

public class TwitterService {
	
	private Twitter twitter;
	
	public TwitterService() {
		/*ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("KRy7l0v8wex3w8Sy5zThai3Ea")
		  .setOAuthConsumerSecret("X2eBm0Y21kYEuR74W3Frqc2JVIizOj8Q1EVGatDsEVVEJo0ucu")
		  .setOAuthAccessToken("1220032047516921859-otvXjhExyUTZ5GLxssc9h5ORqtPZja")
		  .setOAuthAccessTokenSecret("tmJKqM4ORfQW6CH7wIVV8uKNpmSEmeFAP8lYwGb19uYjj");
		TwitterFactory tf = new TwitterFactory(cb.build());
		setTwitter(tf.getSingleton());*/
		
		twitter = TwitterFactory.getSingleton();
	}

	public List<String> getTimeLine() throws TwitterException {
		List<Status> statuses = twitter.getHomeTimeline();
		return statuses.stream().map(
				item -> item.getText()).collect(
						Collectors.toList());
	}

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

}

package com.intuit.developer.sampleapp.oauth2.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author dderose
 *
 */
@Configuration
@PropertySource(value="classpath:/application.properties", ignoreResourceNotFound=true)
public class OAuth2Configuration {

	@Autowired
	Environment env;

	public String getAppClientId() {
		return env.getProperty("OAuth2AppClientId");
	}

	public String getAppRedirectUri() {
		return env.getProperty("OAuth2AppRedirectUri");
	}

	public String getOAuth2Host() {
	  return env.getProperty("OAuth2Host");
	}

	public String getOAuth2AuthorizePath() {
		return env.getProperty("OAuth2AuthorizePath");
	}

	public String getOAuth2AccessTokenPath() {
		return env.getProperty("OAuth2AccessTokenPath");
	}
}

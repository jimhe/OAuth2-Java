package com.intuit.developer.sampleapp.oauth2.helper;

import com.intuit.developer.sampleapp.oauth2.domain.OAuth2Configuration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dderose
 *
 */
@Service
public class HttpHelper {

	@Autowired
    public OAuth2Configuration oAuth2Configuration;

	public StringBuffer getResult(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
		    result.append(line);
		}
		return result;
	}

	public URIBuilder getOAuth2UriBuilder() {
		return new URIBuilder().setScheme("https")
				.setHost(oAuth2Configuration.getOAuth2Host());
	}
}

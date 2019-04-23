package com.intuit.developer.sampleapp.oauth2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.developer.sampleapp.oauth2.domain.AccessToken;
import com.intuit.developer.sampleapp.oauth2.domain.OAuth2Configuration;
import com.intuit.developer.sampleapp.oauth2.helper.HttpHelper;
import javax.servlet.http.HttpSession;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dderose
 *
 */
@Service
public class RefreshTokenService {

    @Autowired
    public OAuth2Configuration oAuth2Configuration;

    @Autowired
    public HttpHelper httpHelper;

    private static final HttpClient CLIENT = HttpClientBuilder.create().build();
    private static final Logger logger = Logger.getLogger(RefreshTokenService.class);
    private static ObjectMapper mapper = new ObjectMapper();


    /**
     * Calls refresh endpoint to generate new tokens
     */
    public AccessToken refresh(HttpSession session) throws Exception {

        URIBuilder uriBuilder = httpHelper.getOAuth2UriBuilder()
            .setPath(oAuth2Configuration.getOAuth2AccessTokenPath())
            .addParameter("client_id", oAuth2Configuration.getAppClientId())
            .addParameter("redirect_uri", oAuth2Configuration.getAppRedirectUri())
            .setParameter("refresh_token", (String) session.getAttribute("refresh_token"))
            .setParameter("grant_type", "refresh_token");

        try {
            HttpPost post = new HttpPost(uriBuilder.build().toString());
            HttpResponse response = CLIENT.execute(post);

            if (response.getStatusLine().getStatusCode() != 200) {
                logger.info("failed getting companyInfo");
                throw new Exception();
            }

            StringBuffer result = httpHelper.getResult(response);

            return mapper.readValue(result.toString(), AccessToken.class);

        }
        catch (Exception ex) {
            logger.error("Exception while calling refreshToken ", ex);
            throw new Exception(ex);
        }

    }

}

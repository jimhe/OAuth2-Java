package com.intuit.developer.sampleapp.oauth2.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author dderose
 *
 */
@Controller
public class CallbackController {

  @Autowired
  public OAuth2Configuration oAuth2Configuration;

  @Autowired
  public HttpHelper httpHelper;

  private static final HttpClient CLIENT = HttpClientBuilder.create().build();
  private static ObjectMapper mapper = new ObjectMapper();
  private static final Logger logger = Logger.getLogger(CallbackController.class);

  /**
   *  This is the redirect handler you configure in your app on developer.intuit.com
   *  The Authorization code has a short lifetime.
   *  Hence Unless a user action is quick and mandatory, proceed to exchange the Authorization Code for
   *  BearerToken
   */
  @RequestMapping("/oauth2redirect")
  public String callBackFromOAuth(@RequestParam("state") String state,
      @RequestParam(value = "code", required = false) String code,
      @RequestParam(value = "error", required = false) String error,
      HttpSession session) {
    if (error != null) {
      session.setAttribute("error", error);
      return "error";
    }

    String csrfToken = (String) session.getAttribute("csrfToken");
    if (csrfToken.equals(state)) {
      session.setAttribute("auth_code", code);
      AccessToken accessToken = retrieveToken(code);

      /*
       * save token to session
       * In real usecase, this is where tokens would have to be persisted (to a SQL DB, for example).
       * Update your Datastore here with user's AccessToken and RefreshToken along with the realmId
       */
      session.setAttribute("access_token", accessToken.getAccessToken());
      session.setAttribute("refresh_token", accessToken.getRefreshToken());

      return "connected";
    }
    logger.info("csrf token mismatch ");
    return null;
  }

  private AccessToken retrieveToken(String auth_code) {
    URIBuilder uriBuilder = httpHelper.getOAuth2UriBuilder()
        .setPath(oAuth2Configuration.getOAuth2AccessTokenPath())
        .addParameter("client_id", oAuth2Configuration.getAppClientId())
        .addParameter("redirect_uri", oAuth2Configuration.getAppRedirectUri())
        .setParameter("code", auth_code)
        .setParameter("grant_type", "authorization_code");

    try {
      HttpPost post = new HttpPost(uriBuilder.build().toString());
      HttpResponse response = CLIENT.execute(post);

      if (response.getStatusLine().getStatusCode() != 200) {
        logger.info("failed getting access token");
        return null;
      }

      StringBuffer result = httpHelper.getResult(response);
      logger.debug("raw result for bearer tokens= " + result);

      return mapper.readValue(result.toString(), AccessToken.class);
    } catch (Exception ex) {
      logger.error("Exception while retrieving bearer tokens", ex);
    }
    return null;
  }
}

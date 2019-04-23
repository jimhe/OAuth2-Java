package com.intuit.developer.sampleapp.oauth2.controller;

import com.intuit.developer.sampleapp.oauth2.domain.OAuth2Configuration;
import com.intuit.developer.sampleapp.oauth2.helper.HttpHelper;
import java.net.URISyntaxException;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;


/**
 * @author dderose
 *
 */
@Controller
public class OAuth2Controller {

  @Autowired
  public OAuth2Configuration oAuth2Configuration;

  @Autowired
  public HttpHelper httpHelper;

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @RequestMapping("/connected")
  public String connected() {
    return "connected";
  }

  /**
   * Controller mapping for signInWithReviewBoard button
   */
  @RequestMapping("/signInWithReviewBoard")
  public View signInWithReviewBoard(@RequestParam(value = "scope", required = false) String scope,
      HttpSession session) {
    String url = prepareUrl(scope, generateCSRFToken(session));
    return new RedirectView(url, true, true, false);
  }

  private String prepareUrl(String scope, String csrfToken) {
    try {
      URIBuilder builder = httpHelper.getOAuth2UriBuilder()
          .setHost(oAuth2Configuration.getOAuth2Host())
          .setPath(oAuth2Configuration.getOAuth2AuthorizePath())
          .addParameter("client_id", oAuth2Configuration.getAppClientId())
          .addParameter("response_type", "code")
          .addParameter("redirect_uri", oAuth2Configuration.getAppRedirectUri())
          .addParameter("state", csrfToken);

      if (!StringUtils.isEmpty(scope)) {
        builder.addParameter("scope", scope);
      }

      return builder.build().toString();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    return null;
  }

  private String generateCSRFToken(HttpSession session) {
    String csrfToken = UUID.randomUUID().toString();
    session.setAttribute("csrfToken", csrfToken);
    return csrfToken;
  }
}

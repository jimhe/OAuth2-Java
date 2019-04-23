package com.intuit.developer.sampleapp.oauth2.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.developer.sampleapp.oauth2.domain.AccessToken;
import com.intuit.developer.sampleapp.oauth2.domain.OAuth2Configuration;
import com.intuit.developer.sampleapp.oauth2.helper.HttpHelper;
import com.intuit.developer.sampleapp.oauth2.service.RefreshTokenService;

/**
 * @author dderose
 *
 */
@Controller
public class RefreshTokenController {

	@Autowired
    public OAuth2Configuration oAuth2Configuration;

	@Autowired
	public HttpHelper httpHelper;

	@Autowired
	public RefreshTokenService refreshTokenService;

	private static final Logger logger = Logger.getLogger(RefreshTokenController.class);

    /**
     * Call to refresh tokens
     */
	@ResponseBody
    @RequestMapping("/refreshToken")
    public String refreshToken(HttpSession session) {

    	String failureMsg="Failed";

        try {
            AccessToken accessToken = refreshTokenService.refresh(session);
            session.setAttribute("access_token", accessToken.getAccessToken());
            session.setAttribute("refresh_token", accessToken.getRefreshToken());
            return new JSONObject()
                    .put("access_token", accessToken.getAccessToken())
                    .put("refresh_token", accessToken.getRefreshToken()).toString();
        }
        catch (Exception ex) {
        	logger.error("Exception while calling refreshToken ", ex);
        	return new JSONObject().put("response",failureMsg).toString();
        }

    }

}

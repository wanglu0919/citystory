package com.wanglu.citystory.service;

import com.wanglu.citystory.entity.OAuth;

public interface IOAuthService {

	public boolean addOAuth(OAuth oAuth);

	public boolean deleteByUserId(String userId);

	public OAuth findOAuthByAccessToken(String accessToken);

	public boolean updateOauthByRefreshToken(OAuth oAuth);
	
	
	public OAuth findOauthByUserId(String userId);
}

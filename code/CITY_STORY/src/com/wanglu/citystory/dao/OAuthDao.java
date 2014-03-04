package com.wanglu.citystory.dao;

import com.wanglu.citystory.entity.OAuth;

public interface OAuthDao {

	public boolean add(OAuth oAuth);
	
	public boolean deleteByUserId(String userId);
	
	public OAuth findOAuthByAccessToken(String accessToken);
	
	public boolean updateOauthByRefreshToken(OAuth oAuth);
	
	
	public OAuth findOauthByUserId(String userId);
	
}

package com.wanglu.citystory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wanglu.citystory.dao.OAuthDao;
import com.wanglu.citystory.entity.OAuth;
import com.wanglu.citystory.service.IOAuthService;

@Service("oauthService")
public class OAuthServiceImpl implements IOAuthService {

	@Resource
	OAuthDao oAuthDao;
	@Override
	public boolean addOAuth(OAuth oAuth) {
		return oAuthDao.add(oAuth);
		
	}

	@Override
	public boolean deleteByUserId(String userId) {
		return oAuthDao.deleteByUserId(userId);
	}

	@Override
	public OAuth findOAuthByAccessToken(String accessToken) {
		return oAuthDao.findOAuthByAccessToken(accessToken);
	}

	@Override
	public boolean updateOauthByRefreshToken(OAuth oAuth) {
		return oAuthDao.updateOauthByRefreshToken(oAuth);
	}

	@Override
	public OAuth findOauthByUserId(String userId) {
		
		return oAuthDao.findOauthByUserId(userId);
	}

}

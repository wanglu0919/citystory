package com.wanglu.citystory.util;

import java.util.UUID;

import com.wanglu.citystory.entity.OAuth;

public class OAuthGenerator {

	public static OAuth generateOAuth(String userId) {

		OAuth oAuth = new OAuth();
		oAuth.setUserId(userId);
		oAuth.setAccessToken(Md5Util.md5(UUID.randomUUID().toString()));
		oAuth.setRefreshToken(Md5Util.md5(UUID.randomUUID().toString()));
		oAuth.setUpdateTime(System.currentTimeMillis());
		return oAuth;

	}
}

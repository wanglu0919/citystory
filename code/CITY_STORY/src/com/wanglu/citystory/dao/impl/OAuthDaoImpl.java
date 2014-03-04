package com.wanglu.citystory.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.wanglu.citystory.dao.OAuthDao;
import com.wanglu.citystory.entity.OAuth;

public class OAuthDaoImpl extends BaseImpl implements OAuthDao {

	@Override
	public boolean add(OAuth oAuth) {
		SqlSession sqlSession = getSession();

		int reslut = sqlSession.insert("addOauth", oAuth);

		sqlSession.close();

		return reslut != 0;
	}

	@Override
	public boolean deleteByUserId(String userId) {
		SqlSession sqlSession = getSession();
		int result = sqlSession.delete("deleteOauthByUserId", userId);
		sqlSession.close();

		return result != 0;
	}

	@Override
	public OAuth findOAuthByAccessToken(String accessToken) {

		SqlSession sqlSession = getSession();
		OAuth oa = sqlSession.selectOne("findOauthByAccessToken", accessToken);
		sqlSession.close();

		return oa;
	}

	@Override
	public boolean updateOauthByRefreshToken(OAuth oAuth) {
		SqlSession sqlSession = getSession();
		int result = sqlSession.update("updateOauthAccessToken", oAuth);
		sqlSession.close();
		return result != 0;
	}

	@Override
	public OAuth findOauthByUserId(String userId) {

		SqlSession sqlSession = getSession();
		OAuth oa = sqlSession.selectOne("findOauthByUserId", userId);
		sqlSession.close();

		return oa;
	}

}

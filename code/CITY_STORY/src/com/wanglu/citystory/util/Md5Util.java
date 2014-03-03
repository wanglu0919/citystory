package com.wanglu.citystory.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	public static String md5(String str){
		
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
			byte []enData=digest.digest(str.getBytes());
			StringBuffer sb=new StringBuffer("");
			for(int i=0;i<enData.length;i++){
				
			String code=Integer.toHexString(0xff & enData[i]);
			if(code.length()==1){
				sb.append("0"+code);
			}else{
				sb.append(code);
			}
				
			}
			
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
}

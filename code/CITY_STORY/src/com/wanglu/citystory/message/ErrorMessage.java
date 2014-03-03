package com.wanglu.citystory.message;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

	public static final Map<Integer, String > msgHashMap=new HashMap<Integer,String>(); 
	
	public static final Integer CODE_FORMAT_ERROR=1000;
	
	
	
	
	
	
	
	static{
		
	
		msgHashMap.put(CODE_FORMAT_ERROR, "数据格式错误");
		
		
	}
	
	
	public static String getEmsg(int errorCode){
		
		return msgHashMap.get(errorCode);
	}
}

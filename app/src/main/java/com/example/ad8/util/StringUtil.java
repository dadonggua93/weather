package com.example.ad8.util;

public class StringUtil {

	public static boolean isBlank(String val){
		return val == null || val.equals("");
	}

	public static boolean isNotBlank(String val){
		return val != null && !val.equals("");
	}

}

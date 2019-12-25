package com.di3.token;

import java.nio.charset.Charset;
import java.util.Random;

public class Token {
	private static String token;
	private static int role;
	
	public Token() {
		
	}
	public Token(int role) {
		Token.role = role;
	}
	public String getToken() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    token = generatedString;
	    return token;
	}
	public void setToken(String token) {
		Token.token = token;
	}
	public int getRole() {
		return role;
	}
	public boolean checkToken(String token) {
		if(Token.token.equals(token)) {
			return true;
		}
		else {
			return false;
		}
	}
}

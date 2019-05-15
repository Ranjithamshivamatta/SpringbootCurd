package com.bridgelabz.fundonoteapp.util;

public interface JsonToken {
	
	public int tokenVerification(String token);
	public String jwtToken(String secretKey, int id);
}
package com.bridgelabz.fundonoteapp.util;

public interface Token1 {
	public int tokenVerification(String token);

	public String jwtToken(String secretKey, int id);

}

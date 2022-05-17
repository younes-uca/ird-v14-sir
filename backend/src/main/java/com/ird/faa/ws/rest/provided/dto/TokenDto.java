package com.ird.faa.ws.rest.provided.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenDto {
   @JsonProperty("access_token")
   private String accessToken;
   
   @JsonProperty("token_type")
   private String tokenType;
   
   @JsonProperty("expires_in")
   private String expiresIn;
   
	public TokenDto() {
	super();
}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
   
}

package com.javastrava.auth;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

public class AuthConfig {

	private int clientId;
	
	private String clientSecret;
	
	private String authCode;
	
	public AuthConfig() {
		
		String dir = "test/test-config.properties";
		try {
			Properties prop = new Properties();			
			InputStream input = Files.newInputStream(Paths.get(dir), StandardOpenOption.READ);
			prop.load(input);
			
			this.clientId = Integer.parseInt(prop.getProperty("clientId"));
			this.clientSecret = prop.getProperty("clientSecret");
			this.authCode = prop.getProperty("authCode");
		} catch (IOException e) {
			throw new RuntimeException("Config file in " + dir + " not found.", e);
		}
	}

	public AuthConfig(int clientId, String clientSecret, String authCode) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.authCode = authCode;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
}

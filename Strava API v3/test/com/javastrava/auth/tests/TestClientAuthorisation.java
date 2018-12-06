package com.javastrava.auth.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.javastrava.auth.AuthConfig;

import javastrava.auth.AuthorisationService;
import javastrava.auth.impl.AuthorisationServiceImpl;
import javastrava.auth.model.Token;
import javastrava.auth.ref.AuthorisationScope;
import javastrava.service.Strava;

public class TestClientAuthorisation {

	private static Strava strava = null;
	
	@BeforeClass
	public static void setUp() {
		
		AuthConfig config = new AuthConfig();
		AuthorisationService authService = new AuthorisationServiceImpl();
		Token token = authService.tokenExchange(config.getClientId(), 
				config.getClientSecret(), 
				config.getAuthCode(), 
				AuthorisationScope.ACTIVITY_READ_ALL,
				AuthorisationScope.PROFILE_WRITE);
		strava = new Strava(token);
	}
	
	@Test
	public void testUserAuthenticated() {
		
		int athleteId = strava.getAuthenticatedAthlete().getId().intValue();
		assertEquals(2402700, athleteId);
	}
	
	@Test
	public void testCorrectAuthScopes() {
		
		boolean hasExactAuthScopes = strava.hasExactAuthorisationScopes(AuthorisationScope.ACTIVITY_READ_ALL, AuthorisationScope.PROFILE_WRITE);
		assertEquals(true, hasExactAuthScopes);
	}
	
	@Test
	public void testIncorrectAuthScopes() {
		
		boolean hasExactAuthScopes = strava.hasExactAuthorisationScopes(AuthorisationScope.ACTIVITY_WRITE, AuthorisationScope.READ_ALL);
		assertEquals(false, hasExactAuthScopes);
	}
}

package javastrava.auth.ref;

import javastrava.config.Messages;
import javastrava.config.StravaConfig;
import javastrava.json.impl.serializer.AuthorisationScopeSerializer;

/**
 * <p>
 * read_all, profile:read_all, profile:write, activity:read, activity:read_all, activity:write or leave blank for read-only permissions.
 * </p>
 *
 * @author Dan Shannon
 */
public enum AuthorisationScope {
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API read private routes, private segments, and private events for the user
	 * </p>
	 */
	READ_ALL(StravaConfig.string("AuthorisationScope.read_all"), Messages.string("AuthorisationScope.read_all.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API to read all profile information even if the user has set their profile visibility to Followers or Only You
	 * </p>
	 */
	PROFILE_READ_ALL(StravaConfig.string("AuthorisationScope.profile_read_all"), Messages.string("AuthorisationScope.profile_read_all.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API to update the user's weight and Functional Threshold Power (FTP), and access to star or unstar segments on their behalf
	 * </p>
	 */
	PROFILE_WRITE(StravaConfig.string("AuthorisationScope.profile_write"), Messages.string("AuthorisationScope.profile_write.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API to read the user's activity data for activities that are visible to Everyone and Followers, excluding privacy zone data
	 * </p>
	 */
	ACTIVITY_READ(StravaConfig.string("AuthorisationScope.activity_read"), Messages.string("AuthorisationScope.activity_read.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API the same access as activity:read, plus privacy zone data and access to read the user's activities with visibility set to Only You
	 * </p>
	 */
	ACTIVITY_READ_ALL(StravaConfig.string("AuthorisationScope.activity_read_all"), Messages.string("AuthorisationScope.activity_read_all.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * This authorisation scope allows the Strava API to access to create manual activities and uploads, and access to edit any activities that are visible to the app, based on activity read access level
	 * </p>
	 */
	ACTIVITY_WRITE(StravaConfig.string("AuthorisationScope.activity_write"), Messages.string("AuthorisationScope.activity_write.description")),  //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * Should never occur but may if the Strava API behaviour has changed
	 * </p>
	 */
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description")); //$NON-NLS-1$ //$NON-NLS-2$
	
	/**
	 * <p>
	 * Used when deserialising JSON returned by the Strava API
	 * </p>
	 * @see AuthorisationScopeSerializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 * @param id String value returned by Strava
	 * @return Returns the matching instance of {@link AuthorisationScope}, or {@link AuthorisationScope#UNKNOWN} if there is no match
	 */
	public static AuthorisationScope create(final String id) {
		for (final AuthorisationScope scope : AuthorisationScope.values()) {
			if (scope.getId().equals(id)) {
				return scope;
			}
		}
		return AuthorisationScope.UNKNOWN;
	}

	/**
	 * Identifier
	 */
	private String id;

	/**
	 * Description of the auth scope
	 */
	private String description;

	/**
	 * <p>
	 * Private constructor because this is, after all, an enum
	 * </p>
	 *
	 * @param id Identifier
	 * @param description Description
	 */
	private AuthorisationScope(final String id, final String description) {
		this.id = id;
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @see AuthorisationScopeSerializer#serialize(AuthorisationScope, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}

}

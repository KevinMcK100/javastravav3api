package javastrava.json.impl.serializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import javastrava.model.reference.StravaStreamType;

/**
 * @author Dan Shannon
 *
 */
public class StreamTypeSerializer implements JsonSerializer<StravaStreamType>, JsonDeserializer<StravaStreamType> {

	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type,
	 *      com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public StravaStreamType deserialize(final JsonElement json, final Type type, final JsonDeserializationContext context) throws JsonParseException {
		return StravaStreamType.create(json.getAsString());
	}

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type,
	 *      com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(final StravaStreamType streamType, final Type type, final JsonSerializationContext context) {
		return context.serialize(streamType.getValue());
	}

}

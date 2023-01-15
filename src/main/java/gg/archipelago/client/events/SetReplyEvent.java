package gg.archipelago.client.events;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.Primitives;

public class SetReplyEvent implements Event {
    @SerializedName("key")
    public String key;
    @SerializedName("value")
    public Object value;
    @SerializedName("original_value")
    public Object original_value;

    private final int requestID;

    private final JsonElement jsonValue;

    public SetReplyEvent(String key, Object value, Object original_value, JsonElement jsonValue, int requestID) {
        this.key=key;
        this.value=value;
        this.original_value=original_value;
        this.jsonValue = jsonValue;
        this.requestID = requestID;
    }

    public <T> T getValueAsObject(Class<T> classOfT) {
        Object value = new Gson().fromJson(jsonValue,classOfT);
        return Primitives.wrap(classOfT).cast(value);
    }

    public int getRequestID() {
        return requestID;
    }
}

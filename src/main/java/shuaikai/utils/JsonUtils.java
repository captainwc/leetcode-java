package shuaikai.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import shuaikai.utils.exception.LCExceptionFactory;

/**
 * Wrapper of {@link Gson}, for stream operation.
 *
 * @author shuaikai
 */
public class JsonUtils {
    public static JsonBuilder newObj() {
        return new JsonBuilder();
    }

    public static JsonBuilder newArray() {
        return new JsonBuilder();
    }

    public static String formatObj(JsonObject json) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(json);
    }

    public static class JsonBuilder {
        private final JsonObject jsonObject = new JsonObject();
        private final JsonArray jsonArray = new JsonArray();

        public JsonBuilder add2Obj(String key, Object value) {
            if (value instanceof JsonElement) {
                jsonObject.add(key, ((JsonElement) value));
            } else if (value instanceof String) {
                jsonObject.addProperty(key, ((String) value));
            } else if (value instanceof Number) {
                jsonObject.addProperty(key, ((Number) value));
            } else if (value instanceof Boolean) {
                jsonObject.addProperty(key, ((Boolean) value));
            } else if (value instanceof Character) {
                jsonObject.addProperty(key, ((Character) value));
            } else {
                throw LCExceptionFactory.genRuntimeException("Unsupported json property");
            }
            return this;
        }

        public JsonBuilder add2Array(Object value) {
            if (value instanceof JsonElement) {
                jsonArray.add((JsonElement) value);
            } else if (value instanceof String) {
                jsonArray.add((String) value);
            } else if (value instanceof Number) {
                jsonArray.add((Number) value);
            } else if (value instanceof Boolean) {
                jsonArray.add((Boolean) value);
            } else if (value instanceof Character) {
                jsonArray.add((Character) value);
            } else {
                throw LCExceptionFactory.genRuntimeException("Unsupported json property");
            }
            return this;
        }

        public JsonObject buildObj() {
            return jsonObject;
        }

        public JsonArray buildArray() {
            return jsonArray;
        }
    }
}

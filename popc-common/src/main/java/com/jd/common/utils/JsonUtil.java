package com.jd.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {
    public static String toJson(Object data) {
        return toJsonJackJson(data);
    }

    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return readValueToObject(json, clazz);
        } catch (Exception var3) {
            return null;
        }
    }

    public static String writeObjectToJson(Object object) throws Exception {
        if (ObjectUtil.isEmpty(object)) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(Include.NON_NULL);
            return objectMapper.writeValueAsString(object);
        }
    }

    public static <T> T readValueToObject(String json, Class<T> tClass) throws Exception {
        if (ObjectUtil.isEmpty(json)) {
            return null;
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, tClass);
        }
    }

    public static String toJson(Object data, JsonUtil.JsonType type) {
        return toJsonJackJson(data);
    }

    private static String toJsonJackJson(Object data) {
        if (ObjectUtil.isEmpty(data)) {
            return "";
        } else {
            try {
                return writeObjectToJson(data);
            } catch (Exception var2) {
                return toString(data);
            }
        }
    }

    public static String toString(Object data) {
        return data != null ? data.toString() : null;
    }

    public static <T> String pretty(String data, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        try {
            T value = mapper.readValue(data, clazz);
            return mapper.writeValueAsString(value);
        } catch (Exception var4) {
            return data;
        }
    }

    public static enum JsonType {
        alibaba,
        jackJson;

        private JsonType() {
        }
    }
}

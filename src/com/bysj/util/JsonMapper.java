package com.bysj.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class JsonMapper extends ObjectMapper {
	public JsonMapper() {

        super();

        // null值转空字符串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object value, JsonGenerator generator, SerializerProvider provider) throws IOException {
                generator.writeString("");
            }
        });

        // 不返回时间戳格式
        this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 遇到不认识的字段，不抛异常
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 指定自己想要的日期格式，如：yyyy-MM-dd HH:mm:ss
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    }
}

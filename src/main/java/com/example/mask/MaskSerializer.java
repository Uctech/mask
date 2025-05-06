package com.example.mask;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

public class MaskSerializer extends JsonSerializer<Object>{
    private boolean partial = false;
    public MaskSerializer(){}
    public MaskSerializer(boolean partial){
        this.partial = partial;
    }

    @Override
    public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(Objects.nonNull(value)){
            jsonGenerator.writeString(applyMask(value.toString()));
        }else
            jsonGenerator.writeNull();
    }

    private String applyMask(String value) {
        if (value == null || value.isEmpty()) return null;
        if (partial) {
            var charCount = value.length();
            if (charCount <= 4) return  "******";
            return    "******" + value.substring( charCount - 4, charCount);
        }
        return "******";
    }
}

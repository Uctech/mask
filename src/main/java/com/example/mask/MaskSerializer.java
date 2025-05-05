package com.example.mask;

import com.example.mask.enums.MaskingStyle;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Objects;

public class MaskSerializer extends JsonSerializer<Object>{
    private MaskingStyle style = MaskingStyle.FULL;
    public MaskSerializer(){}
    public MaskSerializer(MaskingStyle style){
        this.style = style;
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
        return switch (style) {
            case FULL -> "******";
            case PARTIAL -> {
                var charCount = value.length();
                if (charCount <= 4) yield "******";
                yield   "******" + value.substring( charCount - 4, charCount);
            }
        };
    }
}

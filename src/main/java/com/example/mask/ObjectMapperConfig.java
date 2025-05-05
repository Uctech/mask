package com.example.mask;

import com.fasterxml.jackson.databind.ObjectMapper;
public class ObjectMapperConfig {
    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setAnnotationIntrospector(new MaskAnnotationIntrospector());
        return mapper;
    }
}

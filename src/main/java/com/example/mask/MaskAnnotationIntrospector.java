package com.example.mask;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

public class MaskAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated annotated) {
        Mask mask = annotated.getAnnotation(Mask.class);
        if (mask != null) {
            return MaskSerializer.class;
        }
        return super.findSerializer(annotated);
    }
}

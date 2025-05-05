package com.example.mask;

import java.lang.reflect.Field;

public class MaskingUtil {
    public static String toMaskedSensitiveFieldsString(Object obj) {
        StringBuilder sb = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                sb.append("\"")
                        .append(field.getName())
                        .append("\": \"");

                if (field.isAnnotationPresent(Mask.class)) {
                    sb.append("****");
                } else {
                    sb.append(field.get(obj));
                }

                sb.append("\", ");
            } catch (IllegalAccessException e) {
                sb.append("\"error\": \"access denied\", ");
            }
        }

        if (sb.length() > 1) sb.setLength(sb.length() - 2); // remove trailing comma
        sb.append("}");
        return sb.toString();
    }
}

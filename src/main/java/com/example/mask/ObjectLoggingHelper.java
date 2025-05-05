package com.example.mask;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

public class ObjectLoggingHelper {

    private static ObjectLoggingHelper instance;
    private ObjectMapper objectMapper;

    private ObjectLoggingHelper() {
        objectMapper = ObjectMapperConfig.getObjectMapper();
    }

    public static ObjectLoggingHelper getInstance() {
        if (instance == null) {
            instance = new ObjectLoggingHelper();
        }

        return instance;
    }

    public void responseObject(Logger logger, Object object) {
        String x = "{}";
        try {
            x = objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        logger.info("{\"responseObject\":{}{}",x,  "}");
    }

    public void requestObject(Logger logger, Object object) {
        String x = "{}";
        try {
            x = objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }

        logger.info("{\"requestObject\":{}{}",x, "}");
    }
}

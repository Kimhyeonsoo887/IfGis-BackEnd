package com.group.ifgis.main.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ComConfig {

    public static String uploadDir;

    public ComConfig(@Value("${uploadDir}") String uploadDir) {
        this.uploadDir = uploadDir;
    }
}

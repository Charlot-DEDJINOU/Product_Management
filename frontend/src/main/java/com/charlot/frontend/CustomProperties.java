package com.charlot.frontend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.charlot.frontend")

public class CustomProperties {
    
 private String apiUrl;
}

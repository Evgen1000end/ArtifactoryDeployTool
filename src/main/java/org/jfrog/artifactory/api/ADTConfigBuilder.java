package org.jfrog.artifactory.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ADTConfigBuilder {

    private ObjectMapper mapper = new ObjectMapper();

    public ADTConfig build(String configPath){
        ADTConfig config;
        try {
            config = mapper.readValue(new File(configPath), ADTConfig.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

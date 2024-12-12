package com.project.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ConfigMarvel {

    @ConfigProperty(name = "marvel.apikey.private")
    private String apiKeyPrivate;
    @ConfigProperty(name = "marvel.apikey.public")
    private String apiKeyPublic;

    @ConfigProperty(name = "marvel.base.url")
    private String apiURL;
    private long timeStamp = System.currentTimeMillis();

    public String getHash() {
        return DigestUtils.md5Hex(timeStamp + apiKeyPrivate + apiKeyPublic);
    }

    public String getApiKeyPublic() { return apiKeyPublic; }

    public long getTimeStamp() { return timeStamp; }

    public String geBaseURL(){
        return apiURL;
    }
}

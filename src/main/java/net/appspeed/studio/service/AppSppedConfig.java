package net.appspeed.studio.service;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(value ="spring.datasource.hikari")
public class AppSppedConfig {


    private String platform;

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }


}

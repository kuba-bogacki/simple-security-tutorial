package com.simple.security.tutorial.security.jwt;

import com.google.common.net.HttpHeaders;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@NoArgsConstructor
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class JwtConfiguration {

    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    @Autowired
    public JwtConfiguration(
            @Value("${application.jwt.secretKey:}") String secretKey,
            @Value("${application.jwt.tokenPrefix:}") String tokenPrefix,
            @Value("${application.jwt.tokenExpirationAfterDays:}") Integer tokenExpirationAfterDays) {
        this.secretKey = secretKey;
        this.tokenPrefix = tokenPrefix;
        this.tokenExpirationAfterDays = tokenExpirationAfterDays;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}

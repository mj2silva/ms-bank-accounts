package com.ms.accounts.service.client;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Configuration
@Slf4j
public class FeignClientConfig {

    private static final String CORRELATION_ID_HEADER_NAME = "X-MsBank-Correlation-Id";

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            var attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (attributes != null) {
                var request = attributes.getRequest();
                var correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
                log.debug("MSBank-Correlation-Id: {}", correlationId);
                if (correlationId != null) {
                    requestTemplate.header(CORRELATION_ID_HEADER_NAME, correlationId);
                }
            }
        };
    }
}

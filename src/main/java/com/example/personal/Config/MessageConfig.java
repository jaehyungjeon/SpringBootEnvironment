package com.example.personal.Config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageConfig {

    /*
     * multi messages properties path
     * @ref : application.yml
     **/
    @Value("${spring.messages.basename}")
    public String[] messagePath;

    @Value("${spring.messages.encoding}")
    public String encoding;

    @Bean
    public MessageSource MessageSource() throws Exception {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(messagePath);
        messageSource.setDefaultEncoding(encoding);
        messageSource.setFallbackToSystemLocale(false);
        return messageSource;
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor() throws Exception {
        return new MessageSourceAccessor(MessageSource());
    }
}

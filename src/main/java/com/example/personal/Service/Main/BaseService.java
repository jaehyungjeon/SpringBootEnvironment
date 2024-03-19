package com.example.personal.Service.Main;

import com.example.personal.Boot.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public abstract class BaseService extends LoggerFactory {

    @Autowired
    public MessageSourceAccessor messageSourceAccessor;

    public String Message(String url) {
        return Message(url, "");
    }

    public String Message(String url, String defaultString) {
        return Message(url, defaultString, Locale.US);
    }

    public String Message(String url, String defaultString, Locale locale) {
        return messageSourceAccessor.getMessage(url, defaultString, locale);
    }
}
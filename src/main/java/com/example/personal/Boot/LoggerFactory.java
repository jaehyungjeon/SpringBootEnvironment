package com.example.personal.Boot;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public abstract class LoggerFactory {
    public final Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
}
